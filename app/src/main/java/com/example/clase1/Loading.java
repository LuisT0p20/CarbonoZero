package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import android.content.Intent;
import android.os.Handler;
public class Loading extends AppCompatActivity {
    private ImageView loading;
    private static final long DELAY_MS = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        loading = findViewById(R.id.loading);
        String url_loading = "https://usagif.com/wp-content/uploads/loading-25.gif";
        Uri urlplace = Uri.parse(url_loading);
        Glide.with(getApplicationContext()).load(url_loading).into(loading);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Lógica para iniciar el nuevo Activity
                Intent intent = new Intent(Loading.this, Starting.class);
                startActivity(intent);
                finish(); // Opcional: para finalizar la Activity actual después de la transición
            }
        }, DELAY_MS);
    }
}