package com.hospital.controller.schedule;

import com.hospital.pojo.Doctors;
import com.hospital.pojo.Schedules;
import com.hospital.service.Impl.ScheduleServiceImpl;
import com.hospital.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/getScheduleById")
public class GetScheduleByIdServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("sid");
        Schedules schedule = scheduleService.getScheduleById(sid);

        req.setAttribute("schedule",schedule);

        req.getRequestDispatcher("/updateSchedule.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
