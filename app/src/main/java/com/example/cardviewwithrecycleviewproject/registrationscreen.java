package com.example.cardviewwithrecycleviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrationscreen extends AppCompatActivity {
   EditText emailId;
   EditText userName;
   EditText passWord;
   Button registerButton;
   SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationscreen);
        emailId=(EditText) findViewById(R.id.emailidedittext);
        userName=(EditText) findViewById(R.id.registrationusernameedittext);
        passWord=(EditText) findViewById(R.id.registrationPasswordeditText);
        registerButton=(Button) findViewById(R.id.registrationbutton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registrationUserName= userName.getText().toString();
                String registrationPassword= passWord.getText().toString();

                Toast.makeText(getApplicationContext(),"you are registered",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),loginscreen.class);
                intent.putExtra("user",registrationUserName);
                intent.putExtra("key",registrationPassword);
                startActivity(intent);

            }
        });
    }
}