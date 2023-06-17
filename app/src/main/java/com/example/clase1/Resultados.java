package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.clase1.Utilidades.Util;

import org.json.JSONObject;

import java.util.Date;
import java.text.SimpleDateFormat;
public class Resultados extends AppCompatActivity {
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    TextView txtResultado,nombre, fecha, txtGravedad;
    Float consumo;
    String nombre_usuario = "";
    ImageView imageResult;
    Button btnbackMenu;

    // Obtener la fecha actual
    Date fechaActual = new Date();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        txtResultado = findViewById(R.id.txtResultado);
        nombre = findViewById(R.id.nombre);
        fecha = findViewById(R.id.fecha);
        imageResult = findViewById(R.id.imageResult);
        txtGravedad = findViewById(R.id.txtGravedad);
        btnbackMenu = findViewById(R.id.btnbackMenu);


        requestQueue = Volley.newRequestQueue(this);

        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");

        String resultado = consumo.toString();

        if (consumo >= 0 && consumo <= 10) {
            Glide.with(this)
                    .load(R.drawable.good)
                    .into(imageResult);
            txtGravedad.setText("No representas amenaza :)");
        } else if (consumo > 10 && consumo <= 80) {
            imageResult.setImageResource(R.drawable.medium);
            txtGravedad.setText("Puedes mejorar -.-");
        } else {
            imageResult.setImageResource(R.drawable.bad);
            txtGravedad.setText("Eres peligroso para la sociedad >.<");
        }
        btnbackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Resultados.this, MainActivity.class);
                startActivity(i);
            }
        });

        txtResultado.setText(resultado);
        // Obtener instancia de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("usuario_id", Context.MODE_PRIVATE);

        // Obtener los valores del título y contenido de la nota
        String id = sharedPreferences.getString("id", "");
        mostrar_nombre(id);
        // Mostrar el título y el contenido de la nota en un TextView
//        nombre.setText(id);
        // Formatear la fecha en el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(fechaActual);

        // Imprimir la fecha formateada en la consola
        fecha.setText(fechaFormateada);
        guardarResultado(id, resultado, fechaFormateada);

    }

    private void mostrar_nombre(String id) {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Insertando");
        progreso.hide();
        String url = Util.RUTA + "mostrar_usuario.php?u_usuario=" + id;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progreso.hide();
                        try {
                            String nombre_usuario = response.getJSONArray("tb_usuario").getJSONObject(0).getString("mensaje");
                            nombre.setText(nombre_usuario);

                        } catch (Exception e) {
                            Toast.makeText(Resultados.this, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progreso.hide();
                        Toast.makeText(Resultados.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

    private void guardarResultado(String id, String resultado, String fecha){
        progreso = new ProgressDialog(this);
        progreso.setMessage("Insertando");
        progreso.show();

        String url = Util.RUTA + "add_result.php?c_usuario="+ id + "&c_carbono=" + resultado +
                "&fecha=" + fecha;
        url=url.replace(" ","%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(), this::onResponse, this::onErrorResponse);
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

    public void irEstadisticas(View view) {
        Intent intent = new Intent(this, Chart.class);
        startActivity(intent);
    }
}