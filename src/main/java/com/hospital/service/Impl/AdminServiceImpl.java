package com.hospital.service.Impl;

import com.hospital.mapper.AdminMapper;
import com.hospital.mapper.DoctorMapper;
import com.hospital.pojo.Admins;
import com.hospital.service.AdminService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    @Override
    public Admins login(String name, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
            return adminMapper.login(name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }
}
