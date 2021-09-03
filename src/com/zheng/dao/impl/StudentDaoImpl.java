package com.zheng.dao.impl;

import com.zheng.dao.StudentDao;
import com.zheng.entity.Student;
import com.zheng.entity.StudentShow;
import com.zheng.util.DbUtil;
import com.zheng.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner qr = DbUtil.getQr();

    public List<StudentShow> getAllStudent() {
//        获取所有学生
        List<StudentShow> list = null;
        String sql = "select*from student";
        try {
            list = qr.query(sql, new BeanListHandler<>(StudentShow.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
   public int getCountRows(){
        //获取所有学生人数
        int rows=0;
        String sql="select count(*) from student";
       try {
           rows= (int)(long)qr.query(sql,new ScalarHandler());
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return rows;
   }
   public List<StudentShow>getStudentByPage(PageUtil pu){
//        根据分页显示学生
        List<StudentShow>list=null;
        String sql="select * from student limit ?,?";
       try {
           list=qr.query(sql,new BeanListHandler<>(StudentShow.class) ,pu.getIndex(),pu.getRows());
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return list;
   }

    @Override
    public int insert(StudentShow stu) {
        int rows=0;
        String sql="insert into student(sname,sage,ssex,semail,photo) values(?,?,?,?,?)";
        try {
            rows=qr.update(sql,stu.getSname(),stu.getSage(),stu.getSsex() ,stu.getSemail(),stu.getPhoto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delStudentBySid(int sid) {
        int rows=0;
        String sql="delete from student where sid=?";
        try {
            rows=qr.update(sql,sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delAll(String sids) {
        int rows=0;
        String sql="delete from student where sid in("+sids+")";
        try {
            rows=qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public StudentShow getStudentBySid(int sid) {
        StudentShow stu=null;
        String sql="select * from student where sid=?";
        try {
            stu=qr.query(sql,new BeanHandler<>(StudentShow.class),sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

    @Override
    public int update(StudentShow stu) {
        int rows=0;
        String sql="update student set sname=?, sage=?,ssex=?," +
                "semail=?, photo=? where sid=?";
        try {
            rows=qr.update(sql,stu.getSname(),stu.getSage(),stu.getSsex(),
            stu.getSemail(),stu.getPhoto(),stu.getSid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int getCountRowsBySname(String sname) {
        int countRows=0;
        String sql="select count(*) from student where sname like '%"+sname+"%'";
        try {
            countRows=(int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<StudentShow> getStudentBySname(String sname, PageUtil pu) {
        List<StudentShow> list=null;
        String sql="select * from student where sname like '%"+sname+"%' limit ?,?";
        try {
            list=qr.query(sql,new BeanListHandler<>(StudentShow.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}


