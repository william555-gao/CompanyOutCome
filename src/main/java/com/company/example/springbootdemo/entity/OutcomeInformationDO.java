package com.company.example.springbootdemo.entity;

import java.io.Serializable;

public class OutcomeInformationDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer outcomeId;
    private String outcomeName;
    private String belongDomain;
    private String cooperationType;
    private String transactionPrice;
    private String useType;
    private String maturity;
    private String companyName;

    public Integer getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(Integer outcomeId) {
        this.outcomeId = outcomeId;
    }

    public String getOutcomeName() {
        return outcomeName;
    }

    public void setOutcomeName(String outcomeName) {
        this.outcomeName = outcomeName == null ? null : outcomeName.trim();
    }

    public String getBelongDomain() {
        return belongDomain;
    }

    public void setBelongDomain(String belongDomain) {
        this.belongDomain = belongDomain == null ? null : belongDomain.trim();
    }

    public String getCooperationType() {
        return cooperationType;
    }

    public void setCooperationType(String cooperationType) {
        this.cooperationType = cooperationType == null ? null : cooperationType.trim();
    }

    public String getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(String transactionPrice) {
        this.transactionPrice = transactionPrice == null ? null : transactionPrice.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity == null ? null : maturity.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
}