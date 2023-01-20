package com.example.loto2023;

import java.util.ArrayList;

public class General {
    public static boolean check(ArrayList<Integer> arr, int toCheckValue) {
        return arr.contains(toCheckValue);
    }

    public static String getAllNumberOfArray(ArrayList<Integer> arr){
        StringBuilder text = new StringBuilder();
        for (int i=0; i<arr.size(); i++){
            text.append(" ").append(arr.get(i).toString());
        }
        return text.toString();
    }

}
