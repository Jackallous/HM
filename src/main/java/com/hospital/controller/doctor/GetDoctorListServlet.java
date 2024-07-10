package com.hospital.controller.doctor;


import com.github.pagehelper.PageInfo;
import com.hospital.pojo.DoctorQuery;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//处理分页多条件查询
@WebServlet("/doctor/getDoctorList")
public class GetDoctorListServlet extends HttpServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String did = req.getParameter("did");//科室id
        String pid = req.getParameter("pid");//职称id
        String dname = req.getParameter("dname");//姓名
        String jobnum = req.getParameter("jobnum");//工号
        String page = req.getParameter("page");//当前页

        //船舰对象封装参数
        DoctorQuery doctorQuery = new DoctorQuery(did, pid, dname, jobnum, page);
        //调用业务层查询方法
        PageInfo pageInfo = doctorService.getDoctorListPage(doctorQuery);
        //把分页对象设置到request作用域中
        req.setAttribute("pageInfo",pageInfo);
        System.out.println(doctorQuery.getDname());
        req.setAttribute("doctorQuery",doctorQuery);
        req.getRequestDispatcher("/doctorList.jsp").forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
