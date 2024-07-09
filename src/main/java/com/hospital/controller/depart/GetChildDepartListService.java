package com.hospital.controller.depart;


import com.alibaba.fastjson.JSON;
import com.hospital.pojo.Departments;
import com.hospital.service.DepartmentsService;
import com.hospital.service.Impl.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//根据pid返回所有子级科室列表，使用异步，需要把数据提交给客户端
@WebServlet("/depart/getChildDepartList")
public class GetChildDepartListService extends HttpServlet {
    private DepartmentsService departmentsService = new DepartmentsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("pid");
        List<Departments>  dlist = departmentsService.getChildDepartListPage(pid);
        //先获取输出对象
        PrintWriter out = resp.getWriter();
        out.print(JSON.toJSON(dlist));//把dlist转换成json格式
        out.flush();
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
