package com.example.comp304_miniproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);

    User user= (User)getIntent().getSerializableExtra("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent i = new Intent();
        //work on this version and yaha se commit and push

        //prepare a new layout for welcome activity(after login)
        //3 buttons : one for posting ajob
          //      one for checking available jobs
            //    and one for previous applied jobs continue
        //

    }

    public void postjob(View v){

        if(v.getId()== R.id.button2) {
            EditText jobtitle = (EditText) findViewById(R.id.editText7);
            EditText jobdesc = (EditText) findViewById(R.id.editText8);
            EditText jobhours = (EditText) findViewById(R.id.editText9);
            EditText jobpay = (EditText) findViewById(R.id.editText10);

            String jobtitlestr = jobtitle.getText().toString();
            String jobdescstr = jobdesc.getText().toString();
            int jobhourstr = Integer.parseInt(jobhours.getText().toString());
            String jobpaystr = jobpay.getText().toString();

            Job job=new Job();
            job.setJobtitle(jobtitlestr);
            job.setJobdesc(jobdescstr);
            job.setJobpay(jobpaystr);
            job.setJobhours(jobhourstr);

            helper.postjob(job, user);
            Toast.makeText(WelcomeActivity.this,"Job Posted",Toast.LENGTH_SHORT).show();

        }


    }
}
