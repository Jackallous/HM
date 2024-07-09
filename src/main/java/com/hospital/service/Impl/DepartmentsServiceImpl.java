package com.hospital.service.Impl;


//科室业务层,根据父级科室id返回科室列表

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.DepartmentsMapper;
import com.hospital.pojo.Departments;
import com.hospital.service.DepartmentsService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
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
            //循环遍历科室的集合，添加是否有下级科室的属性值
            for(Departments departments:departmentsList){
                Integer departmentId = departments.getDepartmentId();//当前科室Id
                //根据id查询是否有下一级(个数)
                int count = departmentsMapper.getChildCount(departmentId);
                if(count > 0){//有下一级科室
                    departments.setHaschild(true);
                }else{
                    departments.setHaschild(false);
                }
            }
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

    @Override
    public List<Departments> getChildDepartListPage(String pid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper departmentsMapper=sqlSession.getMapper(DepartmentsMapper.class);

            List<Departments> departmentsList = departmentsMapper.getDepartList(Integer.valueOf(pid));
            return departmentsList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    //添加科室的信息
    @Override
    public boolean addDepartMent(Departments departments) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DepartmentsMapper departmentsMapper=sqlSession.getMapper(DepartmentsMapper.class);
            System.out.println("map");
            departmentsMapper.addDepartMent(departments);
            System.out.println("成功");
            sqlSession.commit();//提交事务
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();//事务回滚
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    //根据主键id查询返回科室对象的方法
    @Override
    public Departments getDepartmentById(String did) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DepartmentsMapper departmentsMapper=sqlSession.getMapper(DepartmentsMapper.class);
            Departments departments = departmentsMapper.getDepartById(did);
            return departments;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean updateDepartMent(Departments departments) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DepartmentsMapper departmentsMapper=sqlSession.getMapper(DepartmentsMapper.class);
            departmentsMapper.updateDepartMent(departments);
            sqlSession.commit();//提交事务
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();//事务回滚
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public boolean deleteByIdDepartMent(String id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DepartmentsMapper departmentsMapper=sqlSession.getMapper(DepartmentsMapper.class);
            departmentsMapper.deleteById(id);
            sqlSession.commit();//提交事务
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();//事务回滚
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }
}
