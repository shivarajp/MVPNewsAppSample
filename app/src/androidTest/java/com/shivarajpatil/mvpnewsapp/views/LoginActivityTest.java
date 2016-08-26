package com.shivarajpatil.mvpnewsapp.views;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.shivarajpatil.mvpnewsapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by SYS on 26-Aug-2016.
 */

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void wrongEmailLoginFailTest() {
        onView(allOf(withId(R.id.etEmail), isDisplayed()))
                .perform(typeText("wrongEmail"));
        onView(allOf(withId(R.id.etPwd), isDisplayed()))
                .perform(typeText("password123"));

        closeSoftKeyboard();

        //Idling resource
        /*LoginIdlingResource loginidlingResource = new LoginIdlingResource(5000);
        registerIdlingResources(loginidlingResource);*/

        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
                .perform(click());

        //onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(allOf(withText("Wrong credentials"), isDisplayed()));
    }

    @Test
    public void LoginSuccessTest() {
        onView(allOf(withId(R.id.etEmail), isDisplayed()))
                .perform(typeText("shivaraj"));
        onView(allOf(withId(R.id.etPwd), isDisplayed()))
                .perform(typeText("password123"));
        closeSoftKeyboard();
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.rvNewsHeadlines), isDisplayed()));
    }

}
