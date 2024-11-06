package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class iniciopadres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciopadres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void volverperfil (View view) {
        Intent volverperfilp = new Intent(iniciopadres.this, padresfamilia.class );
        startActivity(volverperfilp);
    }

    public void menupp(View view) {
        Intent irmenu = new Intent(iniciopadres.this, menupadres.class );
        startActivity(irmenu);
    }

    public void videotuto(View view) {
        Intent irvideo = new Intent(iniciopadres.this, tutorialpadres.class );
        startActivity(irvideo);
    }
}