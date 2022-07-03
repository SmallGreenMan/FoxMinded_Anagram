package com.gmail.avoishel.foxminded_anagram.utils;

import android.util.Log;

import java.util.regex.Pattern;

public class Utils {

    public static String createAnagram(String text, String filter){

        String[] words = text.split("\\s");

        for (int i=0; i<words.length; i++){
            words[i] = overTurnAWord(words[i], filter);
        }

        return String.join(" ", words);
    }

    private static String overTurnAWord(String word, String filter){

        String alphabeticCharacters = "\\w";
        char[] wChar = word.toCharArray();
        int last = word.length();
        int first = 0;

        while (first < last){

            if (ifCharIsNonAlphabetic(filter, wChar[first])){
                for (int lastLoop = last-1; lastLoop > first; lastLoop--) {    // --- find symbol from end of the word

                    if (ifCharIsNonAlphabetic(filter, wChar[lastLoop])){

                        last = lastLoop;

                        char buffer = wChar[lastLoop];
                        wChar[lastLoop] = wChar[first];
                        wChar[first] = buffer;

                        break;
                    }
                }
            }

            first++;
        }

        return String.valueOf(wChar);
    }

    private static Boolean ifCharIsNonAlphabetic(String filter, char item){
        return (filter.isEmpty())
                    ? Character.isLetter(item)
                    : filter.indexOf(item) < 0;
    }
}
