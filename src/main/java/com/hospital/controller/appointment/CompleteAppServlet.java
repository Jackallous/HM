package com.hospital.controller.appointment;

import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.service.AppointmentService;
import com.hospital.service.Impl.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appointment/completeApp")
public class CompleteAppServlet extends HttpServlet {

    private AppointmentService appointmentService = new AppointmentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //由医生发起的完成就诊功能：1.把该条预约的状态改为completed，2.跳转到填写就诊记录页面，就诊的基本信息回写
        String aid = req.getParameter("aid");//appid
        System.out.println("aid is " + aid);
        //修改预约状态为completed
        boolean flag = appointmentService.completeApp(aid);
        //获取就诊的基本信息
        AppointmentsForDoc appointmentsForDoc = appointmentService.getAppForDocById(aid);
        //设置参数并跳转到填写就诊信息页面
        System.out.println("appfordoc"+appointmentsForDoc);
        req.setAttribute("appointmentsForDoc", appointmentsForDoc);
        //跳转修改页面
        req.getRequestDispatcher("/closeApp.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
