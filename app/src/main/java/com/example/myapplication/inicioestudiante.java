package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class inicioestudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicioestudiante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void volverperfil (View view) {
        Intent volverperfile = new Intent(inicioestudiante.this, estudiante.class );
        startActivity(volverperfile);
    }

    public void menue(View view) {
        Intent irmenu = new Intent(inicioestudiante.this, menuestudiante.class );
        startActivity(irmenu);
    }

    public void videotuto(View view) {
        Intent irvideo = new Intent(inicioestudiante.this, tutorialestudiante.class );
        startActivity(irvideo);
    }
}