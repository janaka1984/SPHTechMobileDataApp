package com.example.mobiledataapp;

import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    private  MainActivity mainActivity=null;
    private String stringResult;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLaunch()
    {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
        onView(withId(R.id.recyclerView)).notify();
    }

    @Test
    public void volleyJsonArrayRequest() {
    }

    @Test
    public void startfunctio() {

    }

    @Test
    public void replace() {
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.

    }


}