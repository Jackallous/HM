package com.hospital.controller.patient;

import com.github.pagehelper.PageInfo;
import com.hospital.service.ConsultationService;
import com.hospital.service.Impl.ConsultationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/getMyConsultation")
public class GetMyConsultationServlet extends HttpServlet {

    private ConsultationService consultationService = new ConsultationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据patid得到这个病人的预约
        String patid = req.getParameter("patid");
        String page = req.getParameter("page");//当前页
        //调用业务层查询方法
        PageInfo pageInfo = consultationService.getMyConsultation(page,patid);
        //把分页对象设置到request作用域中
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/front/myCon.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
