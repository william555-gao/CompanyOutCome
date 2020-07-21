package com.company.example.springbootdemo.entity;

import java.io.Serializable;

public class TechnosphereDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer technosphereId;
    private String technosphereName;
    private String technosphereDescription;

    public Integer getTechnosphereId() {
        return technosphereId;
    }

    public void setTechnosphereId(Integer technosphereId) {
        this.technosphereId = technosphereId;
    }

    public String getTechnosphereName() {
        return technosphereName;
    }

    public void setTechnosphereName(String technosphereName) {
        this.technosphereName = technosphereName == null ? null : technosphereName.trim();
    }

    public String getTechnosphereDescription() {
        return technosphereDescription;
    }

    public void setTechnosphereDescription(String technosphereDescription) {
        this.technosphereDescription = technosphereDescription == null ? null : technosphereDescription.trim();
    }
}