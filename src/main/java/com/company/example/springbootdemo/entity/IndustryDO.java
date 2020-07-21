package com.company.example.springbootdemo.entity;

import java.io.Serializable;

public class IndustryDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer industryId;
    private String industryName;
    private String industryDescription;

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }

    public String getIndustryDescription() {
        return industryDescription;
    }

    public void setIndustryDescription(String industryDescription) {
        this.industryDescription = industryDescription == null ? null : industryDescription.trim();
    }
}