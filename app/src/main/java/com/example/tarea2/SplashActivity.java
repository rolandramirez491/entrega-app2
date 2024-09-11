package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Usar un Handler para iniciar MainActivity después de 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent para iniciar MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar SplashActivity para que no quede en la pila de actividades
            }
        }, 5000); // 3000 milisegundos = 3 segundos
    }
}
