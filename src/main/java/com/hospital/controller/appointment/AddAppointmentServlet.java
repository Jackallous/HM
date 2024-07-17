package com.hospital.controller.appointment;

import com.hospital.pojo.Departments;
import com.hospital.pojo.Schedules;
import com.hospital.service.*;
import com.hospital.service.Impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/appointment/addAppointment")
public class AddAppointmentServlet extends HttpServlet {

    private AppointmentService appointmentService = new AppointmentServiceImpl();
    private ScheduleService scheduleService = new ScheduleServiceImpl();
    private DepartmentsService departmentsService = new DepartmentsServiceImpl();
    private BillService billService = new BillServiceImpl();
    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //进行挂号操作，拿到patientid 和 scheduleid ，创建一个新的appointment
        String patid = req.getParameter("patid");//病人id
        String dname = req.getParameter("dname");//科室名字
        String date = req.getParameter("date");//
        String time = req.getParameter("time");//
        //根据科室名字获取科室id
        Departments department = departmentsService.getDepartmentByName(dname);
        //根据科室id，在该科室下找到号最多的schedule，把visitcount--，并返回该schedule信息
        Schedules schedules = scheduleService.getMostHaoByDid(department.getDepartmentId(),date,time);
        //为该挂号增加一个帐单 1得到挂号费
        Integer docid = schedules.getDoctorId();
        Integer price = doctorService.getFeeById(docid);
        //现在准备构造用参数patient_id,bill_date,bill_price,bill_state,doctor_id,bill_type
        String billdate = schedules.getDate();
        boolean f = billService.createBill(patid,docid,billdate,price,"appointment");
        

        //把该排班号数减1，如果已经为0，则返回false
        boolean deduct = scheduleService.deductCount(schedules);
        System.out.println(schedules.getDoctorId()+schedules.getDate()+schedules.getShiftTime());
        if (deduct){//成功减一

            //构造appointment
            boolean flag =  appointmentService.addAppointment(patid,schedules.getDoctorId(),schedules.getDate(),schedules.getShiftTime());
            if(flag){
                resp.sendRedirect(req.getContextPath()+"/front/guahao.jsp");
            }


        }else{//号不够了

            resp.sendRedirect(req.getContextPath() + "/front/guahao.jsp?f=false");
        }



        //取出schedule中的doctorId，Date,Time数据
//        Integer doctorId = scheduleById.getDoctorId();
//        String date = scheduleById.getDate();
//        String shiftTime = scheduleById.getShiftTime();
        //调用方法构造appointment
//        boolean flag1 =  appointmentService.addAppointment(patid,doctorId,date,shiftTime);
        //创建的预约可以在我的预约查看
        //该排班的visitcount减1，排班的选择从该科室下号最多的schedule中减去visitcount
        //首先获取科室id
//        Schedules sche = scheduleService.getScheduleById(sid);
//        int did = sche.getDoctorId();
//        //根据科室id查询所有下面的排班，选择号最多的减1
//        boolean flag2 = scheduleService.decreaseHaoByDid(did);
//        if(flag1 && flag2){
//            resp.sendRedirect(req.getContextPath()+"/front/guahao.jsp");
//        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
