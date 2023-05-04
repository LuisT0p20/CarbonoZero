package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Cereales extends AppCompatActivity {
     CheckBox box_arroz, box_trigo, box_avena,box_quinua, box_cebada;
     ImageButton botonsiguiente3;
     Float consumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cereales);
        box_arroz = findViewById(R.id.box_arroz);
        box_trigo = findViewById(R.id.box_trigo);
        box_avena = findViewById(R.id.box_avena);
        box_quinua = findViewById(R.id.box_quinua);
        box_cebada = findViewById(R.id.box_cebada);
        botonsiguiente3 = findViewById(R.id.botonsiguiente3);


        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");
        botonsiguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enviar();
            }
        });

    }
    public void Enviar(){
        if(box_arroz.isChecked() == true){
            consumo = consumo + 0.48F;
        }
        if(box_trigo.isChecked() == true){
            consumo = consumo + 458;
        }
        if(box_avena.isChecked() == true){
            consumo = consumo + 1.94F;
        }
        if(box_quinua.isChecked() == true){
            consumo = consumo + 1.87F;
        }
        if(box_cebada.isChecked() == true){
            consumo = consumo + 384;
        }
        Bundle enviarDato = new Bundle();
        enviarDato.putFloat("keyDatos",consumo);

        Intent i = new Intent( Cereales.this, Frutas.class);
        i.putExtras(enviarDato);
        startActivity(i);
    }
}