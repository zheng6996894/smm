package com.zheng.dao.impl;

import com.zheng.dao.UserDao;
import com.zheng.entity.Student;
import com.zheng.util.DbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    QueryRunner qr= DbUtil.getQr();

    public Student getUser(String username,String pwd){
        Student st=null;
        String sql="select * from db_user where username=? and pwd=?";
        try {
            st=qr.query(sql,new BeanHandler<>(Student.class),username,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
    public int regist(String username,String pwd){
        int rows=0;
        String sql="insert into db_user(username,pwd)values(?,?)";
        try {
            rows=qr.update(sql,username,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

}
