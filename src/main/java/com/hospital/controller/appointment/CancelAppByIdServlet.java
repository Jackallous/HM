package com.hospital.controller.appointment;

import com.hospital.service.AppointmentService;
import com.hospital.service.Impl.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appointment/cancelAppById")
public class CancelAppByIdServlet extends HttpServlet {

    private AppointmentService appointmentService = new AppointmentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String aid = req.getParameter("aid");
//        String patid = req.getParameter("patid");
        //根据aid将预约状态设为cancelled
        boolean flag = appointmentService.cancelAppById(aid);

        if (flag) {
            resp.sendRedirect(req.getContextPath()+"/front/myApp.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
