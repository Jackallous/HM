package com.hospital.controller.depart;


//查询所有一级科室信息列表,分页展示

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.Admins;
import com.hospital.pojo.Doctors;
import com.hospital.service.AdminService;
import com.hospital.service.DepartmentsService;
import com.hospital.service.DoctorService;
import com.hospital.service.Impl.AdminServiceImpl;
import com.hospital.service.Impl.DepartmentsServiceImpl;
import com.hospital.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/depart/getDepartList")
public class GetDepartListServlet extends HttpServlet {

    private DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //分页：limit 0,3 第一页  limit 3,3从第三条查返回三条 第二页
        //获取请求中用户请求的当前页 page
        String page = req.getParameter("page");//用户请求的当前页
        //业务层返回PageInfo的对象，这个对象包含页面需要的分页信息和集合列表
        PageInfo pageInfo = departmentsService.getDepartListPage(page,0);//查询pid为0的一级科室列表
        //跳转到jsp页面展示数据 把需要展示的数据设置到request作用域中
        req.setAttribute("pageInfo", pageInfo);
        //使用转发的跳转方式
        req.getRequestDispatcher("/departList.jsp").forward(req, resp);

    }
}
