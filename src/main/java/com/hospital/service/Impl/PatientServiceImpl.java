package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.AdminMapper;
import com.hospital.mapper.AppointmentsMapper;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.mapper.PatientsMapper;
import com.hospital.pojo.Appointments;
import com.hospital.pojo.Doctors;
import com.hospital.pojo.Patients;
import com.hospital.service.PatientService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Override
    public Patients login(String idcard, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            PatientsMapper patientsMapper = sqlSession.getMapper(PatientsMapper.class);
            return patientsMapper.login(idcard,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public PageInfo getMyAppointment(String page, String patid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AppointmentsMapper appointmentsMapper = sqlSession.getMapper(AppointmentsMapper.class);
            //分页查询，返回pageinfo
            int pid = 1;
            if(patid != null && !patid.equals("")){
                pid = Integer.parseInt(patid);
            }else{
                pid = 1;
            }
            if(page != null && !"".equals(page)){
                PageHelper.startPage(Integer.valueOf(page),5);
            }else{
                PageHelper.startPage(1,5);//没有当前页，默认返回第一页的数据
            }
            //紧跟第一个查询会被自动分页
            List<Appointments> alist = appointmentsMapper.getMyAppointment(pid);
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

    @Override
    public boolean addBalance(String patid, String charge) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            PatientsMapper patientsMapper = sqlSession.getMapper(PatientsMapper.class);
            if(charge != null && !"".equals(charge)){
                patientsMapper.addBalance(patid,Integer.parseInt(charge));
            }else{
                patientsMapper.addBalance(patid,0);
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
    public Patients getPatientById(String patid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            PatientsMapper patientsMapper = sqlSession.getMapper(PatientsMapper.class);
            return patientsMapper.getPatientById(patid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public Integer getBalanceById(String patid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            PatientsMapper patientsMapper = sqlSession.getMapper(PatientsMapper.class);
            Integer balance = patientsMapper.getBalanceById(patid);
            return balance;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean setBalance(String patid, int i) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            PatientsMapper patientsMapper = sqlSession.getMapper(PatientsMapper.class);
            patientsMapper.setBalance(patid,i);
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
