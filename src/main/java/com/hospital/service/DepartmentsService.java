package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.Departments;

import java.util.List;

public interface DepartmentsService {

    PageInfo getDepartListPage(String page,int pid);

    List<Departments> getChildDepartListPage(String pid);

    boolean addDepartMent(Departments departments);

    Departments getDepartmentById(String did);

    boolean updateDepartMent(Departments departments);

    boolean deleteByIdDepartMent(String id);
}
