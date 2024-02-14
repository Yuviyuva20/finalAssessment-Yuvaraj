package com.example.assessment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String coverageName;

    public String getCoverageName() {
        return coverageName;
    }

    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }
    @ManyToMany(mappedBy = "coverageList")
    List<Policy> policyHolderList;

    public List<Policy> getPolicyHolderList() {
        return policyHolderList;
    }

    public void setPolicyHolderList(List<Policy> policyHolderList) {
        this.policyHolderList = policyHolderList;
    }

    @ManyToMany(mappedBy = "coverages")
    List<CoveragePremium> coveragePremiums;

    public List<CoveragePremium> getCoveragePremiums() {
        return coveragePremiums;
    }

    public void setCoveragePremiums(List<CoveragePremium> coveragePremiums) {
        this.coveragePremiums = coveragePremiums;
    }

}
