package com.hospital.controller.doctor;


import com.hospital.pojo.Doctors;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DoctorServiceImpl;
import com.hospital.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


//医生个人信息的修改
@WebServlet("/doctor/updateDoctorTitle")
public class UpdateDoctorTitleServlet extends HttpServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String docid = req.getParameter("docid");
        String docfee = req.getParameter("docfee");//可能为空
        String doctitleid = req.getParameter("doctitleid");//不可能为空
        //
        //封装参数

//        调用业务层方法完成医生业务的修改功能
        boolean flag = doctorService.updateDoctorTitle(docid,docfee,doctitleid);
        if(flag){
            resp.sendRedirect(req.getContextPath()+"/doctor/getDoctorList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
