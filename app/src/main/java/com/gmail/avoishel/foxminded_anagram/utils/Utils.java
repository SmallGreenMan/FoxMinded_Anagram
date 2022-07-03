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
        int last = word.length()-1;
        int first = 0;

        while (first < last){
            if (isFiltered(filter, wChar[first])){
                first++;
            } else if (isFiltered(filter, wChar[last])){
                last--;
            } else {
                char buffer = wChar[last];
                wChar[last] = wChar[first];
                wChar[first] = buffer;
                first++;
                last--;
            }
        }

        return String.valueOf(wChar);
    }

    private static Boolean isFiltered(String filter, char item){
        return (filter.isEmpty())
                    ? !Character.isLetter(item)
                    : filter.indexOf(item) < 0;
    }
}
