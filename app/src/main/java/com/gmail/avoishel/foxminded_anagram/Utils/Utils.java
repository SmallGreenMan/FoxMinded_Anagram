package com.gmail.avoishel.foxminded_anagram.Utils;

import android.util.Log;

public abstract class Utils {

    public static String CreateAnagram(String text, String filter){

        StringBuilder result = new StringBuilder();

        String[] words = text.split(" ");

        for (String w : words) {

            if (result.length() > 0)
                result.append(" ");
            result.append(OverTurnAWord(w, filter));
        }

        return result.toString();
    }

    private static String OverTurnAWord (String word, String filter){

        StringBuilder result = new StringBuilder();

        char[] wChar = word.toCharArray();
        int lastPosition = word.length();

        for (int i=0; i<word.length(); i++){

            if (filter.indexOf(wChar[i])<0) {
                //Log.i("TAG", String.format("-----> Character :%s not found in filter: %s", wChar[i], filter));
                for (int p = lastPosition-1; p > -1; p--) {    // --- find symbol from end of the word
                    if (filter.indexOf(wChar[p]) < 0) {
                        lastPosition = p;
                        result.append(wChar[p]);
                        //Log.i("TAG", String.format("-----> Add Character :%s to result: %s", wChar[p], result));
                        break;
                    }
                }
            } else {
                result.append(wChar[i]);                        // --- symbol protected
            }
        }

        return result.toString();
    }
}
