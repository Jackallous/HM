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


@WebServlet("/schedule/getScheduleListByDoc")
public class GetScheduleByDocServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");//用户请求的当前页
        String pid = req.getParameter("pid");//科室id
        String cid = req.getParameter("cid");//二级科室id
        String date = req.getParameter("date");//日期
        String docname = req.getParameter("docname");//日期

        PageInfo pageInfo = scheduleService.getScheduleListByDoc(page,pid,cid,date,docname);
        System.out.println("servlet"+pageInfo);

        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("page",page);
        req.setAttribute("pid",pid);
        req.setAttribute("cid",cid);
        req.setAttribute("date",date);
        req.setAttribute("docname",docname);
        req.getRequestDispatcher("/front/guahaoByDoc.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
