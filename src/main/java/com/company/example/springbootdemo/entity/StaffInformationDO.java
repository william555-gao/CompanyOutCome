package com.company.example.springbootdemo.entity;

import java.io.Serializable;
import java.util.Date;

public class StaffInformationDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer staffId;
    private String staffProfilePhotoUrl;
    private String staffName;
    private String staffDepartment;
    private String staffSex;
    private Date staffBirthDay;
    private String staffPhone;
    private String staffEmail;
    private String staffIdCard;
    private String staffLocation;
    private String staffDomain;
    private String staffCertifficareUrl;
    private String staffDescription;
    private Integer staffOutcomeId;
    private String staffOutcomeFlag;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffProfilePhotoUrl() {
        return staffProfilePhotoUrl;
    }

    public void setStaffProfilePhotoUrl(String staffProfilePhotoUrl) {
        this.staffProfilePhotoUrl = staffProfilePhotoUrl == null ? null : staffProfilePhotoUrl.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment == null ? null : staffDepartment.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public Date getStaffBirthDay() {
        return staffBirthDay;
    }

    public void setStaffBirthDay(Date staffBirthDay) {
        this.staffBirthDay = staffBirthDay;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail == null ? null : staffEmail.trim();
    }

    public String getStaffIdCard() {
        return staffIdCard;
    }

    public void setStaffIdCard(String staffIdCard) {
        this.staffIdCard = staffIdCard == null ? null : staffIdCard.trim();
    }

    public String getStaffLocation() {
        return staffLocation;
    }

    public void setStaffLocation(String staffLocation) {
        this.staffLocation = staffLocation == null ? null : staffLocation.trim();
    }

    public String getStaffDomain() {
        return staffDomain;
    }

    public void setStaffDomain(String staffDomain) {
        this.staffDomain = staffDomain == null ? null : staffDomain.trim();
    }

    public String getStaffCertifficareUrl() {
        return staffCertifficareUrl;
    }

    public void setStaffCertifficareUrl(String staffCertifficareUrl) {
        this.staffCertifficareUrl = staffCertifficareUrl == null ? null : staffCertifficareUrl.trim();
    }

    public String getStaffDescription() {
        return staffDescription;
    }

    public void setStaffDescription(String staffDescription) {
        this.staffDescription = staffDescription == null ? null : staffDescription.trim();
    }

    public Integer getStaffOutcomeId() {
        return staffOutcomeId;
    }

    public void setStaffOutcomeId(Integer staffOutcomeId) {
        this.staffOutcomeId = staffOutcomeId;
    }

    public String getStaffOutcomeFlag() {
        return staffOutcomeFlag;
    }

    public void setStaffOutcomeFlag(String staffOutcomeFlag) {
        this.staffOutcomeFlag = staffOutcomeFlag == null ? null : staffOutcomeFlag.trim();
    }
}