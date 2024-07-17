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
@WebServlet("/doctor/updateDoctor")
@MultipartConfig
public class UpdateDoctorServlet extends HttpServlet {

    private DoctorService doctorService = new DoctorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jobNumber = req.getParameter("jobNumber");//工号
        String name = req.getParameter("name");//姓名
        String phone = req.getParameter("phone");//手机
        String email = req.getParameter("email");//邮箱
        String registrationFee = req.getParameter("registrationFee");//挂号费
        String introduction = req.getParameter("introduction");//简介
        String pid = req.getParameter("pid");//职称的id
        String entryDate = req.getParameter("entryDate");//入职时间
        String avatar = req.getParameter("avatar");//
        //
        //封装参数
        // jobNumber,  name,  phone,  email,  registrationFee,  entryDate,  professionalTitleId intro
        Doctors doctors = new Doctors(jobNumber, name, phone, email, registrationFee, entryDate, Integer.parseInt(pid), introduction);
        doctors.setAvatar(avatar);
        //判断表单中是否包含文件上传
        Part part = req.getPart("myfile");
        if(part != null && part.getSize() > 0) {//需要处理文件上传
            //返回文件上传成功后的路径
            String myfile = FileUtil.transferTo(req,"myfile");
            //设置到doctors对象
            doctors.setAvatar(myfile);

        }
//        调用业务层方法完成医生业务的修改功能
        boolean flag = doctorService.updateDoctorByJobNumber(doctors);
        if(flag){
            //替换session中信息，重新查询医生信息，放到session中
            req.removeAttribute("doctors");
            req.getSession().setAttribute("doctors", doctors);
            resp.sendRedirect(req.getContextPath()+"/doctorInfo.jsp");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
