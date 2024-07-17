package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.Patients;

public interface PatientService {
    Patients login(String idcard, String password);

    PageInfo getMyAppointment(String page, String patid);

    boolean addBalance(String patid, String charge);

    Patients getPatientById(String patid);
}
