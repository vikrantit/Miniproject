package com.example.comp304_miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SecondJob.db";
    private static final int DATABASE_VERSION = 1;
    private String tables[]; //table names
    private String tableCreatorString[]; //SQL statements to create tables

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void dbInitialize(String[] tables, String tableCreatorString[])
    {
        this.tables = tables;
        this.tableCreatorString = tableCreatorString;
    }


    public void createDatabase(Context context)
    {
        SQLiteDatabase mDatabase;
        mDatabase = context.openOrCreateDatabase(
                DATABASE_NAME,
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);

    }
   @Override
   public void onCreate(SQLiteDatabase db) {

           // Drop existing tables
           for (int i=0;i<tables.length;i++)
           db.execSQL("DROP TABLE IF EXISTS " + tables[i]);

           for (int i=0;i<tables.length;i++)
           db.execSQL(tableCreatorString[i]);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);

    }


    public boolean checkNameAndPassword(String tableName, String userName, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + tableName+ " where userName=? and password=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{userName,password});
        if(cursor!=null && cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }
    public boolean adminLogin(String userName,String password){
        if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            return true;
        }
        else
            return false;
    }

    public List searchPersonalInfo(String tableName,String userName){

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + tableName+ " where userName=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{userName});
        ArrayList row=new ArrayList(); //to store one row
        if(cursor.moveToFirst()){
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                row.add(cursor.getString(i));
            }
        }
        return row;
    }

   public int modifyPersonalInfo(ContentValues values, String tableName, String fields[],String record[]){
       SQLiteDatabase db = this.getWritableDatabase();
       for (int i=0;i<record.length;i++)
           values.put(fields[i], record[i]);

        // updating row with given id = record[0]
       return db.update(tableName, values, fields[1] + " = ?",
               new String[] { record[1] });
   }


    public int modifyBookingInfo(ContentValues values, String tableName, String fields[],String record[]){
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i<record.length;i++)
            values.put(fields[i], record[i]);

        // updating row with given id = record[0]
        return db.update(tableName, values, fields[0] + " = ?",
                new String[] { record[0] });
    }





    public long register(ContentValues values, String tableName, String fields[],String record[]) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=0;i<record.length;i++)
            values.put(fields[i], record[i]);
        long result  = db.insert(tableName, null, values);
        db.close(); //close database connection
        return result;
    }


    public List getTableInfo(String tableName) {
        List table = new ArrayList(); //to store all rows
        String selectQuery = "SELECT  * FROM " + tableName;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList row=new ArrayList(); //to store one row
        //scroll over rows and store each row in an array list object
        if (cursor.moveToFirst())
        {
            do
            { // for each row
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    row.add(cursor.getString(i)==null||cursor.getString(i)==""? " ":cursor.getString(i));
                }

                table.add(row); //add row to the list

            } while (cursor.moveToNext());
        }

        // return table as a list
        return table;
    }


    public int deleteRecord(String tableName, String idName, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(tableName, idName + " = ?",
                new String[] { id });
        db.close();
        return result;
    }


    public long booking(ContentValues values, String tableName, String fields[],String record[]) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (int i=1;i<record.length;i++)
            values.put(fields[i], record[i]);
        long result  = db.insert(tableName, null, values);
        db.close(); //close database connection
        return result;
    }

    public int searchMovieId(String movieName) {
        int movieId = -1;

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + "movies"+ " where movieName=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{movieName});
        ArrayList row=new ArrayList(); //to store one row
        if(cursor.moveToFirst()){
            movieId = Integer.parseInt(cursor.getString(0));
        }

        return movieId;
    }

    public String searchEmailId(String userName) {

        String emailId = "";

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + "audience"+ " where userName=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{userName});
        ArrayList row=new ArrayList(); //to store one row
        if(cursor.moveToFirst()){
            emailId = cursor.getString(0);
        }

        return emailId;
    }

    public List searchBookingInfo(String emailId) {

        List table = new ArrayList(); //to store all rows
        String selectQuery = "SELECT  * FROM " + "booking where emailId=?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,  new String[]{emailId});
        ArrayList row=new ArrayList(); //to store one row
        //scroll over rows and store each row in an array list object
        if (cursor.moveToFirst())
        {
            do
            { // for each row
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    row.add(cursor.getString(i)==null||cursor.getString(i)==""? " ":cursor.getString(i));
                }

                table.add(row); //add row to the list

            } while (cursor.moveToNext());
        }

        // return table as a list
        return table;
    }

    public List searchBookingInfoByBookingId(String bookingId) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + "booking"+ " where booking_Id=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{bookingId});
        ArrayList row=new ArrayList(); //to store one row
        if(cursor.moveToFirst()){
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                row.add(cursor.getString(i)==null||cursor.getString(i)==""? " ":cursor.getString(i));
            }
        }

        return row;
    }
}
