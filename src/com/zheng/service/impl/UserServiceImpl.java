package com.zheng.service.impl;

import com.zheng.dao.impl.UserDaoImpl;
import com.zheng.entity.Student;
import com.zheng.service.UserService;

public class UserServiceImpl implements UserService {

    UserDaoImpl ms=new UserDaoImpl();
    public boolean getUser(String username,String pwd){
        Student student=ms.getUser(username,pwd);
        boolean res=true;
        if (student==null){
            res=false;
        }
        return res;
    }
    public boolean regist(String username,String pwd){
       int rows=ms.regist(username,pwd);
       boolean res=true;
       if (rows==0){
          res=false;

       }
       return res;
    }
}
