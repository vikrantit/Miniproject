package com.example.comp304_miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Intent i = new Intent();
    }

    public void onSignupClick(View view){

        if(view.getId()== R.id.button){
            EditText name= (EditText)findViewById(R.id.editText3);
            EditText email= (EditText)findViewById(R.id.editText5);
            EditText password= (EditText)findViewById(R.id.editText6);
            EditText phoneno= (EditText)findViewById(R.id.editText4);


            String namestr= name.getText().toString();
            String emailstr= email.getText().toString();
            String passwordstr= password.getText().toString();
            String phonenostr= phoneno.getText().toString();

            //insert in database
            User u=new User();
            u.setUsername(namestr);
            u.setEmailid(emailstr);
            u.setPassword(passwordstr);
            u.setPhoneno(phonenostr);

            helper.insertUser(u) ;
            Toast.makeText(CreateAccount.this,"Inserted",Toast.LENGTH_SHORT).show();


        }
    }
}
