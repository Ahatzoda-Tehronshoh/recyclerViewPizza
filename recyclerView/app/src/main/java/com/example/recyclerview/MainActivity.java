package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static boolean t = true;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Pizza_Adapter pizza_adapter;
    ImageView imageViewDayNight;

    RelativeLayout relativeLayout;
    ConstraintLayout constraintLayoutActivity;
    ConstraintLayout activityMainConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDayNight = findViewById(R.id.imageViewDay);
        relativeLayout = findViewById(R.id.rellay1);
        constraintLayoutActivity = findViewById(R.id.constraintLayoutActivity);
        activityMainConstraintLayout = findViewById(R.id.activityMain);

        recyclerView = findViewById(R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        makeAdapter();

            if(pizza.a) {
                makeAdapter();
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.black));
                imageViewDayNight.setImageResource(R.drawable.ic_baseline_dark_mode_24);
                constraintLayoutActivity.setBackgroundColor(getResources().getColor(R.color.black));
                activityMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.black));
                t = false;
            }

        imageViewDayNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t) {
                    t = false;
                    makeAdapter();
                    constraintLayoutActivity.setBackgroundColor(getResources().getColor(R.color.black));
                    activityMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    imageViewDayNight.setImageResource(R.drawable.ic_baseline_dark_mode_24);
                }else{
                    t = true;
                    makeAdapter();
                    constraintLayoutActivity.setBackgroundColor(getResources().getColor(R.color.design_default_color_error));
                    activityMainConstraintLayout.setBackgroundColor(getResources().getColor(R.color.design_default_color_error));
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    imageViewDayNight.setImageResource(R.drawable.ic_baseline_wb_sunny_24);
                }
            }
        });
    }

    public void makeAdapter(){
        pizza_adapter = new Pizza_Adapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(pizza_adapter);
        recyclerView.setHasFixedSize(true);
    }

}