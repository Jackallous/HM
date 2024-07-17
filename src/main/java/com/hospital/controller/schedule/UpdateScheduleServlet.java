package com.hospital.controller.schedule;

import com.hospital.service.Impl.ScheduleServiceImpl;
import com.hospital.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/updateSchedule")
public class UpdateScheduleServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid = req.getParameter("sid");
        String nums = req.getParameter("nums");//可能为空
        String workstate = req.getParameter("workstate");//不可能为空
        //
        //封装参数

//        调用业务层方法完成医生业务的修改功能
        boolean flag = scheduleService.updateSchedule(sid,nums,workstate);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/schedule/getScheduleList");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
