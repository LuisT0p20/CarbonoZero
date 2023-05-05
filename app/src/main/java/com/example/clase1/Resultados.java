package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

public class Resultados extends AppCompatActivity {
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    TextView txtResultado;
    Float consumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        txtResultado = findViewById(R.id.txtResultado);

        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");

        String resultado = consumo.toString();

        txtResultado.setText(resultado);
    }
}