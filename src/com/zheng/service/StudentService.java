package com.zheng.service;

import com.zheng.entity.StudentShow;
import com.zheng.util.PageUtil;

import java.util.List;


public interface StudentService {
    public List<StudentShow> getAllStudent();
    public int getCountRows();
    public List<StudentShow>getStudentByPage(PageUtil pu);
    public boolean insert(StudentShow stu);
    public boolean delStudentBySid(int sid);
    public boolean delAll(String sids);
    public StudentShow getStudentBySid(int sid);
    public boolean update(StudentShow stu);
    public int getCountRowsBySname(String sname);
    public List<StudentShow>getStudentBySname(String sname,PageUtil pu);
}

