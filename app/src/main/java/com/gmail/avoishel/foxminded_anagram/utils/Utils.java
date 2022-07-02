package com.gmail.avoishel.foxminded_anagram.utils;

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
        int last = word.length();
        int first = 0;

        while (first < last){

            if (filter.indexOf(wChar[first])<0) {
                for (int lastLoop = last-1; lastLoop > first; lastLoop--) {    // --- find symbol from end of the word
                    if (filter.indexOf(wChar[lastLoop]) < 0 || filter.isEmpty()) {
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
}
