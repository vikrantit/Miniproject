package com.example.comp304_miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME= "user.db";
    private static final String TABLE_NAME= "user";

    private static final String COLOUMN_ID ="id";
    private static final String COLOUMN_NAME ="name";
    private static final String COLOUMN_EMAIL ="email";
    private static final String COLOUMN_PASS ="pass";
    private static final String COLOUMN_PHONE ="phone";
    SQLiteDatabase db;


    private static final String TABLE_CREATE= "create table user (id integer primary key not null , " +
            "name text not null, email text not null , pass text not null ,phone text not null);";


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertUser(User u){
        db =this.getWritableDatabase();

        ContentValues values=new ContentValues();

        String query= "select * from user";
        Cursor cursor= db.rawQuery(query,null);

        int count= cursor.getCount();

        values.put(COLOUMN_ID,count);
        values.put(COLOUMN_NAME,u.getUsername());
        values.put(COLOUMN_EMAIL,u.getEmailid());
        values.put(COLOUMN_PASS,u.getPassword());
        values.put(COLOUMN_PHONE,u.getPhoneno());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "Select * from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="not found";

        if(cursor.moveToFirst()){
            do{

                a= cursor.getString(3);


                if (a.equals(uname))
                {
                    b=cursor.getString(4);
                    break;
                }


            }while(cursor.moveToNext());
        }

        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query= "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }


}