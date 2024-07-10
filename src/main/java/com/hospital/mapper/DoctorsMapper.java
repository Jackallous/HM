package com.hospital.mapper;

import com.hospital.pojo.DoctorQuery;
import com.hospital.pojo.Doctors;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    void deleteById(String id) throws SQLException;
}
