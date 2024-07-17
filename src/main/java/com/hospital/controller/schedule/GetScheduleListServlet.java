package com.hospital.controller.schedule;

import com.github.pagehelper.PageInfo;
import com.hospital.service.Impl.ScheduleServiceImpl;
import com.hospital.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/getScheduleList")
public class GetScheduleListServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");//用户请求的当前页
        String did = req.getParameter("did");//科室id
        String date = req.getParameter("date");//日期

        PageInfo pageInfo = scheduleService.getScheduleList(page,did,date);
        System.out.println("servlet"+pageInfo);

        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("page",page);
        req.setAttribute("did",did);
        req.setAttribute("date",date);
        req.getRequestDispatcher("/appointment.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
