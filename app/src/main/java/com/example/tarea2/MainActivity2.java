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

        // Inicializa el TextView y el Button
        tvWelcome = findViewById(R.id.tvWelcome);
        btnBack = findViewById(R.id.btnBack);

        // Obtener el Intent que inició esta actividad
        Intent intent = getIntent();
        // Obtener el nombre pasado
        String nombre = intent.getStringExtra("NOMBRE_EXTRA");

        // Crear el mensaje de bienvenida
        String mensaje = "Bienvenido, " + nombre;

        // Mostrar el mensaje en el TextView
        tvWelcome.setText(mensaje);

        // Configurar el botón para regresar a MainActivity
        btnBack.setOnClickListener(v -> {
            // Crear un Intent para regresar a MainActivity
            Intent backIntent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(backIntent);
            finish(); // Finalizar MainActivity2 para que no quede en la pila de actividades
        });
    }
}

