package com.hospital.controller.patient;

import com.hospital.pojo.Admins;
import com.hospital.pojo.Doctors;
import com.hospital.pojo.Patients;
import com.hospital.service.Impl.PatientServiceImpl;
import com.hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/login")
public class LoginServlet extends HttpServlet {

    private PatientService patientService= new PatientServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从请求中获取参数
        String idcard = req.getParameter("idcard");
        String password = req.getParameter("password");

            Patients patients = patientService.login(idcard,password);
            if(patients!=null){
                req.getSession().setAttribute("patients",patients);
                //重定向到管理员页面
                resp.sendRedirect(req.getContextPath()+"/front/patientIndex.jsp");

            }else{
                //重定向到登录页面
                resp.sendRedirect(req.getContextPath()+"/front/login.jsp?flag=f");
            }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
