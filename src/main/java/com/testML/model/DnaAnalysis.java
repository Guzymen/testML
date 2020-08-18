package com.testML.model;

import org.springframework.data.annotation.Id;

public class DnaAnalysis {
    
    @Id
    private String id;
    private String[] dna;
    private boolean isMutant;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String[] getDna() {
        return dna;
    }
    public void setDna(String[] dna) {
        this.dna = dna;
    }
    public boolean getIsMutant() {
        return isMutant;
    }
    public void setIsMutant(boolean isMutant) {
        this.isMutant = isMutant;
    }
}
