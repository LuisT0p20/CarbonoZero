package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PantallaCarga extends AppCompatActivity {
    Handler handler = new Handler();
    Float consumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle enviarDato = new Bundle();
                enviarDato.putFloat("keyDatos",consumo);

                Intent intent = new Intent(PantallaCarga.this, Resultados.class);
                intent.putExtras(enviarDato);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}