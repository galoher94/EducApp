package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class inicioprofe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicioprofe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void volverperfil (View view) {
        Intent volverperfilp = new Intent(inicioprofe.this, profesor.class );
        startActivity(volverperfilp);
    }

    public void menup(View view) {
        Intent irmenu = new Intent(inicioprofe.this, menuprofesor.class );
        startActivity(irmenu);
    }

    public void videotuto(View view) {
        Intent irvideo = new Intent(inicioprofe.this, tutorial.class );
        startActivity(irvideo);
    }
}