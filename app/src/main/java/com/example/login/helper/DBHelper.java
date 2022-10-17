package com.example.login.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.login.dao.User;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "LoginCadastro.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table users (username Text primary key,mail Text, password Text)";
        db.execSQL(sql);
        Log.d("MINHATAG", "onCreate: ta dando certo");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists users";
        db.execSQL(sql);

    }


    public boolean cadastrarUsuario(String username, String email, String password) {

        SQLiteDatabase myDB = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("mail", email);
        cv.put("password", password);

        long result = myDB.insert("users", null, cv);


        if (result == -1) {
            return false;
        }
        return true;
    }

    public boolean usuarioExistente(String mail) {

        SQLiteDatabase myDB = this.getWritableDatabase();

        Cursor c = myDB.rawQuery("select * from users where mail = ?", new String[]{mail});
        if (c.getCount() > 0) {
            return true;
        }
        return false;
    }

    public boolean validarLoginSenha(String username, String password) {

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor c = myDB.rawQuery("select * from users where username = ? AND password = ?", new String[]{username, password});
        if (c.getCount() > 0) {
            return true;
        }

        return false;
    }

    public User obterUsuarioPorUser(String user) {

        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor c = myDB.rawQuery("select * from users where username = ?", new String[]{"leo"});
        if (c.moveToFirst()) {
            do {

                return new User(c.getString(0),
                        c.getString(1),
                        c.getString(2));
            } while (c.moveToNext());

        }

        return null;
    }
}

