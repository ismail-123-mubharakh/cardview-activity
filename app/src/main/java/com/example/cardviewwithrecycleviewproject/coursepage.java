package com.example.cardviewwithrecycleviewproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class coursepage extends AppCompatActivity {

   // MenuItem menuItemHelp =(MenuItem) findViewById(R.id.help);
   // MenuItem menuItemExit =(MenuItem) findViewById(R.id.exit);
   String[] courseNames= {"AWS","PHP","Fluent English","Painting","Laravel","Ruby on rail","Web Development",
                          "Swift","SQL","Angular JS"};
 /*  int[] flowerImages=  {R.drawable.sunflower,R.drawable.lavender,R.drawable.jasmine,R.drawable.lotus
                         ,R.drawable.hibiscus,R.drawable.waterflower,R.drawable.bluebanquet,R.drawable.
                         wildroses,R.drawable.drainoflower,R.drawable.orchid}; */
    String[] subText1 ={"Course Group:Full time","Course Group:Full time","Course Group:Full time","Course Group:Full time"
                      ,"Course Group:Full time","Course Group:Full time","Course Group:Full time"
                      ,"Course Group:Full time","Course Group:Full time","Course Group:Full time"};
    String[] subText2= {"Batch:Batch-1","Batch:Batch-2","Batch:Batch-3","Batch:Batch-4","Batch:Batch-5"
                       ,"Batch:Batch-6","Batch:Batch-7","Batch:Batch-8","Batch:Batch-9","Batch:Batch-10"};
    String[] subText3= {"Attendance Type:Daily","Attendance Type:Daily","Attendance Type:Daily"
                      ,"Attendance Type:Daily","Attendance Type:Daily","Attendance Type:Daily"
                       ,"Attendance Type:Daily","Attendance Type:Daily","Attendance Type:Daily"
                        ,"Attendance Type:Daily"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursepage);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CustomCardViewAdapter customcardview= new  CustomCardViewAdapter(coursepage.this,courseNames,subText1,subText2,subText3);
        recyclerView.setAdapter(customcardview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.cardmenuitems,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.help:
                AlertDialog.Builder alert= new AlertDialog.Builder(this);
                alert.setTitle("Help");
                alert.setMessage("APK Version:V.16.13.2.1 \nThis app all about the courses and its timing and availability information and various courses");
                alert.setCancelable(false);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog obj= alert.create();
                obj.show();


                return true;
            case R.id.exit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);



            default:
                return super.onOptionsItemSelected(item);
        }



    }
}