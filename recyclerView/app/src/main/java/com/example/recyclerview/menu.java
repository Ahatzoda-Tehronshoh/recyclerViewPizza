package com.example.recyclerview;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

public class menu extends AppCompatActivity {

    private static  int time = 3000;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        progressBar = findViewById(R.id.progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(100);
                Intent intent = new Intent(menu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },time);

    }
}