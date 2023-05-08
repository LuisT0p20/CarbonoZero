package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.clase1.Utilidades.Util;

import org.json.JSONObject;

import java.util.Date;
import java.text.SimpleDateFormat;
public class Resultados extends AppCompatActivity {
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    TextView txtResultado,nombre, fecha;
    Float consumo;

    // Obtener la fecha actual
    Date fechaActual = new Date();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        txtResultado = findViewById(R.id.txtResultado);
        nombre = findViewById(R.id.nombre);
        fecha = findViewById(R.id.fecha);
        requestQueue = Volley.newRequestQueue(this);


        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");

        String resultado = consumo.toString();

        txtResultado.setText(resultado);
        // Obtener instancia de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("usuario_id", Context.MODE_PRIVATE);

        // Obtener los valores del título y contenido de la nota
        String id = sharedPreferences.getString("id", "");

        // Mostrar el título y el contenido de la nota en un TextView
        nombre.setText(id);
        // Formatear la fecha en el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(fechaActual);

        // Imprimir la fecha formateada en la consola
        fecha.setText(fechaFormateada);
        guardarResultado(id, resultado, fechaFormateada);
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
}