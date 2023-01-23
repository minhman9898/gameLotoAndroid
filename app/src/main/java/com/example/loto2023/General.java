package com.example.loto2023;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class General {

    public static boolean check(ArrayList<Integer> arr, int toCheckValue) {
        return arr.contains(toCheckValue);
    }

    public static String getAllNumberOfArray(ArrayList<Integer> arr) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            text.append(" ").append(arr.get(i).toString());
        }
        return text.toString();
    }

    public static String randomLinkAudio(JSONArray list) {
        //Random link audio in list link
        Random r = new Random();
        int low = 0;
        int high = list.length();
        int result = r.nextInt(high - low) + low;

        System.out.println(result);

        try {
            return (String) list.get(result);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("audio_file.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
