package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Bebidas extends AppCompatActivity {
    CheckBox box_gaseosas, box_energizantes, box_jugos, box_refrescos, box_te;
    ImageButton botonsiguiente1;
    float consumo = 0.00F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        box_gaseosas = findViewById(R.id.box_gaseosas);
        box_energizantes = findViewById(R.id.box_energizantes);
        box_jugos = findViewById(R.id.box_jugos);
        box_refrescos = findViewById(R.id.box_refrescos);
        box_te = findViewById(R.id.box_te);

        botonsiguiente1 = findViewById(R.id.botonsiguiente1);

        botonsiguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enviar();
            }
        });
    }
    public void Enviar(){
        if(box_gaseosas.isChecked() == true){
            consumo = consumo + 346;
        }
        if(box_energizantes.isChecked() == true){
            consumo = consumo + 1.23F;
        }
        if(box_jugos.isChecked() == true){
            consumo = consumo + 0.23F;
        }
        if(box_refrescos.isChecked() == true){
            consumo = consumo + 0.15F;
        }
        if(box_te.isChecked() == true){
            consumo = consumo + 0.48F;
        }
        Bundle enviarDato = new Bundle();
        enviarDato.putFloat("keyDatos",consumo);

        Intent i = new Intent( Bebidas.this, Carnes.class);
        i.putExtras(enviarDato);
        startActivity(i);
    }
}