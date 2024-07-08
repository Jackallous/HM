package com.hospital.service.Impl;


//科室业务层,根据父级科室id返回科室列表

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.DepartmentsMapper;
import com.hospital.pojo.Departments;
import com.hospital.service.DepartmentsService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepartmentsServiceImpl implements DepartmentsService {

    @Override
    public PageInfo getDepartListPage(String page ,int pid) {


        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper departmentsMapper=sqlSession.getMapper(DepartmentsMapper.class);
            //使用分页插件进行分页查询
            //pageNum是用户请求的当前页 PageSize是每页显示的记录数    page：用户请求的当前页
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //！！紧跟开始分页代码后面的第一个查询默认会自动分页！！
            List<Departments> departmentsList = departmentsMapper.getDepartList(pid);
            //创建分页对象，设置集合到分页对象中
            PageInfo<Departments> pageinfo = new PageInfo<>(departmentsList);
            return pageinfo;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }
}
