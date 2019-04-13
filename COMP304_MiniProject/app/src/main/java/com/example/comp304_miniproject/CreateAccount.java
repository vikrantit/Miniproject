package com.example.comp304_miniproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {


    public static final String DATABASE_NAME= "Alright";
    SQLiteDatabase mdatabase;
    EditText name,email,password,phoneno,address,zipcode;


    private void createTable() {
        String sql = "CREATE TABLE user (\n" +
                "userID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "name varchar(200),\n" +
                "email_id varchar(200) ,\n" +
                "password varchar(200), \n" +
                "phoneno varchar(200) ,\n" +
                "address varchar(200),\n" +
                "postalcode varchar(200) \n" +
                ");";

        mdatabase.execSQL(sql);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mdatabase= openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE,null);
        createTable();



    }

    private void addUser(){

        name= (EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.editText3);
        password=(EditText)findViewById(R.id.editText4);
        phoneno=(EditText)findViewById(R.id.editText6);
        address=(EditText)findViewById(R.id.editText7);
        zipcode=(EditText)findViewById(R.id.editText8);

        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);




        String name1=name.getText().toString().trim();
        String email1= email.getText().toString().trim();
        String password1= password.getText().toString().trim();
        String phoneno1= phoneno.getText().toString().trim();
        String address1= address.getText().toString().trim();
        String zipcode1= zipcode.getText().toString().trim();

        if(name1.isEmpty()){
            name.setError("Name Cant be Empty");
            name.requestFocus();
            return;

        }
        if(email1.isEmpty()){
            email.setError("Email cannot be empty");
            email.requestFocus();
            return;
        }
        if(password1.isEmpty()){
            password.setError("Password cannot be Empty");
            password.requestFocus();
            return;
        }
        if(phoneno1.isEmpty()){
            phoneno.setError("Phone no cannot be Empty");
            phoneno.requestFocus();
            return;

        }
        if(address1.isEmpty()){
            address.setError("Phone no cannot be Empty");
            address.requestFocus();
            return;

        }
        if(zipcode1.isEmpty()){
            zipcode.setError("Phone no cannot be Empty");
            zipcode.requestFocus();
            return;

        }

        String sql="INSERT INTO user(name,email_id,password,phoneno,address,postalcode)"+
                "VALUES (?,?,?,?,?,?)";

        mdatabase.execSQL(sql,new String[] {name1,email1,password1,phoneno1,address1,zipcode1});

        Toast.makeText(this,"User Added",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button3:
                addUser();
                break;
            case R.id.button4:
                break;
        }
    }
}
