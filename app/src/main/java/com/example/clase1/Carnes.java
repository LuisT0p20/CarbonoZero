package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Carnes extends AppCompatActivity {
    CheckBox box_pescado, box_pollo,box_res, box_cerdos, box_vegano;
    ImageButton botonsiguiente2;

    Float consumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);
        box_pescado = findViewById(R.id.box_pescado);
        box_pollo = findViewById(R.id.box_pollo);
        box_res = findViewById(R.id.box_res);
        box_cerdos = findViewById(R.id.box_cerdos);
        box_vegano = findViewById(R.id.box_vegano);

        botonsiguiente2 = findViewById(R.id.botonsiguiente2);

        Bundle recibirDato = getIntent().getExtras();
        consumo = recibirDato.getFloat("keyDatos");
        botonsiguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box_pescado.isChecked() == true){
                    consumo = consumo + 3.49F;
                }
                if(box_pollo.isChecked() == true){
                    consumo = consumo + 3.65F;
                }
                if(box_res.isChecked() == true){
                    consumo = consumo + 58.74F;
                }
                if(box_cerdos.isChecked() == true){
                    consumo = consumo + 5.77F;
                }
                if(box_vegano.isChecked() == true){
                    consumo = consumo + 0;
                }
                Bundle enviarDato = new Bundle();
                enviarDato.putFloat("keyDatos",consumo);

                Intent i = new Intent( Carnes.this, Cereales.class);
                i.putExtras(enviarDato);
                startActivity(i);
            }
        });
    }
}