package com.example.assessment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Policy {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyId;

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    private String holderName;

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int rate;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "policy_coverage",
            joinColumns = @JoinColumn(name = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "coverage_id")
    )
    private List<Coverage> coverageList;

    public List<Coverage> getCoverageList() {
        return coverageList;
    }

    public void setCoverageList(List<Coverage> coverageList) {
        this.coverageList = coverageList;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
