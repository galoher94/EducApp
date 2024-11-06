package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inicioAdmin(View view) {
        Intent prueba = new Intent(MainActivity.this, administrador.class);
        startActivity(prueba);
    }


    public void inicioProfe(View view) {
        Intent profes = new Intent(MainActivity.this, profesor.class);
        startActivity(profes);
    }
    public void inicioestudi(View view) {
        Intent estudiant = new Intent(MainActivity.this, estudiante.class);
        startActivity(estudiant);
    }
    public void iniciopadres(View view) {
        Intent padres = new Intent(MainActivity.this, padresfamilia.class);
        startActivity(padres);
    }
}