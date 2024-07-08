package com.hospital.mapper;

import com.hospital.pojo.Departments;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentsMapper {

    @Select("select * from departments where department_pid=#{pid}")
    List<Departments> getDepartList(int pid);
}
