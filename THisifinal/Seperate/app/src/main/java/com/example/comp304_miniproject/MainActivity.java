package com.example.comp304_miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendData(View view)
    {
        Intent intent=new Intent(MainActivity.this,CreateAccount.class);
        startActivity(intent);

    }

    public void login(View v){
        EditText email=(EditText)findViewById(R.id.editText);
        EditText password=(EditText)findViewById(R.id.editText2);

        String emailstr=email.getText().toString();
        String passstr=password.getText().toString();

        String passreturn = helper.searchPass(emailstr);
        if(passreturn.equals(passstr)){
            Intent i= new Intent(MainActivity.this,WelcomeActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(MainActivity.this,"Passwords not match",Toast.LENGTH_SHORT).show();

        }


    }


}
