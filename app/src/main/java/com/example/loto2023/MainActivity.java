package com.example.loto2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private Button btnRound60, btnRound90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        //get event
        setOnClick();
    }

    /*
    @著者: Man Nguyen
    @機能：新しい画面を移動する。
     */
    public void setOnClick() {
        btnRound60 = findViewById(R.id.btn_newRound60);
        btnRound60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Round60Activity.class));
            }
        });

        btnRound90 = findViewById(R.id.btn_newRound90);
        btnRound90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Round90Activity.class));
            }
        });
    }

}