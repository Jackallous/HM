package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.DoctorQuery;
import com.hospital.pojo.Doctors;

import java.util.List;

public interface DoctorService {

    Doctors login(String name, String password);

    boolean addDoctors(String cid, String num);

    PageInfo getDoctorListPage(DoctorQuery doctorQuery);

    boolean deleteById(String id);

    boolean updateDoctorByJobNumber(Doctors doctors);

    Doctors getDoctorById(String docid);

    boolean updateDoctorTitle(String docid, String docfee, String doctitleid);

    List<Integer> getDepartDocIdList(Integer integer);

    PageInfo getAppointmentList(String page, String docid);

    Integer getFeeById(Integer docid);
}
