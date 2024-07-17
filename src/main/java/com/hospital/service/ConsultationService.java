package com.hospital.service;

import com.github.pagehelper.PageInfo;
import com.hospital.pojo.Consultations;

public interface ConsultationService {
    boolean createConsultation(String patid, String docid, String adate, String hosregis, String hosif, String advice);

    PageInfo getMyConsultation(String page, String patid);
}
