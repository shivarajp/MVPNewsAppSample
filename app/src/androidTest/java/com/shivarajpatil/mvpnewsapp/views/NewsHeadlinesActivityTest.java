package com.shivarajpatil.mvpnewsapp.views;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.shivarajpatil.mvpnewsapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsHeadlinesActivityTest {

    @Rule
    public ActivityTestRule<NewsHeadlinesActivity> mActivityTestRule = new ActivityTestRule<>(NewsHeadlinesActivity.class);

    @Test
    public void newsHeadlinesActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rvNewsHeadlines), isDisplayed()));
        /*recyclerView.perform(actionOnItemAtPosition(0, click()));

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.rvNewsHeadlines), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(2, click()));

        pressBack();*/

    }
}
