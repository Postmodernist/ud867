package com.example.android.clickcounter;

import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ClickFragmentTest {

  @Rule
  public ActivityTestRule<ClickActivity> activityRule = new ActivityTestRule<>(ClickActivity.class);

  @Before
  public void setUp() {
    activityRule.launchActivity(new Intent());
  }

  @Test
  public void clickButtonExists() {
    onView(withId(R.id.click_button))
        .check(matches(isDisplayed()));
  }

  @Test
  public void counterExists() {
    onView(withId(R.id.click_count_text_view))
        .check(matches(isDisplayed()));
  }

  @Test
  public void buttonClickIncrementsCounter() {
    onView(withId(R.id.click_count_text_view))
        .check(matches(withText("0")));
    onView(withId(R.id.click_button))
        .perform(click());
    onView(withId(R.id.click_count_text_view))
        .check(matches(withText("1")));
  }
}
