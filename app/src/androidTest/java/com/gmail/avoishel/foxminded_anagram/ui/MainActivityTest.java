package com.gmail.avoishel.foxminded_anagram.ui;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.gmail.avoishel.foxminded_anagram.R;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

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

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void checkAnagramLogic() {

        for (int i = 1; i < input.length; i++) {
            onView(withId(R.id.textInputView)).perform(clearText()).perform(typeText(input[i]));
            onView(withId(R.id.textFilterView)).perform(clearText()).perform(typeText(filter[i]));
            onView(withId(R.id.resultTextView)).check(matches(withText(output[i])));
        }
    }
}
