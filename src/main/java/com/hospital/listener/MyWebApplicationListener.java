package com.hospital.listener;


import com.hospital.pojo.Departments;
import com.hospital.pojo.ProfessionalTitles;
import com.hospital.service.DepartmentsService;
import com.hospital.service.Impl.DepartmentsServiceImpl;
import com.hospital.service.Impl.ProfessionalServiceImpl;
import com.hospital.service.ProfessionalService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

//创建自定义监听器，监听application作用域对象的创建
@WebListener
public class MyWebApplicationListener implements ServletContextListener {

    //船舰科室的业务层对象和职称的业务层对象
    private DepartmentsService departmentsService = new DepartmentsServiceImpl();
    private ProfessionalService professionalService = new ProfessionalServiceImpl();

    //对象创建时候被调用
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application context initialized"+sce);
        //查询所有职称数据
        List<ProfessionalTitles> professionalTitlesList = professionalService.getProfessionalTitlesList();
        //查询所有科室,只返回二级科室
        List<Departments> dListLevelf = departmentsService.getDepartListLevel(1);
        List<Departments> dListLevelt = departmentsService.getDepartListLevel(2);
//        System.out.println(dListLevelt);
//        System.out.println(dListLevelf);
        //把查询的所有数据设置到appli作用域中
        ServletContext application = sce.getServletContext();
        application.setAttribute("ptlist",professionalTitlesList);
        application.setAttribute("dListLevelf",dListLevelf);
        application.setAttribute("dListLevelt",dListLevelt);

    }

}
