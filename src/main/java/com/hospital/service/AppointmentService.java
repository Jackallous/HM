package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.AppointmentsForDoc;

import java.util.List;

public interface AppointmentService {
    boolean addAppointment(String patid, Integer doctorId, String date, String shiftTime);

    boolean cancelAppById(String aid);

    boolean completeApp(String aid);

    AppointmentsForDoc getAppForDocById(String aid);

    PageInfo getAppByState(String page,String state,String docid);
}
