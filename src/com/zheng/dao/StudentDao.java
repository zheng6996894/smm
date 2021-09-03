package com.zheng.dao;

import com.zheng.entity.Student;
import com.zheng.entity.StudentShow;
import com.zheng.util.PageUtil;

import javax.servlet.jsp.tagext.JspIdConsumer;
import java.util.List;

public interface StudentDao {
    public List<StudentShow> getAllStudent();
    public int getCountRows();
    public List<StudentShow>getStudentByPage(PageUtil pu);
//    public int setAddStudent(String sname,int sage,String ssex,String semail);
    public int insert(StudentShow stu);
    public int delStudentBySid(int sid);
    public int delAll(String sids);
    public StudentShow getStudentBySid(int sid);
    public int update(StudentShow stu);
    public int getCountRowsBySname(String sname);
    public List<StudentShow>getStudentBySname(String sname,PageUtil pu);
}
