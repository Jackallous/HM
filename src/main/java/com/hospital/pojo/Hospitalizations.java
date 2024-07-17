package com.hospital.pojo;

public class Hospitalizations {

    private Integer hospitalizationId;

    private Integer patientId;

    private String roomNumber;

    private String cost;

    private String paymentStatus;

    private Integer isInsured;

    private String hospitalizationStatus;

    public Integer getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Integer hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getIsInsured() {
        return isInsured;
    }

    public void setIsInsured(Integer isInsured) {
        this.isInsured = isInsured;
    }

    public String getHospitalizationStatus() {
        return hospitalizationStatus;
    }

    public void setHospitalizationStatus(String hospitalizationStatus) {
        this.hospitalizationStatus = hospitalizationStatus;
    }
}
