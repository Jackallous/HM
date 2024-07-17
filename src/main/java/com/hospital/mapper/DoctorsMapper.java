package com.hospital.mapper;

import com.hospital.pojo.AppointmentsForDoc;
import com.hospital.pojo.DoctorQuery;
import com.hospital.pojo.Doctors;
import org.apache.ibatis.annotations.*;

import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.List;

public interface DoctorsMapper {

    @Select("select * from doctors where job_number=#{job} and password=#{pwd}")
    Doctors login(@Param("job")String name, @Param("pwd")String password) throws SQLException;

    @Select("select max(job_number) from doctors")
    String getJobNumberMax() throws SQLException;

    @Insert("insert into doctors(job_number,password,department_id) values (#{jobNum},'123456',#{did})")
    void addDoctor(@Param("did")String did, @Param("jobNum")int jobNum) throws SQLException;

    List<Doctors> getDoctorList(DoctorQuery doctorQuery) throws SQLException;

    //标记删除
    @Update("update doctors set state=1 where doctor_id=#{id}")
    void deleteById(@Param("id")String id) throws SQLException;

    @Update("update doctors set name=#{name},avatar=#{avatar},phone=#{phone},email=#{email},introduction=#{introduction},registration_fee=#{registrationFee},professional_title_id=#{professionalTitleId} where job_number=#{jobNumber}")
    void updateDoctorByJobNumber(Doctors doctors) throws SQLException;


    Doctors getDoctorById(Integer docid) throws SQLException;

    @Update("update doctors set registration_fee=#{docfee},professional_title_id=#{doctitleid} where doctor_id=#{docid}")
    void updateDoctorTitle(@Param("docid")String docid, @Param("docfee")String docfee, @Param("doctitleid")int doctitleid) throws SQLException;

    @Select("select doctor_id from doctors where department_id=#{did} and state = 0")
    List<Integer> getDepartDocIdList(Integer did) throws SQLException;

    @Select("select registration_fee from doctors where doctor_id=#{docid}")
    Integer getFeeById(Integer docid) throws SQLException;
}
