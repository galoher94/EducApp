package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class estudiante extends AppCompatActivity {


    private EditText eett1, eett2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_estudiante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        eett1=(EditText) findViewById(R.id.eett1);
        eett2 =(EditText) findViewById(R.id.eett2);
    }

    public void ingresar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String usuario = eett1.getText().toString();
        String contraseña =eett2.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("usuario", usuario);
        registro.put("contraseña",contraseña);

        db.insert("estudiantes",null,registro);
        db.close();

        eett1.setText("");
        eett2.setText("");

        Intent ingreso = new Intent(estudiante.this, inicioestudiante.class );
        startActivity(ingreso);


    }


    public void cambioperfil(View view) {
        Intent cambio = new Intent(estudiante.this, MainActivity.class );
        startActivity(cambio);
    }

}