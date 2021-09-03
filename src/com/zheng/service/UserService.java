package com.zheng.service;


public interface UserService {
    public boolean  getUser(String username, String pwd);
    public boolean regist(String username, String pwd);
}
