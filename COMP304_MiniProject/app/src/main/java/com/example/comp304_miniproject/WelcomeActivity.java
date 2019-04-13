package com.example.comp304_miniproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    SQLiteDatabase mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mdatabase=openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);

        loadUsersfromDatabase();


    }

    private void loadUsersfromDatabase(){
        String sql= "SELECT * from employees";

        Cursor cursor= mdatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{

            }while (cursor.moveToNext());
        }
    }
}
