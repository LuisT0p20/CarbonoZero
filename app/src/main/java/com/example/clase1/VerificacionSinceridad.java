package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class VerificacionSinceridad extends AppCompatActivity {
    private static final long DELAY_MSS = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_sinceridad);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Lógica para iniciar el nuevo Activity
                Intent intent = new Intent(VerificacionSinceridad.this, Bebidas.class);
                startActivity(intent);
                finish(); // Opcional: para finalizar la Activity actual después de la transición
            }
        }, DELAY_MSS);
    }
}