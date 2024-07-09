package com.hospital.mapper;

import com.hospital.pojo.Departments;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentsMapper {

    @Select("select * from departments where department_pid=#{pid}")
    List<Departments> getDepartList(int pid) throws SQLException;


    @Insert("insert into departments(department_name,department_pid,department_level,department_description) values (#{departmentName},#{departmentPid},#{departmentLevel},#{departmentDescription})")
    void addDepartMent(Departments departments) throws SQLException;


    @Select("select * from departments where department_id=#{did}")
    Departments getDepartById(@Param("did")String did) throws SQLException;

    @Update("update departments set department_name=#{departmentName},department_description=#{departmentDescription} where department_id=#{departmentId}")
    void updateDepartMent(Departments departments) throws SQLException;


    @Delete("delete from departments where department_id=#{did}")
    void deleteById(@Param("did")String id) throws SQLException;

    @Select("select count(*) from departments where department_pid=#{departmentId}")
    int getChildCount(Integer departmentId);
}
