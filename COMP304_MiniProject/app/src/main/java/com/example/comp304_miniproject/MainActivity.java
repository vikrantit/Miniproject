package com.example.comp304_miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view) {
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
