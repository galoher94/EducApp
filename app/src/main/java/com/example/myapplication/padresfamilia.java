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

public class padresfamilia extends AppCompatActivity {

    private EditText edt1,edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_padresfamilia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edt1= (EditText) findViewById(R.id.edt1);
        edt2= (EditText) findViewById(R.id.edt2);
    }

    public void ingresar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String usuario = edt1.getText().toString();
        String contraseña =edt2.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("usuario", usuario);
        registro.put("contraseña",contraseña);

        db.insert("estudiantes",null,registro);
        db.close();

        edt1.setText("");
        edt2.setText("");

        Intent ingreso = new Intent(padresfamilia.this, iniciopadres.class );
        startActivity(ingreso);


    }

    public void cambioperfil(View view) {
        Intent cambio = new Intent(padresfamilia.this, MainActivity.class );
        startActivity(cambio);
    }


}