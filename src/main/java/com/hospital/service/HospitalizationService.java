package com.hospital.service;

public interface HospitalizationService {

    boolean createHospitalization(String patid, String room, String fee, String pay, String insure, String hospitalstatus);

}
