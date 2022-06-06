package com.example.cardviewwithrecycleviewproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomCardViewAdapter  extends RecyclerView.Adapter<CustomCardViewAdapter.MyVViewHolder> {
    //courseNames,subText1,subText2,subText3
   // private  final String[] courseNames;
    private  final String[] courseNames;
    private  final String[] subText1;
    private  final String[] subText2;
    private  final String[] subText3;

    //int[] flowerImages;
    Context context;
    public CustomCardViewAdapter(coursepage context, String[] courseNames, String[]subText1, String[]subText2, String[]subText3 ) {
        this.context=context;
        this.courseNames = courseNames;
        this.subText1= subText1;
        this.subText2= subText2;
        this.subText3= subText3;
    }

    @NonNull
    @Override
    public MyVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewelements,parent,false);
        MyVViewHolder vvh=new MyVViewHolder(v);
        return vvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyVViewHolder holder, int position) {
        if (position==0)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#F1948A"));
        else if (position==1)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#A569BD"));
        else if (position==2)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#773A93"));
        else if (position==3)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#52BE80"));
        else if (position==4)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#D1051A"));
        else if (position==5)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#970808"));
        else if (position==6)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#453B4C"));
        else if (position==7)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#9C640C"));
        else if (position==8)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#D1F2EB"));
        else if (position==9)
            holder.cardTextview1.setBackgroundColor(Color.parseColor("#7D6608"));


        //holder.cardImageview.setImageResource(flowerImages [position]);
        holder.cardTextview1.setText(courseNames[position]);
        holder.cardTextview2.setText(subText1[position]);
        holder.cardTextview3.setText(subText2[position]);
        holder.cardTextview4.setText(subText3[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, secondcardviewactivity.class);
                intent.putExtra("image", courseNames[position]);
                intent.putExtra("text1", subText1[position]);
                intent.putExtra("text2", subText2[position]);
                intent.putExtra("text3", subText3[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return courseNames.length;
    }

    public class MyVViewHolder extends RecyclerView.ViewHolder {

        //ImageView cardImageview;
        TextView  cardTextview1;
        TextView  cardTextview2;
        TextView  cardTextview3;
        TextView  cardTextview4;

        public MyVViewHolder(@NonNull View itemView) {
            super(itemView);
           // cardImageview= (ImageView) itemView.findViewById(R.id.imagefirstview);
            cardTextview1 =(TextView) itemView.findViewById(R.id.coursenametextview);
            cardTextview2 =(TextView) itemView.findViewById(R.id.subtext1title1);
            cardTextview3 =(TextView) itemView.findViewById(R.id.subtext1title2);
            cardTextview4 =(TextView) itemView.findViewById(R.id.subtext1title3);

        }
    }
}
