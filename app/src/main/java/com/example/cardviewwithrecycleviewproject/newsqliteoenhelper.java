package com.example.cardviewwithrecycleviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newsqliteoenhelper extends AppCompatActivity {
  private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsqliteoenhelper);
        courseNameEdt = findViewById(R.id.EditCourseName);
        courseTracksEdt = findViewById(R.id.EditCourseTracks);
        courseDurationEdt = findViewById(R.id.EditCourseDuration);
        courseDescriptionEdt = findViewById(R.id.EditCourseDescription);
        addCourseBtn = findViewById(R.id.ButnAddCourse);
        readCourseBtn = findViewById(R.id.ButnReadCourse);
     dbHandler=new DBHandler(newsqliteoenhelper.this);
     addCourseBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String courseName = courseNameEdt.getText().toString();
             String courseTracks = courseTracksEdt.getText().toString();
             String courseDuration = courseDurationEdt.getText().toString();
             String courseDescription = courseDescriptionEdt.getText().toString();

             if (courseName.isEmpty() || courseTracks.isEmpty() || courseDuration.isEmpty() ||
             courseDescription.isEmpty()){
                 Toast.makeText(newsqliteoenhelper.this,"enter the data",Toast.LENGTH_LONG).show();
                 return;
             }
             dbHandler.addNewCourse(courseName,courseTracks,courseDuration,courseDescription);
             Toast.makeText(newsqliteoenhelper.this,"course has been added", Toast.LENGTH_SHORT).show();
         }
     });

    }
}