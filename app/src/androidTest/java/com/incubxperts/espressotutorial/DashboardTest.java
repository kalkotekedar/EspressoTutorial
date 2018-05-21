package com.incubxperts.espressotutorial;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

/**
 * Created by ac on 8/17/2017.
 */

public class DashboardTest {

    @Rule
    public ActivityTestRule<Dashboard> mActivity = new ActivityTestRule<>(Dashboard.class);

    @Test
    public void checkUI() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));

        hasEntry(equalTo("ABC"), is("items: 0"));

        onView(ViewMatchers.withId(R.id.rv_titles))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, ViewActions.click()));
    }
}