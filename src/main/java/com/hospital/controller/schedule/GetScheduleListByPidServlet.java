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

@WebServlet("/schedule/getScheduleListByPid")
public class GetScheduleListByPidServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        resp.sendRedirect(req.getContextPath()+"/login.jsp");
        String page = req.getParameter("page");//用户请求的当前页
        String pid = req.getParameter("pid");//科室id
        String cid = req.getParameter("cid");//二级科室id
        String date = req.getParameter("date");//日期
        System.out.println("guahaoguahao");
        //拿到的是Hao类型，只有科室名字
        PageInfo pageInfo = scheduleService.getScheduleListById(page,pid,cid,date);
        System.out.println("servlet"+pageInfo);

        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("page",page);
        req.setAttribute("pid",pid);
        req.setAttribute("cid",cid);
        req.setAttribute("date",date);
        req.getRequestDispatcher("/front/guahao.jsp").forward(req,resp);
//        resp.sendRedirect(req.getContextPath()+"/login.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
