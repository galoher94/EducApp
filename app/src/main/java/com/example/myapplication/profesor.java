
package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

public class profesor extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profesor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et1 =(EditText) findViewById(R.id.et1);
        et2 =(EditText) findViewById(R.id.et2);
    }

    public void ingresar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        String usuario = et1.getText().toString();
        String contraseña = et2.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("usuario", usuario);
        registro.put("contraseña",contraseña);

        db.insert("profesores",null,registro);
        db.close();

        et1.setText("");
        et2.setText("");

        Intent ingreso = new Intent(profesor.this, inicioprofe.class );
        startActivity(ingreso);

    }



    public void cambioperfil(View view) {
        Intent cambio = new Intent(profesor.this, MainActivity.class );
        startActivity(cambio);
    }


}