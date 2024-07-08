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
}
