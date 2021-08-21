package com.example.himanshu.sps.ADMIN;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.himanshu.sps.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> obj = new ActivityTestRule<MainActivity>(MainActivity.class);
    private  MainActivity mainActivity = null;
    @Before
    public void setUp() throws Exception
    {
        mainActivity = obj.getActivity();
    }

    @Test
    public void testLaunch()
    {
        View view = mainActivity.findViewById(R.id.tpo);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception
    {
        mainActivity = null;
    }

}