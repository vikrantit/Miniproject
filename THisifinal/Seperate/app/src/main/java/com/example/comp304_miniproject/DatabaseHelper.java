package com.example.comp304_miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {


    //for users
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME= "user.db";
    private static final String TABLE_NAME= "user";

    private static final String COLOUMN_ID ="id";
    private static final String COLOUMN_NAME ="name";
    private static final String COLOUMN_EMAIL ="email";
    private static final String COLOUMN_PASS ="pass";
    private static final String COLOUMN_PHONE ="phone";
    SQLiteDatabase db;

    //for jobs

    private static final String COLOM_ID ="jobid";
    private static final String COLOM_TITLE ="jobtitle";
    private static final String COLOM_DESCRIPTION ="jobdesc";
    private static final String COLOM_HOURS ="jobhours";
    private static final String COLOM_PAYMENT ="jobpay";
    private static final String COLOM_POSTID ="jobpostid";
    private static final String COLOM_SEEKID ="jobseekid";






    private static final String TABLE_CREATE= "create table user (id integer primary key not null , " +
            "name text not null, email text not null , pass text not null ,phone text not null);";

    private static final String TABLE_CREATE2="create table job ( jobid integer not null, "+
            "jobtitle text not null, jobdesc not null, jobhours integer not null, jobpay text not null, jobpostid integer primary key not null, jobseekid integer  not null);";


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE2);
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

    public void postjob(Job job,User user){
        db=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        String query= "select * from job";
        Cursor cursor= db.rawQuery(query,null);

        int count= cursor.getCount();

        values.put(COLOM_ID,count);
        values.put(COLOM_TITLE,job.getJobtitle());
        values.put(COLOM_DESCRIPTION,job.getJobdesc());
        values.put(COLOM_HOURS,job.getJobhours());
        values.put(COLOM_PAYMENT,job.getJobpay());
        values.put(COLOM_POSTID,user.getId());


        db.insert("job",null,values);
        db.close();
    }

    public User searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "Select * from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        User u=new User();
        b="not found";

        if(cursor.moveToFirst()){
            do{

                a= cursor.getString(3);


                if (a.equals(uname))
                {
                    b=cursor.getString(4);
                    u.setId(cursor.getInt(1));
                    u.setUsername(cursor.getString(2));
                    u.setEmailid(cursor.getString(3));
                    u.setPassword(cursor.getString(4));
                    u.setPhoneno(cursor.getString(5));

                    break;

                }


            }while(cursor.moveToNext());
        }

        return u;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query= "DROP TABLE IF EXISTS " + TABLE_NAME;
        String query2= "DROP TABLE IF EXISTS job" ;
        db.execSQL(query);
        db.execSQL(query2);
        this.onCreate(db);
    }


}
