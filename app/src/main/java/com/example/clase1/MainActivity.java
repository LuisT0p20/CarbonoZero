package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity {
//objetos con los que se va a interactuar
    CardView cv_register, cv_analisis, cv_recomendacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv_register = findViewById(R.id.cv_register);
        cv_analisis = findViewById(R.id.cv_analisis);
        cv_recomendacion = findViewById(R.id.cv_recomendacion);
        cv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, VerificacionSinceridad.class);
                startActivity(i);
            }
        });
        cv_analisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Chart.class);
                startActivity(j);
            }
        });
        cv_recomendacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Recomendacion.class);
                startActivity(i);
            }
        });

    }


}