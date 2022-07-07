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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.gmail.avoishel.foxminded_anagram.R;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void allUiElementsIsDisplayed() {
        onView(withId(R.id.textInputView)).check(matches(isDisplayed()));
        onView(withId(R.id.textFilterView)).check(matches(isDisplayed()));
        onView(withId(R.id.resultTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkAnagramLogic() {
        String[][] testData = new String[][]
                {    // - input                - filter - output
                        {"Foxminded cool 24/7", "",     "dednimxoF looc 24/7"},
                        {"abcd efgh",           "",     "dcba hgfe"},
                        {"a1bcd efg!h",         "",     "d1cba hgf!e"},

                        {"Foxminded cool 24/7", "xl",   "dexdnimoF oocl 7/42"},
                        {"abcd efgh",           "xl",   "dcba hgfe"},
                        {"a1bcd efg!h",         "xl",   "dcb1a h!gfe"},
                };

        for (String[] data : testData) {
            onView(withId(R.id.textInputView)).perform(clearText()).perform(typeText(data[0]));
            onView(withId(R.id.textFilterView)).perform(clearText()).perform(typeText(data[1]));
            onView(withId(R.id.resultTextView)).check(matches(withText(data[2])));
        }
    }
}
