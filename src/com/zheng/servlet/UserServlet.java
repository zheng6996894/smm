package com.zheng.servlet;

import com.zheng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    UserServiceImpl us = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         request.setCharacterEncoding("utf8");
//         response.setContentType("text/html;charset=utf8");
//         String flay=request.getParameter("flag");
//         if ("login".equals(flay)){
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        boolean res = us.getUser(username, pwd);
//             Student st=ms.getUser(username,pwd);
        if (!res) {
            response.sendRedirect("login.html");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

        protected void regist (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
//         }else if ("regist".equals(flay)){
            String username = request.getParameter("username");
            String pwd = request.getParameter("pwd");
            boolean res = us.regist(username, pwd);
//              int user = ms.regist(username, pwd);
            if (!res) {
                response.sendRedirect("regist.html");
            } else {
                response.sendRedirect("login.html");
            }
        }
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
