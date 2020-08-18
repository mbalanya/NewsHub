package com.chalookoba.newshub;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.headlineEditText)).perform(typeText("sports"))
                .check(matches(withText("sports")));
    }

    @Test
    public void headlineIsSentToTrendingNewsActivity() {
        String headline = "Business";
        onView(withId(R.id.headlineEditText)).perform(typeText(headline)).perform(closeSoftKeyboard());
        try{
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.trendingNewsButton)).perform(click());
        onView(withId(R.id.headlineTextView)).check(matches
                (withText("Here is the trending news about " + headline)));
    }
}
