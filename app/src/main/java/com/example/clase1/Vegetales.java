package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Vegetales extends AppCompatActivity {
    CheckBox box_lechuga, box_pepino, box_col, box_betarraga, box_espinaca;

    ImageButton botonsiguiente5;

    Float consumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetales);
        box_lechuga = findViewById(R.id.box_lechuga);
        box_pepino = findViewById(R.id.box_pepino);
        box_col = findViewById(R.id.box_col);
        box_betarraga = findViewById(R.id.box_betarraga);
        box_espinaca = findViewById(R.id.box_espinaca);
        botonsiguiente5 = findViewById(R.id.botonsiguiente5);

        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");
        botonsiguiente5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enviar();
            }
        });
    }
    public void Enviar(){
        if(box_lechuga.isChecked() == true){
            consumo = consumo + 0.03f;
        }
        if(box_pepino.isChecked() == true){
            consumo = consumo + 23.4f;
        }
        if(box_col.isChecked() == true){
            consumo = consumo + 0.01f;
        }
        if(box_betarraga.isChecked() == true){
            consumo = consumo + 46.4f;
        }
        if(box_espinaca.isChecked() == true){
            consumo = consumo + 0.01f;
        }
        Bundle enviarDato = new Bundle();
        enviarDato.putFloat("keyDatos",consumo);

        Intent i = new Intent( Vegetales.this, Resultados.class);
        i.putExtras(enviarDato);
        startActivity(i);
    }
}