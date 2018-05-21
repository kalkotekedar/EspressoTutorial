package com.incubxperts.espressotutorial;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class LoginScreenTest {

    @Rule
    public ActivityTestRule<LoginScreen> mActivityTestRule = new ActivityTestRule<>(LoginScreen.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.incubxperts.espressotutorial", appContext.getPackageName());
    }

    @Test
    public void loginScreenTest() {
        onView(withId(R.id.input_username)).perform(typeText("kalkotekedar"));

        onView(withId(R.id.input_password)).perform(typeText("kalkotedar"));

        onView(withId(R.id.button_login)).perform(click());

        onView(withText("OK")).perform(pressBack());

        onView(withId(R.id.input_username)).perform(clearText());

        onView(withId(R.id.input_password)).perform(clearText());

        onView(withId(R.id.input_username)).perform(typeText("kalkotekedar"));

        onView(withId(R.id.input_password)).perform(typeText("kalkotekedar"));

        onView(withId(R.id.input_password)).check(matches(withText("kalkotekedar")));

        onView(withId(R.id.button_login)).perform(click());
    }
}