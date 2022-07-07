package com.gmail.avoishel.foxminded_anagram.ui;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
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
        String inputText = "Foxminded cool 24/7";
        String filterText = "xl";
        String expectedText = "dexdnimoF oocl 7/42";

        onView(withId(R.id.textInputView)).perform(typeText(inputText));
        onView(withId(R.id.textFilterView)).perform(typeText(filterText));
        onView(withId(R.id.resultTextView)).check(matches(withText(expectedText)));
    }
}
