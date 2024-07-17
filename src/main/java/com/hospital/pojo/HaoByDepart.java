package com.hospital.pojo;

public class HaoByDepart {

    private String departmentName;

//    private String departmentId;

    private String date;

    private Integer sum;

    private String shiftTime;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    public String getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(String departmentId) {
//        this.departmentId = departmentId;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }
}
