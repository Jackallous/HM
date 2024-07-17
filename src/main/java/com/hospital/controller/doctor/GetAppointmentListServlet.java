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
@WebServlet("/doctor/getAppointmentList")
public class GetAppointmentListServlet extends HttpServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String docid = req.getParameter("docid");//科室id
        String page = req.getParameter("page");//当前页

        //调用业务层查询方法
        PageInfo pageInfo = doctorService.getAppointmentList(page,docid);
        //把分页对象设置到request作用域中
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/docAppointments.jsp").forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
