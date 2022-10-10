package com.example.login.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "LoginCadastro.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table users (username Text primary key, email Text, password Text)";
        db.execSQL(sql);
        Log.d("MINHATAG", "ONcREATE: ta danodo certo");
    }

}
