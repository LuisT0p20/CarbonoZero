package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.clase1.Utilidades.Util;

import org.json.JSONObject;
import android.text.TextUtils;
import android.app.ProgressDialog;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    EditText edt_usuario, edt_contra;
    Button btn_login;
    TextView txt_create;
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        txt_create = findViewById(R.id.txt_create);

        edt_usuario = findViewById(R.id.edt_usuario);
        edt_contra = findViewById(R.id.edt_contra);

        requestQueue = Volley.newRequestQueue(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificar();
            }
        });
        txt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, CreateUser.class);
                startActivity(i);
            }
        });

    }
    private void verificar() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Buscando");
        progreso.show();

        String us = edt_usuario.getText().toString();
        String co = edt_contra.getText().toString();

        String url = Util.RUTA + "verificar_usuario.php?u_usuario=" + us +
                "&u_contra=" + co;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progreso.hide();
                        try {
                            String mensaje = response.getJSONArray("tb_usuario").getJSONObject(0).getString("mensaje");

                            Toast.makeText(Login.this, mensaje, Toast.LENGTH_SHORT).show();
                            if(mensaje.contains("Bienvenido")){
                                Intent i = new Intent(Login.this, MainActivity.class);
                                startActivity(i);
                            }
                        } catch (Exception e) {
                            Toast.makeText(Login.this, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progreso.hide();
                        Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

}