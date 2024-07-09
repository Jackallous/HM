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


//完成科室的添加
@WebServlet("/depart/addDepart")
public class AddDepartServlet extends HttpServlet {

    private DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String departname = req.getParameter("departname");
        String departdesc = req.getParameter("departdesc");
        String pid = req.getParameter("pid");
        //把参数封装给Departments对象
        Departments departments = new Departments();
        departments.setDepartmentDescription(departdesc);
        departments.setDepartmentName(departname);
        if(pid != null && !pid.equals("")){
            int dpid = Integer.parseInt(pid);
            departments.setDepartmentPid(dpid);
            if(dpid == 0){//父级id是0一定是一级科室
                departments.setDepartmentLevel(1);
            }else{
                departments.setDepartmentLevel(2);
            }

        }
        System.out.println(departments);
        System.out.println("调用");
        boolean flag = departmentsService.addDepartMent(departments);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/depart/getDepartList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
