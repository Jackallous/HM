package com.hospital.controller.appointment;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.service.AppointmentService;
import com.hospital.service.Impl.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/appointment/getAppByState")
public class GetAppByStateServlet extends HttpServlet {

    private AppointmentService appointmentService = new AppointmentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String state = req.getParameter("state");
        String page = req.getParameter("page");
        String docid = req.getParameter("docid");
        System.out.println("statepagedocid"+state+page+docid);
        //调用业务层查询方法
        PageInfo pageInfo = appointmentService.getAppByState(page,state,docid);
        //把分页对象设置到request作用域中
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("state",state);
        req.getRequestDispatcher("/docAppointments.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
