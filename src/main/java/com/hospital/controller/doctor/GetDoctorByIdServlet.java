package com.hospital.controller.doctor;

import com.hospital.pojo.Doctors;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctor/getDoctorById")
public class GetDoctorByIdServlet extends HttpServlet {

    private DoctorService doctorService =new DoctorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String docid = req.getParameter("docid");
        Doctors doctor = doctorService.getDoctorById(docid);

        req.setAttribute("doctor",doctor);

        req.getRequestDispatcher("/updateDoctor.jsp").forward(req, resp);

    }
}
