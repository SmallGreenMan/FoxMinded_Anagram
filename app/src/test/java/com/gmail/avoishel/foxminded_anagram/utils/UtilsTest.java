package com.gmail.avoishel.foxminded_anagram.utils;

import static com.gmail.avoishel.foxminded_anagram.utils.Utils.createAnagram;
import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

    private int numberOfTestData = 8;

    private String[] input = new String[] {
            "",
            "Foxminded cool 24/7",
            "abcd efgh",
            "a1bcd efg!h",
            "",
            "Foxminded cool 24/7",
            "abcd efgh",
            "a1bcd efg!h"
    };

    private String[] filter = new String[]{
            "",
            "",
            "",
            "",
            "xl",
            "xl",
            "xl",
            "xl"
    };

    private String[] output = new String[]{
            "",
            "dednimxoF looc 24/7",
            "dcba hgfe",
            "d1cba hgf!e",
            "",
            "dexdnimoF oocl 7/42",
            "dcba hgfe",
            "dcb1a h!gfe"
    };


    @Test
    public void anagramLogic(){
        for (int i = 1; i < numberOfTestData; i++) {
            assertEquals(input[i], createAnagram(output[i], filter[i]));
        }
    }

    @Test(expected = AssertionError.class)
    public void anagramLogicWithException(){
        assertEquals(null, createAnagram("", ""));
        assertEquals("", createAnagram(null, ""));
    }

}