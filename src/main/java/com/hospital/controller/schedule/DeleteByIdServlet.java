package com.hospital.controller.schedule;

import com.hospital.service.Impl.ScheduleServiceImpl;
import com.hospital.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/deleteById")
public class DeleteByIdServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("sid");

        boolean flag = scheduleService.deleteById(sid);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/schedule/getScheduleList");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
