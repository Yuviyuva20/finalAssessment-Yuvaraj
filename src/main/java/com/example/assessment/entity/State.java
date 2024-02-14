package com.example.assessment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String stateName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @ManyToMany(mappedBy = "states")
    List<CoveragePremium> coveragePremiums;

    public List<CoveragePremium> getCoveragePremiums() {
        return coveragePremiums;
    }

    public void setCoveragePremiums(List<CoveragePremium> coveragePremiums) {
        this.coveragePremiums = coveragePremiums;
    }
}
