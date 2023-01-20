package com.example.loto2023;

import static com.example.loto2023.General.check;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Round90Activity extends AppCompatActivity {

    private Button btnStart, btnClear;
    private TextView txtRandomNumber90, txtListNumber90;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_round90);

        mappingElement();

        setOnClick();

    }

    private void mappingElement() {
        txtRandomNumber90 = findViewById(R.id.txtRandomNumber90);
        txtListNumber90 = findViewById(R.id.txtListNumber90);
        btnStart = findViewById(R.id.btnStart90);
        btnClear = findViewById(R.id.btnClear90);
    }

    public void setOnClick() {
        count = 0;

        ArrayList<Integer> list = new ArrayList<>();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < 90) {
                    randomNumber(list);
                    count = count + 1;
                } else {
                    Toast.makeText(Round90Activity.this, "ĐÃ HẾT CỜ RỒI MÀ CÒN CHƯA KINH NỮA SAO?", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRandomNumber90.setText("");
                txtListNumber90.setText("");
                list.clear();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void randomNumber(ArrayList<Integer> listData) {
        int min = 1;
        int max = 90;
        int value;

        do {
            value = (int) (Math.random() * (max - min + 1) + min);
        } while (check(listData, value));

        txtRandomNumber90.setText(value + "");
        listData.add(Integer.valueOf(txtRandomNumber90.getText().toString()));
        txtListNumber90.setText(txtListNumber90.getText() + " " + txtRandomNumber90.getText());
    }
}