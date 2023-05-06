package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.navigation.ui.AppBarConfiguration;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Authenticator;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import com.example.clase1.R;
import com.example.clase1.Utilidades.Util;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;


public class CreateUser extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;

    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    EditText u_nombre,u_apellido,u_telefono,u_usuario,u_contra;
    Button btn_cancel_create_user,btn_create_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        btn_create_user = findViewById(R.id.btn_create_user);
        btn_cancel_create_user = findViewById(R.id.btn_cancel_create_user);
        u_nombre = findViewById(R.id.u_nombre);
        u_apellido = findViewById(R.id.u_apellido);
        u_telefono = findViewById(R.id.u_telefono);
        u_usuario = findViewById(R.id.u_usuario);
        u_contra = findViewById(R.id.u_contra);
        requestQueue = Volley.newRequestQueue(this);

        btn_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
                Intent i = new Intent(CreateUser.this, Login.class);
                startActivity(i);
            }
        });
        btn_cancel_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateUser.this, Login.class);
                startActivity(i);
            }
        });
    }
    private void guardar() {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Insertando");
        progreso.show();

        String nom = u_nombre.getText().toString();
        String ape = u_apellido.getText().toString();
        String tel = u_telefono.getText().toString();
        String usu = u_usuario.getText().toString();
        String con = u_contra.getText().toString();

        String url = Util.RUTA + "create_user.php?u_nombre=" + nom +
                     "&u_apellido=" + ape +"&u_telefono=" + tel+"&u_usuario="+ usu+"&u_contra="+ con;
        url=url.replace(" ","%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,new JSONObject(), this::onResponse, this::onErrorResponse);
        requestQueue.add(jsonObjectRequest);
    }
    public void onResponse(JSONObject response) {
        progreso.hide();
        Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();
    }
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
    }
}