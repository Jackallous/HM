package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.pojo.DoctorQuery;
import com.hospital.pojo.Doctors;
import com.hospital.service.DoctorService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public Doctors login(String name, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            return doctorsMapper.login(name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean addDoctors(String cid, String num) {
        //cid:科室的id，job_number自动生成，password 1234
        //1查询job_number在数据库中最大值
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            String jobnumber = doctorsMapper.getJobNumberMax();
            int jobNum = Integer.parseInt(jobnumber);
            for(int i = 0;i<Integer.parseInt(num);i++) {
                doctorsMapper.addDoctor(cid,++jobNum);
            }
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }

    @Override
    public PageInfo getDoctorListPage(DoctorQuery doctorQuery) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            //分页查询，返回pageinfo
            String page =doctorQuery.getPage();
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<Doctors> dlist = doctorsMapper.getDoctorList(doctorQuery);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(dlist);
            System.out.println("pageinfo"+pageInfo);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            doctorsMapper.deleteById(id);
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }
}
