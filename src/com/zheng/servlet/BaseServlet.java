package com.zheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet{
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        String flag=request.getParameter("flag");
        Class c = this.getClass();
        try {
            Method m =c.getDeclaredMethod(flag, HttpServletRequest.class,
                    HttpServletResponse.class);
            m.setAccessible(true);
            m.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
