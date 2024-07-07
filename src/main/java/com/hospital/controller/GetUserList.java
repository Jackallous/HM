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
import java.util.List;


@WebServlet("/getUserList")
public class GetUserList extends HttpServlet {

    private UserService userService= new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.getUserList();
        System.out.println("userList: " + userList);
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("userList.jsp").forward(req, resp);


    }
}
