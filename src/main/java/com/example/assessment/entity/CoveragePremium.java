package com.example.assessment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CoveragePremium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int rate;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Coverage> coverages;

    public List<Coverage> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<Coverage> coverages) {
        this.coverages = coverages;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private List<State> states;

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
