package com.example.comunicacionactividades;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RecetasSQLite extends SQLiteOpenHelper {
    private static String creartabla = "CREATE TABLE Recetas (_id integer primary key autoincrement , nombre TEXT, foto INT, dificultad TEXT ,pasos TEXT, duracion INT)";
    private static String eliminarTabla = "DROP TABLE IF EXISTS Recetas";

    public RecetasSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public RecetasSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creartabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(eliminarTabla);
        sqLiteDatabase.execSQL(creartabla);
    }
}
