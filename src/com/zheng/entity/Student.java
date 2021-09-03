package com.zheng.entity;

public class Student {
    private int sid;
    private String username;
    private String pwd;


    public Student() {
    }

    public Student(int sid, String username, String pwd) {
        this.sid = sid;
        this.username = username;
        this.pwd = pwd;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
