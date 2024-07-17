package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.AppointmentsMapper;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.service.AppointmentService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public boolean addAppointment(String patid, Integer doctorId, String date, String shiftTime) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            AppointmentsMapper appointmentsMapper = sqlSession.getMapper(AppointmentsMapper.class);
            String appnum = appointmentsMapper.getAppMax();
            int appNum = Integer.parseInt(appnum);
//            for(int i = 0;i<Integer.parseInt(num);i++) {
//                doctorsMapper.addDoctor(cid,++jobNum);
//            }
            appointmentsMapper.addApp(++appNum,Integer.valueOf(patid),doctorId,date,shiftTime,"booked");
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
    public boolean cancelAppById(String aid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            AppointmentsMapper appointmentsMapper = sqlSession.getMapper(AppointmentsMapper.class);
            appointmentsMapper.cancelAppById(aid);
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
    public boolean completeApp(String aid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            AppointmentsMapper appointmentsMapper = sqlSession.getMapper(AppointmentsMapper.class);
            appointmentsMapper.completeApp(aid);
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
    public AppointmentsForDoc getAppForDocById(String aid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AppointmentsMapper appointmentsMapper = sqlSession.getMapper(AppointmentsMapper.class);

            AppointmentsForDoc appointmentsForDoc = appointmentsMapper.getAppForDocById(aid);



            return appointmentsForDoc;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public PageInfo getAppByState(String page, String state, String docid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AppointmentsMapper appointmentsMapper = sqlSession.getMapper(AppointmentsMapper.class);
            //分页查询，返回pageinfo
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<AppointmentsForDoc> alist = appointmentsMapper.getAppByState(state,docid);
            //创建分页对象封装集合数据返回
            PageInfo pageInfo = new PageInfo(alist);
            System.out.println("pageinfo"+pageInfo);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }


}
