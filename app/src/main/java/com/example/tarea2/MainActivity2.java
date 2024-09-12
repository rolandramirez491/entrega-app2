package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvWelcome;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tvWelcome = findViewById(R.id.tvWelcome);
        btnBack = findViewById(R.id.btnBack);


        Intent intent = getIntent();

        String nombre = intent.getStringExtra("NOMBRE_EXTRA");


        String mensaje = "Bienvenido, " + nombre;

        tvWelcome.setText(mensaje);


        btnBack.setOnClickListener(v -> {

            Intent backIntent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });
    }
}

