package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.DoctorQuery;
import com.hospital.pojo.Doctors;

public interface DoctorService {

    Doctors login(String name, String password);

    boolean addDoctors(String cid, String num);

    PageInfo getDoctorListPage(DoctorQuery doctorQuery);

    boolean deleteById(String id);
}
