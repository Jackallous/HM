package com.hospital.service;

import com.hospital.pojo.Doctors;

public interface DoctorService {

    Doctors login(String name, String password);

    boolean addDoctors(String cid, String num);
}
