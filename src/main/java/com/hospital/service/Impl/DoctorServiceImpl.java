package com.hospital.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hospital.mapper.AppointmentsMapper;
import com.hospital.mapper.DoctorsMapper;
import com.hospital.pojo.Appointments;
import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.pojo.DoctorQuery;
import com.hospital.pojo.Doctors;
import com.hospital.service.DoctorService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collections;
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

    @Override
    public boolean updateDoctorByJobNumber(Doctors doctors) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            doctorsMapper.updateDoctorByJobNumber(doctors);
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
    public Doctors getDoctorById(String docid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            Doctors doctor = doctorsMapper.getDoctorById(Integer.valueOf(docid));
            return doctor;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean updateDoctorTitle(String docid, String docfee, String doctitleid) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            if(docfee != null && !"".equals(docfee)){
                doctorsMapper.updateDoctorTitle(docid,docfee,Integer.parseInt(doctitleid));
            }else{
                doctorsMapper.updateDoctorTitle(docid,"0",Integer.parseInt(doctitleid));
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
    public List<Integer> getDepartDocIdList(Integer did) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            List<Integer> departDocIdList = doctorsMapper.getDepartDocIdList(did);
            return departDocIdList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public PageInfo getAppointmentList(String page, String docid) {
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
            List<AppointmentsForDoc> alist = appointmentsMapper.getAppointmentList(Integer.parseInt(docid));
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
    public Integer getFeeById(Integer docid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            Integer fee = doctorsMapper.getFeeById(Integer.valueOf(docid));
            return fee;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public List<Doctors> getDocListByCid(String page, String cid) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            List<Doctors> dlist = doctorsMapper.getDocListByCid(cid);
            System.out.println("impl  cid:"+dlist+cid);
            //创建分页对象封装集合数据返回
            return dlist;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }


}
