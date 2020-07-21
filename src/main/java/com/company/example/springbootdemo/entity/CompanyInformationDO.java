package com.company.example.springbootdemo.entity;

import java.io.Serializable;

public class CompanyInformationDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer companyId;
    private String companyName;
    private Integer companyCreditCode;
    private String companyLegalPerson;
    private String companyPhoneNum;
    private String companyImageUrl;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getCompanyCreditCode() {
        return companyCreditCode;
    }

    public void setCompanyCreditCode(Integer companyCreditCode) {
        this.companyCreditCode = companyCreditCode;
    }

    public String getCompanyLegalPerson() {
        return companyLegalPerson;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson == null ? null : companyLegalPerson.trim();
    }

    public String getCompanyPhoneNum() {
        return companyPhoneNum;
    }

    public void setCompanyPhoneNum(String companyPhoneNum) {
        this.companyPhoneNum = companyPhoneNum == null ? null : companyPhoneNum.trim();
    }

    public String getCompanyImageUrl() {
        return companyImageUrl;
    }

    public void setCompanyImageUrl(String companyImageUrl) {
        this.companyImageUrl = companyImageUrl == null ? null : companyImageUrl.trim();
    }
}