package com.zheng.servlet;

import com.zheng.entity.StudentShow;
import com.zheng.service.impl.StudentServiceImpl;
import com.zheng.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet("/Student")
public class StudentServlet extends BaseServlet {
    StudentServiceImpl ss = new StudentServiceImpl();

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取相关注册信息
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        String semail = request.getParameter("semail");
//         文件对象的处理
        Part p = request.getPart("photo");
        String photo = UUID.randomUUID() + p.getSubmittedFileName();
        String path = "D:\\photo";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        p.write(path + "/" + photo);
        //获取数据放入数据库
        StudentShow stu = new StudentShow(0, sname, sage, ssex, semail, photo);
        boolean res = ss.insert(stu);
        if (res) {
            response.sendRedirect("Student?flag=getStudentByPage");
        } else {
            response.sendRedirect("add.jsp");
        }
    }

    protected void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有学生信息
        List<StudentShow> list = ss.getAllStudent();
        request.setAttribute("stuList", list);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    protected void getStudentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页码
        String page = request.getParameter("page");
//        指定每页显示条数信息
        int rows = 2;
//        获取数据总条数
        int countRows = ss.getCountRows();
        //初始化分页工具
        PageUtil pu = new PageUtil(page, rows, countRows);
//        获取指定页面的数据
        List<StudentShow> list = ss.getStudentByPage(pu);
        request.setAttribute("stuList", list);
        request.setAttribute("pu", pu);

        //请求跳转到学生查看表
        request.getRequestDispatcher("student.jsp").forward(request, response);

    }

    protected void delStudentBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除指定学生
        int sid = Integer.parseInt(request.getParameter("sid"));
        boolean res = ss.delStudentBySid(sid);
        response.sendRedirect("Student?flag=getStudentByPage");
    }

    protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //批量删除
        String sids = request.getParameter("sids");
        boolean res = ss.delAll(sids);
        response.sendRedirect("Student?flag=getStudentByPage");
    }

    protected void getStudentBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //更改
        int sid = Integer.parseInt(request.getParameter("sid"));
        StudentShow stu = ss.getStudentBySid(sid);
        request.setAttribute("stu", stu);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //更改
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        String semail = request.getParameter("semail");
        String photo = "";
//         文件对象的处理
        Part p = request.getPart("photo");
        String fileName = p.getSubmittedFileName();

/**
 * 本段获取文件后缀名
 * 再加上随机名组成文件名，
 * 避免文件名长度累加
 */
        //获取文件后缀.jpg(注意："."是转义字符。要加\\.)
        String[] split = fileName.split("\\.");
        //注意："."是转义字符。要加\\.
        fileName = split[split.length - 1];//jpg

        if ("".equals(fileName)) {
            photo = request.getParameter("oldPhoto");
        } else {
            //文件后缀前加上 .
            photo = UUID.randomUUID() + "." + fileName;
            String path = "D:\\photo";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            p.write(path + "\\" + photo);
        }
        StudentShow stu = new StudentShow(sid, sname, sage, ssex, semail, photo);
        boolean res = ss.update(stu);
        if (res) {
            response.sendRedirect("Student?flag=getStudentByPage");
        } else {
            response.sendRedirect("Student?flag=getStudentBySid&sid=" + sid);
        }
    }

    protected void getStudentBySname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        String page=request.getParameter("page");
        int rows=2;
        int countRows=ss.getCountRowsBySname(sname);
        PageUtil pu=new PageUtil(page,rows,countRows);
        List<StudentShow>list=ss.getStudentBySname(sname,pu);
        request.setAttribute("stuList",list);
        request.setAttribute("pu",pu);
        request.setAttribute("sname",sname);
        request.getRequestDispatcher("student.jsp").forward(request,response);
    }


}

