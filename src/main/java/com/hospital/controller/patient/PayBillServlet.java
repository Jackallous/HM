package com.hospital.controller.patient;

import com.hospital.pojo.Patients;
import com.hospital.service.BillService;
import com.hospital.service.Impl.BillServiceImpl;
import com.hospital.service.Impl.PatientServiceImpl;
import com.hospital.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/payBill")
public class PayBillServlet extends HttpServlet {

    private BillService billService = new BillServiceImpl();
    private PatientService patientService = new PatientServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //支付账单对应的金额：1如果金额不够则返回提示余额不足，跳转余额充值界面
        //2.如果金额足够，则减去账单面值，并把该账单状态设置为已支付

        String billid = req.getParameter("billid");
        String patid = req.getParameter("patid");
        //首先得到账户余额
        Integer balance = patientService.getBalanceById(patid);
        //然后得到账单金额
        Integer price = billService.getPriceById(billid);
        if(price>balance){//余额不足

            //如何返回时弹出一个余额不足的提示框
            resp.sendRedirect(req.getContextPath()+"/front/addBalance.jsp");

        }else{//余额足够，进行支付

            //首先把账单改为已支付
            boolean f = billService.payBill(billid);
            //然后把用户余额减去price
            System.out.println("new balance"+(balance-price));
            boolean f2 = patientService.setBalance(patid,balance-price);
            //返回
            if(f && f2){
                Patients patients = patientService.getPatientById(patid);
                req.getSession().setAttribute("patients",patients);
                resp.sendRedirect(req.getContextPath()+"/front/myBill.jsp");
            }




        }


//        String billid = req.getParameter("billid");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
