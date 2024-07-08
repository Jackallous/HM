package com.hospital.service;

import com.github.pagehelper.PageInfo;

public interface DepartmentsService {

    PageInfo getDepartListPage(String page,int pid);
}
