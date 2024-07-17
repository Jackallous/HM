package com.hospital.pojo;

public class Doctors {

    private Integer doctorId;

    private String jobNumber;

    private String password;

    private String name;

    private String avatar;

    private String phone;

    private String email;

    private String introduction;

    private String registrationFee;

    private String entryDate;

    private Integer departmentId;

    private Integer professionalTitleId;

    private Departments departments;//部门对象

    private ProfessionalTitles professionalTitles;//职称对象

    private Integer state;//表示状态 0正常  1删除


    public Doctors() {
    }

    public Doctors(String jobNumber, String name, String phone, String email, String registrationFee, String entryDate, Integer professionalTitleId, String introduction) {
        this.jobNumber = jobNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.registrationFee = registrationFee;
        this.entryDate = entryDate;
        this.professionalTitleId = professionalTitleId;
        this.introduction = introduction;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public ProfessionalTitles getProfessionalTitles() {
        return professionalTitles;
    }

    public void setProfessionalTitles(ProfessionalTitles professionalTitles) {
        this.professionalTitles = professionalTitles;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(String registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getProfessionalTitleId() {
        return professionalTitleId;
    }

    public void setProfessionalTitleId(Integer professionalTitleId) {
        this.professionalTitleId = professionalTitleId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", jobNumber='" + jobNumber + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                ", registrationFee='" + registrationFee + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", departmentId=" + departmentId +
                ", professionalTitleId=" + professionalTitleId +
                '}';
    }
}
