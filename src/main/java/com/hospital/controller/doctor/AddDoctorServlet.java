package com.hospital.controller.doctor;


import com.hospital.pojo.Departments;
import com.hospital.service.DepartmentsService;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DepartmentsServiceImpl;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//完成科室的添加
@WebServlet("/doctor/addDoctor")
public class AddDoctorServlet extends HttpServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cid = req.getParameter("cid");//科室id
        String num = req.getParameter("num");//生成账号的数量

        boolean flag = doctorService.addDoctors(cid,num);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/doctor/getDoctorList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
