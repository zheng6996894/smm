package com.zheng.dao;

import com.zheng.entity.Student;

public interface UserDao {
    public Student  getUser(String username, String pwd);
    public int regist(String username, String pwd);
}
