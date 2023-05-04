package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Frutas extends AppCompatActivity {
    CheckBox box_mandarina, box_fresa, box_manzana, box_platano, box_sandia;

    ImageButton botonsiguiente4;

    Float consumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);
        box_mandarina = findViewById(R.id.box_mandarina);
        box_fresa = findViewById(R.id.box_fresa);
        box_manzana = findViewById(R.id.box_manzana);
        box_platano = findViewById(R.id.box_platano);
        box_sandia = findViewById(R.id.box_sandia);
        botonsiguiente4 = findViewById(R.id.botonsiguiente4);

        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");
        botonsiguiente4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enviar();
            }
        });
    }
    public void Enviar(){
        if(box_mandarina.isChecked() == true){
            consumo = consumo + 0.28F;
        }
        if(box_fresa.isChecked() == true){
            consumo = consumo + 0.02F;
        }
        if(box_manzana.isChecked() == true){
            consumo = consumo + 0.08F;
        }
        if(box_platano.isChecked() == true){
            consumo = consumo + 0.03F;
        }
        if(box_sandia.isChecked() == true){
            consumo = consumo + 0.03F;
        }
        Bundle enviarDato = new Bundle();
        enviarDato.putFloat("keyDatos",consumo);

        Intent i = new Intent( Frutas.this, Vegetales.class);
        i.putExtras(enviarDato);
        startActivity(i);
    }
}