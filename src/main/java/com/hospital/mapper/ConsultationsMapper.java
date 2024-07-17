package com.hospital.mapper;

import com.hospital.pojo.ConsultationsForPat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface ConsultationsMapper {

    @Select("select max(consultation_id) from consultation")
    String getIdMax();

    @Insert("insert into consultation values (#{num},#{integer},#{integer3},#{adate},#{integer1},#{integer2},#{advice})")
    void createConsultation(@Param("num")int num, @Param("integer")Integer integer, @Param("integer3")Integer integer3, @Param("adate")String adate, @Param("integer1")Integer integer1,@Param("integer2") Integer integer2, @Param("advice")String advice) throws SQLException;

    List<ConsultationsForPat> getMyConsultation(@Param("patid")String patid) throws SQLException;
}
