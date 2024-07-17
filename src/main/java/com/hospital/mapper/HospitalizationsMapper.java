package com.hospital.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface HospitalizationsMapper {
    @Select("select max(hospitalization_id) from hospitalization")
    String getIdMax();

    @Insert("insert into hospitalization values (#{num},#{integer},#{room},#{fee},#{pay},#{integer1},#{hospitalstatus})")
    void createHospitalization(@Param("num")int num, @Param("integer")Integer integer, @Param("room")String room,@Param("fee") String fee, @Param("pay")String pay, @Param("integer1")Integer integer1, @Param("hospitalstatus")String hospitalstatus) throws SQLException;
}
