package com.gmail.avoishel.foxminded_anagram.utils;

import static com.gmail.avoishel.foxminded_anagram.utils.Utils.createAnagram;
import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

public class UtilsTest {

    @Test
    public void anagramLogic(){
        String[][] testData = new String[][]
                {    // - input                - filter - output
                        {"",                    "",     ""},
                        {"Foxminded cool 24/7", "",     "dednimxoF looc 24/7"},
                        {"abcd efgh",           "",     "dcba hgfe"},
                        {"a1bcd efg!h",         "",     "d1cba hgf!e"},

                        {"",                    "xl",   ""},
                        {"Foxminded cool 24/7", "xl",   "dexdnimoF oocl 7/42"},
                        {"abcd efgh",           "xl",   "dcba hgfe"},
                        {"a1bcd efg!h",         "xl",   "dcb1a h!gfe"}
                };

        for (String[] data : testData) {
            assertEquals(data[0], createAnagram(data[2], data[1]));
        }
    }

    @Test(expected = AssertionError.class)
    public void anagramLogicWithException(){
        String[][] testData = new String[][]
                {    // - input                - filter - output
                        {null,                 "",      ""},
                        {"",                   null,    ""}
                };

        for (String[] data : testData) {
            assertEquals(data[0], createAnagram(data[2], data[1]));
        }
    }

}