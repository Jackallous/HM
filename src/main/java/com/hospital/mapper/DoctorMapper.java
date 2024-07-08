package com.hospital.mapper;

import com.hospital.pojo.Doctors;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface DoctorMapper {

    @Select("select * from doctors where job_number=#{job} and password=#{pwd}")
    Doctors login(@Param("job")String name, @Param("pwd")String password) throws SQLException;

}
