package com.hospital.mapper;

import com.hospital.pojo.Patients;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

public interface PatientsMapper {

    @Select("select * from patients where id_card_number=#{idcard} and password=#{password}")
    Patients login(@Param("idcard")String idcard, @Param("password")String password) throws SQLException;

    @Update("update patients set balance=balance+#{i1} where patient_id=#{patid}")
    void addBalance(@Param("patid")String patid, @Param("i1")int i1) throws SQLException;

    @Select("select * from patients where patient_id=#{patid}")
    Patients getPatientById(@Param("patid")String patid) throws SQLException;

    @Select("select balance from patients where patient_id=#{patid}")
    Integer getBalanceById(@Param("patid")String patid) throws SQLException;

    @Update("update patients set balance=#{i} where patient_id=#{patid}")
    void setBalance(@Param("patid")String patid,@Param("i")int i) throws SQLException;
}
