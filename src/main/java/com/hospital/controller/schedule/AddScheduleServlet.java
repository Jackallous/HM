package com.hospital.controller.schedule;

import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DoctorServiceImpl;
import com.hospital.service.Impl.ScheduleServiceImpl;
import com.hospital.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addSchedule")
public class AddScheduleServlet extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();
    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String did = req.getParameter("did");
        String sdate = req.getParameter("sdate");
        //拿到二级科室id和日期，把该科室下所有医生都添加上午下午的排班，具体是否排班由修改功能完成
        //在业务层实现上面的功能
        List<Integer> departDocIdList = doctorService.getDepartDocIdList(Integer.valueOf(did));

        boolean flag =  scheduleService.addSchedule(did,sdate,departDocIdList);

        if(flag){
            resp.sendRedirect(req.getContextPath()+"/schedule/getScheduleList");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
