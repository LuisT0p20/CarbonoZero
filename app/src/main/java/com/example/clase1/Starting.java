package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class Starting extends AppCompatActivity {
    Button btnIniciar;
    TextView txtMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        btnIniciar = findViewById(R.id.botonIniciar);
        txtMensaje = findViewById(R.id.mensajesBienvenidos);
        String mensajes[] = {"Reducir nuestra huella de carbono es una responsabilidad compartida hacia el planeta que todos habitamos." +
                " Cada acción que tomamos para disminuir nuestras emisiones contribuye a preservar el medio ambiente para las generaciones futuras." +
                " ¡Tú puedes marcar la diferencia!","El control de la huella de carbono es fundamental para frenar el cambio climático y proteger nuestro planeta. " +
                "Al medir y reducir nuestras emisiones, estamos creando un futuro más sostenible y saludable para todos. " +
                "¡Juntos podemos construir un mundo con menos carbono!",
                "Cada tonelada de carbono que evitamos liberar a la atmósfera es una victoria para el medio ambiente." +
                        " El control de la huella de carbono nos permite ser conscientes de nuestro impacto y nos brinda la oportunidad de tomar decisiones más ecoamigables en nuestras vidas cotidianas. " +
                        "¡Cuidemos el planeta, uno de carbono a la vez!",
                "La importancia del control de la huella de carbono radica en preservar los ecosistemas," +
                        " proteger la biodiversidad y garantizar un futuro sostenible para las próximas generaciones. " +
                        "Cada elección que hacemos, ya sea en nuestra alimentación, transporte o consumo de energía, " +
                        "tiene un impacto directo en nuestro entorno. " +
                        "¡Seamos agentes de cambio y reduzcamos nuestra huella de carbono!",
                "La huella de carbono es una medida clave para evaluar el impacto ambiental de nuestras actividades diarias." +
                        " Al ser conscientes de nuestras emisiones y tomar medidas para reducirlas," +
                        " estamos contribuyendo a mitigar el cambio climático y preservar el equilibrio ecológico. " +
                        "El control de la huella de carbono nos invita a ser responsables y tomar decisiones informadas para un futuro sostenible.",
                "El control de la huella de carbono es una oportunidad para adoptar un estilo de vida más consciente y sustentable. " +
                        "Al disminuir nuestras emisiones, no solo reducimos el impacto ambiental, " +
                        "sino que también fomentamos la innovación, la eficiencia energética y el desarrollo de tecnologías limpias." +
                        " Juntos, podemos impulsar un cambio positivo hacia un mundo más verde y resiliente.",
                "El control de la huella de carbono nos brinda la posibilidad de alinear nuestras acciones con nuestros valores ambientales. " +
                        "Cada elección que hacemos, desde cómo nos movemos hasta lo que consumimos, " +
                        "puede marcar la diferencia en la reducción de las emisiones. " +
                        "A medida que aumentamos nuestra conciencia y adoptamos medidas para controlar nuestra huella de carbono," +
                        " estamos construyendo un futuro más sostenible y equitativo para todos."};
        Random random = new Random();
        int numeroMensaje = random.nextInt(7);
        txtMensaje.setText(mensajes[numeroMensaje]);
    }

    public void pasarlogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}