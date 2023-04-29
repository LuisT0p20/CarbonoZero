package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Starting extends AppCompatActivity {
    Handler handler = new Handler();
    private ImageView loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        loading = findViewById(R.id.loading);
        String url_loading = "https://usagif.com/wp-content/uploads/loading-25.gif";
        Uri urlplace = Uri.parse(url_loading);
        Glide.with(getApplicationContext()).load(url_loading).into(loading);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Starting.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // Aquí especificamos el tiempo en milisegundos (en este caso, 3000 ms = 3 segundos)

    }
}