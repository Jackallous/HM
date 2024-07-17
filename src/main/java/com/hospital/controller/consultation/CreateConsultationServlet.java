package com.hospital.controller.consultation;

import com.hospital.pojo.Consultations;
import com.hospital.pojo.Hospitalizations;
import com.hospital.service.BillService;
import com.hospital.service.ConsultationService;
import com.hospital.service.DoctorService;
import com.hospital.service.HospitalizationService;
import com.hospital.service.Impl.BillServiceImpl;
import com.hospital.service.Impl.ConsultationServiceImpl;
import com.hospital.service.Impl.DoctorServiceImpl;
import com.hospital.service.Impl.HospitalizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/consultation/createConsultation")
public class CreateConsultationServlet extends HttpServlet {

    private ConsultationService consultationService = new ConsultationServiceImpl();
    private HospitalizationService hospitalizationService = new HospitalizationServiceImpl();
    private BillService billService = new BillServiceImpl();
    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //完成consultation和（hospitalization）的创建
        String aid = req.getParameter("aid");
        String pname = req.getParameter("pname");
        String adate = req.getParameter("adate");
        String atime = req.getParameter("atime");
        String patid = req.getParameter("patid");
        String docid = req.getParameter("docid");
        String advice = req.getParameter("advice");
        String hosregis = req.getParameter("hosregis");
        String hosif = req.getParameter("hosif");
        String room = req.getParameter("room");
        String fee = req.getParameter("fee");
        String pay = req.getParameter("pay");
        String insure = req.getParameter("insure");
        String hospitalstatus = req.getParameter("hospitalstatus");
        System.out.println("hosregis   "+hosregis+"   hosif    "+hosif);
        //首先创建consultation对象
        boolean flag = consultationService.createConsultation(patid,docid,adate,hosregis,hosif,advice);
        //然后根据hosregis判断是否创建住院对象
        System.out.println("hosregis"+hosregis);
        if (hosregis.equals("1")) {//登记住院
            System.out.println("创建hos对象");
            boolean flag2 = hospitalizationService.createHospitalization(patid,room,fee,pay,insure,hospitalstatus);
            //为住院创建账单
//            Integer price = doctorService.getFeeById(Integer.valueOf(docid));
            boolean f = billService.createBill(patid,Integer.valueOf(docid),adate,Integer.valueOf(fee),"hospitalization");


            System.out.println("createSuccess");
        }else{

        }
//        req.getRequestDispatcher("/doctorIndex.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/docAppointments.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
