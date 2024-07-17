package com.hospital.controller.doctor;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.hospital.pojo.Doctors;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/doctor/getDocListByCid")
public class GetDocListByCidServlet extends HttpServlet {

    private DoctorService doctorService =new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cid = req.getParameter("cid");//科室id
        String page = req.getParameter("page");//当前页

        System.out.println("cid:  "+cid);
        List<Doctors> doctorsList= doctorService.getDocListByCid(page,cid);
        //把分页对象设置到request作用域中
        //先获取输出对象
        System.out.println("doctorList"+doctorsList);
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSON(doctorsList));//把dlist转换成json格式
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
