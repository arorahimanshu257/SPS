package com.example.himanshu.sps.ADMIN;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.himanshu.sps.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalStudentTest {

    @Rule
    public ActivityTestRule<FinalStudent> obj = new ActivityTestRule<FinalStudent>(FinalStudent.class);
    private  FinalStudent finalStudent = null;
    @Before
    public void setUp() throws Exception
    {
        finalStudent = obj.getActivity();
    }

    @Test
    public void testLaunch()
    {
        View view = finalStudent.findViewById(R.id.rname);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception
    {
        finalStudent = null;
    }
}