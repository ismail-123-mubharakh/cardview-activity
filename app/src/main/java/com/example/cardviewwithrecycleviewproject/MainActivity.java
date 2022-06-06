package com.example.cardviewwithrecycleviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread obje=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                Intent internt= new Intent(MainActivity.this,loginscreen.class);
                startActivity(internt);

            }
        };
        obje.start();
    }
}