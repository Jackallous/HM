package com.hospital.pojo;

public class ConsultationsForPat {
    private Integer consultationId;

    private Integer patientId;

    private Integer doctorId;

    private String consultationTime;

    private Integer isHospitalRegistered;

    private Integer isHospitalized;

    private String medicalAdviceCase;

    private Doctors doctor;

    public ConsultationsForPat() {
    }

    public ConsultationsForPat(Integer consultationId, Integer patientId, Integer doctorId, String consultationTime, Integer isHospitalRegistered, Integer isHospitalized, String medicalAdviceCase, Doctors doctor) {
        this.consultationId = consultationId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.consultationTime = consultationTime;
        this.isHospitalRegistered = isHospitalRegistered;
        this.isHospitalized = isHospitalized;
        this.medicalAdviceCase = medicalAdviceCase;
        this.doctor = doctor;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    public Integer getIsHospitalRegistered() {
        return isHospitalRegistered;
    }

    public void setIsHospitalRegistered(Integer isHospitalRegistered) {
        this.isHospitalRegistered = isHospitalRegistered;
    }

    public Integer getIsHospitalized() {
        return isHospitalized;
    }

    public void setIsHospitalized(Integer isHospitalized) {
        this.isHospitalized = isHospitalized;
    }

    public String getMedicalAdviceCase() {
        return medicalAdviceCase;
    }

    public void setMedicalAdviceCase(String medicalAdviceCase) {
        this.medicalAdviceCase = medicalAdviceCase;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }
}
