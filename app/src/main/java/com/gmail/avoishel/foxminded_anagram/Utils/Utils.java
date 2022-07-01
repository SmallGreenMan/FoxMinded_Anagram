package com.gmail.avoishel.foxminded_anagram.Utils;

public class Utils {

    public static String createAnagram(String text, String filter){

        String[] words = text.split("\\s");

        for (int i=0; i<words.length; i++){
            words[i] = overTurnAWord(words[i], filter);
        }

        return String.join(" ", words);
    }

    private static String overTurnAWord(String word, String filter){

        char[] wChar = word.toCharArray();
        int lastPosition = word.length();

        for (int i=0; i<word.length(); i++){

            if (filter.indexOf(wChar[i])<0) {
                for (int p = lastPosition-1; p > i; p--) {    // --- find symbol from end of the word
                    if (filter.indexOf(wChar[p]) < 0) {
                        lastPosition = p;

                        char buffer = wChar[p];
                        wChar[p] = wChar[i];
                        wChar[i] = buffer;

                        break;
                    }
                }
            }
        }

        return String.valueOf(wChar);
    }
}
