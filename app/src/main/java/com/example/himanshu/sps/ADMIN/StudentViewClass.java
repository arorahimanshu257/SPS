package com.example.himanshu.sps.ADMIN;

public class StudentViewClass
{
    String stname;

    public StudentViewClass(String stname, String stid, String stbranch,String cgpa) {
        this.stname = stname;
        this.cgpa = cgpa;
        this.stid = stid;
        this.stbranch = stbranch;
    }

    String cgpa;

    public String getCgpa() {
        return cgpa;
    }

    public String getStname() {
        return stname;
    }

    public String getStid() {
        return stid;
    }

    public String getStbranch() {
        return stbranch;
    }

    String stid;
    String stbranch;
}
