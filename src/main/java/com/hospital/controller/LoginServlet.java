package com.hospital.controller;


//处理医院管理登录请求

import com.hospital.pojo.Admins;
import com.hospital.pojo.Doctors;
import com.hospital.service.AdminService;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.AdminServiceImpl;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();
    private DoctorService doctorService = new DoctorServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //从请求中获取参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String rid = req.getParameter("rid");
        //根据rid判断登录方式(不能使用==，比较的是指针;rid可能为null,"1"不会为空)
        if ("1".equals(rid)) {//管理员

            //调用管理员登录的方法
            Admins admins = adminService.login(name,password);
            if(admins!=null){
                req.getSession().setAttribute("admins",admins);
                //重定向到管理员页面
                resp.sendRedirect(req.getContextPath()+"/adminIndex.jsp");

            }else{
                //重定向到登录页面
                resp.sendRedirect(req.getContextPath()+"/login.jsp?flag=f");
            }

        } else if("2".equals(rid)){//医生

            //调用医生登录
            Doctors doctors = doctorService.login(name,password);
            if(doctors!=null){
                req.getSession().setAttribute("doctors",doctors);
                //重定向到医生页面
                resp.sendRedirect(req.getContextPath()+"/doctorIndex.jsp");


            }else{
                resp.sendRedirect(req.getContextPath()+"/login.jsp?flag=f");

            }

        }
    }
}
