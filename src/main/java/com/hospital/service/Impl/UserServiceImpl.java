package com.hospital.service.Impl;

import com.hospital.mapper.UserMapper;
import com.hospital.pojo.User;
import com.hospital.service.UserService;
import com.hospital.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUserList() {
        try {
            SqlSession sqlSession =MybatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            System.out.println("userList :" + userList);
            return userMapper.getUserList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public User login(String user_username, String user_password) {
        try {
            SqlSession sqlSession =MybatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.login(user_username,user_password);
//            System.out.println(user_password+user_username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }

        return null;
    }


}
