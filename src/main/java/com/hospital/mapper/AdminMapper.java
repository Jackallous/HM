package com.hospital.mapper;

import com.hospital.pojo.Admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface AdminMapper {

    @Select("select * from admins where username=#{name} and password=#{pwd}")
    Admins login(@Param("name")String name, @Param("pwd")String password) throws SQLException;
}
