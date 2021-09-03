package com.zheng.service.impl;

import com.zheng.dao.impl.StudentDaoImpl;
import com.zheng.entity.StudentShow;
import com.zheng.service.StudentService;
import com.zheng.util.PageUtil;

import java.util.List;

/**
 * 将获取到dao当中的数据再次进行二次处理
 * 得到servlet所需要的数据
 * */
public class StudentServiceImpl implements StudentService {
    StudentDaoImpl sd=new StudentDaoImpl();
    public List<StudentShow>getAllStudent(){
        List<StudentShow> list=sd.getAllStudent();
        return list;
    }

    @Override
    public int getCountRows() {
        int countRows=sd.getCountRows();
        return countRows;
    }

    @Override
    public List<StudentShow> getStudentByPage(PageUtil pu) {
        List<StudentShow>list=sd.getStudentByPage(pu);
        return list;
    }

    @Override
    public boolean insert(StudentShow stu) {
        int rows=sd.insert(stu);
        boolean res=true;
        if (rows == 0) {
            res=false;
        }
        return res;

    }

    @Override
    public boolean delStudentBySid(int sid) {
        int rows=sd.delStudentBySid(sid);
        boolean res=true;
        if (rows==0){
            res=false;
        }
        return res;
    }

    @Override
    public boolean delAll(String sids) {
         int rows=sd.delAll(sids);
         boolean res=true;
        if (rows == 0) {
            res=false;
        }
        return res;
    }

    @Override
    public StudentShow getStudentBySid(int sid) {
        return sd.getStudentBySid(sid);
    }

    @Override
    public boolean update(StudentShow stu) {
        int rows=sd.update(stu);
        boolean res=true;
        if (rows == 0) {
            res=false;
        }
        return res;
    }

    @Override
    public int getCountRowsBySname(String sname) {
        return sd.getCountRowsBySname(sname);
    }

    @Override
    public List<StudentShow> getStudentBySname(String sname, PageUtil pu) {
        return sd.getStudentBySname(sname,pu);
    }

}

