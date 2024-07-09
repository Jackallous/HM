package com.hospital.controller.depart;


import com.hospital.pojo.Departments;
import com.hospital.service.DepartmentsService;
import com.hospital.service.Impl.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//处理科室的删除请求根据主键id
@WebServlet("/depart/deleteById")
public class DeleteByIdDepartServlet extends HttpServlet {

    private DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");//当前修改记录的主键id
        //把参数封装给Departments对象

        boolean flag = departmentsService.deleteByIdDepartMent(id);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/depart/getDepartList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
