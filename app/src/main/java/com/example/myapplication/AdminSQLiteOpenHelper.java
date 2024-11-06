package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE profesores(usuario text primary key, contraseña integer)");
        db.execSQL("CREATE TABLE estudiantes(usuario text primary key, contraseña integer)");
        db.execSQL("CREATE TABLE padres(usuario text primary key, contraseña integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS profesores");
        db.execSQL("CREATE TABLE profesores(usuario text primary key, contraseña integer)");
        db.execSQL("DROP TABLE IF EXISTS estudiantes");
        db.execSQL("CREATE TABLE estudiantes(usuario text primary key, contraseña integer)");
        db.execSQL("DROP TABLE IF EXISTS padres");
        db.execSQL("CREATE TABLE padres(usuario text primary key, contraseña integer)");
    }
}
