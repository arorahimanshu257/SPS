package com.example.himanshu.sps;

import com.example.himanshu.sps.STUDENT.StudentLogin;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginCheckStudent {
    @Test
    public void getStringStudent() throws Exception
    {
        StudentLogin login = new StudentLogin();
        String newString = login.logincheck("11607989");
        assertEquals("11607989",newString);
    }
}
