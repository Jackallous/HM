package com.hospital.service.Impl;

import com.hospital.mapper.DoctorMapper;
import com.hospital.pojo.Doctors;
import com.hospital.service.DoctorService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public Doctors login(String name, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorMapper doctorMapper = sqlSession.getMapper(DoctorMapper.class);
            return doctorMapper.login(name,password);
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
            DoctorMapper doctorMapper = sqlSession.getMapper(DoctorMapper.class);
            String jobnumber = doctorMapper.getJobNumberMax();
            int jobNum = Integer.parseInt(jobnumber);
            for(int i = 0;i<Integer.parseInt(num);i++) {
                doctorMapper.addDoctor(cid,++jobNum);
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
}
