package com.example.comp304_miniproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> arr_adapte;
    private ListView loginoption;


    //on create for db tables
    public static final String tables[]={"user","jobs","application"};

    public static final String tableCreatorString[] =
            {"CREATE TABLE user (userID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT , email_id TEXT UNIQUE, password TEXT, phoneno  TEXT UNIQUE,address TEXT, postalCode TEXT);",
                    "CREATE TABLE jobs (job_id INTEGER PRIMARY KEY AUTOINCREMENT , jobtitle TEXT, jobdescription TEXT, noofhours TEXT, payment TEXT, userID INTEGER , seekid INTEGER);",
                    "CREATE TABLE application (job_id INTEGER PRIMARY KEY , appliedUid INTEGER, approval TEXT, jobposterUid INTEGER);"
                    };


    public static final String DATABASE_NAME= "mydatbase";
    SQLiteDatabase mdatabase;


    private void createTable(){
        String sql="CREATE TABLE user (\n" +
                "userID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "name TEXT,\n"+
                "email_id TEXT UNIQUE,\n"+
                "password TEXT, \n"+
                "phoneno TEXT UNIQUE,\n"+
                "address TEXT,\n"+
                "postalcode TEXT\n"+
                ");";

        mdatabase.execSQL(sql);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mdatabase= openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE,null);
        //createTable();

    }

    public void sendMessage(View view) {

        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        // Do something in response to button
    }

    public void SendData(View view)
    {
        //  EditText editText=findViewById(R.id.editText);
        //  String message = editText.getText().toString();

        Intent intent = new Intent(MainActivity.this, CreateAccount.class);
        //  intent.putExtra("message",message);
        startActivity(intent);

    }
}
