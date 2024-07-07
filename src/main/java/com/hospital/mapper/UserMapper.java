package com.hospital.mapper;

import com.hospital.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper {


    public List<User> getUserList() throws SQLException;


    User login(@Param("user_username")String user_username, @Param("user_password")String user_password) throws SQLException;
}
