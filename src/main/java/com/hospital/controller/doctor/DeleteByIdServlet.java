package com.hospital.controller.doctor;


import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//删除doctor根据id
@WebServlet("/doctor/deleteById")
public class DeleteByIdServlet extends HttpServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");//doc id


        boolean flag = doctorService.deleteById(id);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/doctor/getDoctorList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
