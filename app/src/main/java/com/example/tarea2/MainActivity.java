package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn4;
    EditText edt1;
    TextView tv1;
    String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Estoy en onCreate");

        // Referencias a los elementos del layout
        btn1 = findViewById(R.id.btn1); // Botón hora del sistema
        btn4 = findViewById(R.id.btn4); // Botón pasar página
        edt1 = findViewById(R.id.edt1);
        tv1 = findViewById(R.id.tv1);

        // Botón hora del sistema
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edt1.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String horaActual = sdf.format(new Date());
                String resultado = "Hola " + nombre + ", la hora actual es: " + horaActual;
                tv1.setText(resultado);
                Log.d(TAG,"Estoy en botón hora");
            }
        });

        // Limpiar texto en el EditText cuando tenga el foco
        edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    edt1.setText("");
                }
            }
        });

        // Botón pasar página
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edt1.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NOMBRE_EXTRA", nombre);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Estoy en onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Estoy en onResume");
        // Puedes poner un mensaje en pantalla o realizar otras acciones aquí
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Estoy en onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Estoy en onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Estoy en onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Estoy en onDestroy");
    }
}
