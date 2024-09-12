package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn4;
    EditText edt1;
    TextView tv1;
    ImageView imageView; // mostrar la capturada
    String TAG = "Test";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Estoy en onCreate");

        btn1 = findViewById(R.id.btn1);
        btn4 = findViewById(R.id.btn4);
        edt1 = findViewById(R.id.edt1);
        tv1 = findViewById(R.id.tv1);
        imageView = findViewById(R.id.imageView); // ImageView para la imagen

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

        edt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    edt1.setText("");
                }
            }
        });

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

        // Llamar la cámara para tomar una foto en onStart
        dispatchTakePictureIntent();
    }

    // lanzar la cámara
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // Método para imagen capturada
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap); // mostrar en el ImageView
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String nombre2 = edt1.getText().toString();
        Log.d(TAG,"Hola "+nombre2+" estas en el onResume");
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
