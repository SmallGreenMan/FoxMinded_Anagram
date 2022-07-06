package com.gmail.avoishel.foxminded_anagram.utils;

import static com.gmail.avoishel.foxminded_anagram.utils.Utils.createAnagram;
import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void anagramWithEmptyFilter_0(){
        String input = "";
        String filter = "";
        String expected = "";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }

    @Test
    public void anagramWithEmptyFilter_1(){
        String input = "Foxminded cool 24/7";
        String filter = "";
        String expected = "dednimxoF looc 24/7";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }

    @Test
    public void anagramWithEmptyFilter_2(){
        String input = "abcd efgh";
        String filter = "";
        String expected = "dcba hgfe";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }

    @Test
    public void anagramWithEmptyFilter_3(){
        String input = "a1bcd efg!h";
        String filter = "";
        String expected = "d1cba hgf!e";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }


    @Test
    public void anagramWithExtendFilter_0(){
        String input = "";
        String filter = "xl";
        String expected = "";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }

    @Test
    public void anagramWithExtendFilter_1(){
        String input = "Foxminded cool 24/7";
        String filter = "xl";
        String expected = "dexdnimoF oocl 7/42";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }

    @Test
    public void anagramWithExtendFilter_2(){
        String input = "abcd efgh";
        String filter = "xl";
        String expected = "dcba hgfe";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }

    @Test
    public void anagramWithExtendFilter_3(){
        String input = "a1bcd efglh";
        String filter = "xl";
        String expected = "dcb1a hgfle";

        String output = createAnagram(input, filter);

        assertEquals(expected, output);
    }
}