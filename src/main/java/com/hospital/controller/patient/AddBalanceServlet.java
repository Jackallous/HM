package com.hospital.controller.patient;

import com.hospital.pojo.Patients;
import com.hospital.service.Impl.PatientServiceImpl;
import com.hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/addBalance")
public class AddBalanceServlet extends HttpServlet {

    private PatientService patientService = new PatientServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String balance = req.getParameter("balance");
        String patid = req.getParameter("patid");
        String charge = req.getParameter("charge");

        boolean flag = patientService.addBalance(patid,charge);
        Patients patients = patientService.getPatientById(patid);
        if(flag){
            req.getSession().setAttribute("patients",patients);
            resp.sendRedirect(req.getContextPath()+"/front/patientIndex.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
