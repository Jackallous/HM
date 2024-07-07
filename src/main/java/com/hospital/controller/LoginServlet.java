package com.hospital.controller;

import com.hospital.pojo.User;
import com.hospital.service.Impl.UserServiceImpl;
import com.hospital.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String user_username = req.getParameter("user_username");
        String user_password = req.getParameter("user_password");


        User u =userService.login(user_username,user_password);

        if(u!=null)
        {
            req.getSession().setAttribute("user", u);
            //跳转到系统内容页面 发送getStudentList
            resp.sendRedirect(req.getContextPath() + "/getUserList");
        }else{
            resp.sendRedirect(req.getContextPath() + "/login.jsp?flag=false");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
