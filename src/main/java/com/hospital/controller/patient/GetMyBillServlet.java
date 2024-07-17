package com.hospital.controller.patient;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.DoctorQuery;
import com.hospital.service.BillService;
import com.hospital.service.Impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/patient/getMyBill")
public class GetMyBillServlet extends HttpServlet {

    private BillService billService = new BillServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");
        String patid = req.getParameter("patid");

        //调用业务层查询方法
        PageInfo pageInfo = billService.getMyBill(page,patid);
        //把分页对象设置到request作用域中
        req.setAttribute("pageInfo",pageInfo);

        req.getRequestDispatcher("/myBill.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
