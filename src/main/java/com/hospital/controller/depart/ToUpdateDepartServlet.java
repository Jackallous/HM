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

//跳转修改页面，根据主键id查询科室对象
@WebServlet("/depart/toUpdate")
public class ToUpdateDepartServlet extends HttpServlet {

    private DepartmentsService departmentsService = new DepartmentsServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String did = req.getParameter("did");
        //调用业务层根据主键id查询返回科室对象的方法
        Departments departments = departmentsService.getDepartmentById(did);

        req.setAttribute("departments", departments);
        //跳转修改页面
        req.getRequestDispatcher("/updateDepart.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
