package com.example.cardviewwithrecycleviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class secondcardviewactivity extends AppCompatActivity {
   TextView selectedImage;
   TextView  selectedTextview1;
    TextView  selectedTextview2;
    TextView  selectedTextview3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondcardviewactivity);
        selectedImage = (TextView) findViewById(R.id.selectedImage);
        selectedTextview1=(TextView) findViewById(R.id.menutextview1) ;
        selectedTextview2=(TextView) findViewById(R.id.menutextview2) ;
        selectedTextview3=(TextView) findViewById(R.id.menutextview3) ;
        Intent intent = getIntent();
        selectedImage.setText(intent.getStringExtra("image"));
        selectedTextview1.setText(intent.getStringExtra("text1"));
        selectedTextview2.setText(intent.getStringExtra("text2"));
        selectedTextview3.setText(intent.getStringExtra("text3"));
    }
}