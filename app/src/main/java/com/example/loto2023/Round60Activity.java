package com.example.loto2023;

import static com.example.loto2023.General.check;
import static com.example.loto2023.General.getAllNumberOfArray;
import static com.example.loto2023.General.loadJSONFromAsset;
import static com.example.loto2023.General.randomLinkAudio;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Round60Activity extends AppCompatActivity {

    private Button btnStart, btnClear;

    @SuppressLint("StaticFieldLeak")
    static TextView txtRandomNumber, txtListNumber0to9, txtListNumber10to19, txtListNumber20to29, txtListNumber30to39, txtListNumber40to49, txtListNumber50to59, txtListNumber60;
    private int count;

    static ArrayList<Integer> listAll, list1, list2, list3, list4, list5, list6, list7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_round60);

        mappingElement();

        setOnClick();
    }

    private void mappingElement() {
        txtRandomNumber = findViewById(R.id.txtRandomNumber);
        txtListNumber0to9 = findViewById(R.id.txtListNumber0to9);
        txtListNumber10to19 = findViewById(R.id.txtListNumber10to19);
        txtListNumber20to29 = findViewById(R.id.txtListNumber20to29);
        txtListNumber30to39 = findViewById(R.id.txtListNumber30to39);
        txtListNumber40to49 = findViewById(R.id.txtListNumber40to49);
        txtListNumber50to59 = findViewById(R.id.txtListNumber50to59);
        txtListNumber60 = findViewById(R.id.txtListNumber60);
        btnStart = findViewById(R.id.btnStart);
        btnClear = findViewById(R.id.btnClear);
    }

    public void setOnClick() {
        count = 0;
        listAll = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        list7 = new ArrayList<>();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < 60) {
                    randomNumber();
                    count = count + 1;
                } else {
                    Toast.makeText(Round60Activity.this, "ĐÃ HẾT CỜ RỒI MÀ CÒN CHƯA KINH NỮA SAO?", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                txtRandomNumber.setText("");
                txtListNumber0to9.setText("");
                txtListNumber10to19.setText("");
                txtListNumber20to29.setText("");
                txtListNumber30to39.setText("");
                txtListNumber40to49.setText("");
                txtListNumber50to59.setText("");
                txtListNumber60.setText("");
                listAll.clear();
                list1.clear();
                list2.clear();
                list3.clear();
                list4.clear();
                list5.clear();
                list6.clear();
                list7.clear();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void randomNumber() {

        int min = 1;
        int max = 60;
        int value;

        do {
            value = (int) (Math.random() * (max - min + 1) + min);
        } while (check(listAll, value));

        txtRandomNumber.setText(value + "");

        try {
            JSONObject obj = new JSONObject(Objects.requireNonNull(loadJSONFromAsset(this)));
            play_song(randomLinkAudio(obj.getJSONArray(String.valueOf(value))));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        if (1 <= value && value <= 9) {
            list1.add(value);
            Collections.sort(list1);
            txtListNumber0to9.setText(getAllNumberOfArray(list1));
        } else if (10 <= value && value <= 19) {
            list2.add(value);
            Collections.sort(list2);
            txtListNumber10to19.setText(getAllNumberOfArray(list2));
        } else if (20 <= value && value <= 29) {
            list3.add(value);
            Collections.sort(list3);
            txtListNumber20to29.setText(getAllNumberOfArray(list3));
        } else if (30 <= value && value <= 39) {
            list4.add(value);
            Collections.sort(list4);
            txtListNumber30to39.setText(getAllNumberOfArray(list4));
        } else if (40 <= value && value <= 49) {
            list5.add(value);
            Collections.sort(list5);
            txtListNumber40to49.setText(getAllNumberOfArray(list5));
        } else if (50 <= value && value <= 59) {
            list6.add(value);
            Collections.sort(list6);
            txtListNumber50to59.setText(getAllNumberOfArray(list6));
        } else {
            list7.add(value);
            Collections.sort(list7);
            txtListNumber60.setText(getAllNumberOfArray(list7));
        }

        listAll.add(Integer.valueOf(txtRandomNumber.getText().toString()));
    }

    public static void play_song(String url) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
//            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/loto2023.appspot.com/o/number1.mp3?alt=media&token=d3ce2cfa-7cb8-410e-84e6-7fc00526f19f");
            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}