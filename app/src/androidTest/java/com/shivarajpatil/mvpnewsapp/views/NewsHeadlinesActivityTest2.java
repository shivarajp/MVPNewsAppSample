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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsHeadlinesActivityTest2 {

    @Rule
    public ActivityTestRule<NewsHeadlinesActivity> mActivityTestRule = new ActivityTestRule<>(NewsHeadlinesActivity.class);

    @Test
    public void newsHeadlinesActivityTest2() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rvNewsHeadlines), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.rvNewsHeadlines), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(3, click()));

        pressBack();

        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"), isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Settings"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.rvNewsHeadlines), isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(1, click()));

        pressBack();

        ViewInteraction imageView = onView(
                allOf(withId(R.id.ivNewsIcon),
                        withParent(allOf(withId(R.id.clNewsRowContainer),
                                withParent(withId(R.id.rvNewsHeadlines)))),
                        isDisplayed()));
//        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.tvNewsHeading), withText("Indonesia disappointed after Barack Obama delays trip "),
                        withParent(allOf(withId(R.id.clNewsRowContainer),
                                withParent(withId(R.id.rvNewsHeadlines)))),
                        isDisplayed()));
        textView.check(matches(withText("Indonesia disappointed after Barack Obama delays trip ")));

    }

}
