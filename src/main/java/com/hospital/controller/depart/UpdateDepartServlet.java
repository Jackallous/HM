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


//处理科室的修改请求
@WebServlet("/depart/updateDepart")
public class UpdateDepartServlet extends HttpServlet {

    private DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String departname = req.getParameter("departname");
        String departdesc = req.getParameter("departdesc");
        String id = req.getParameter("id");//当前修改记录的主键id
        //把参数封装给Departments对象
        Departments departments = new Departments();
        departments.setDepartmentDescription(departdesc);
        departments.setDepartmentName(departname);
        if(id !=null && !id.equals("")){
            departments.setDepartmentId(Integer.parseInt(id));
        }
        boolean flag = departmentsService.updateDepartMent(departments);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/depart/getDepartList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
