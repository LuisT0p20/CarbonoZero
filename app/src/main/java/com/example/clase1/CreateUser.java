package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateUser extends AppCompatActivity {
    Button btn_cancel_create_user,btn_create_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        btn_create_user = findViewById(R.id.btn_create_user);
        btn_cancel_create_user = findViewById(R.id.btn_cancel_create_user);

        btn_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateUser.this, Login.class);
                startActivity(i);
            }
        });
        btn_cancel_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateUser.this, Login.class);
                startActivity(i);
            }
        });
    }
}