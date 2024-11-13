package com.example.backend.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exams {
    
    @Id
    private int sno;
    private String examname, conductingauthority, typeofexam, eligibility, gender, minage, maxage, noofattempts, reservations;
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getExamname() {
        return examname;
    }
    public void setExamname(String examname) {
        this.examname = examname;
    }
    public String getConductingauthority() {
        return conductingauthority;
    }
    public void setConductingauthority(String conductingauthority) {
        this.conductingauthority = conductingauthority;
    }
    public String getTypeofexam() {
        return typeofexam;
    }
    public void setTypeofexam(String typeofexam) {
        this.typeofexam = typeofexam;
    }
    public String getEligibility() {
        return eligibility;
    }
    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMinage() {
        return minage;
    }
    public void setMinage(String minage) {
        this.minage = minage;
    }
    public String getMaxage() {
        return maxage;
    }
    public void setMaxage(String maxage) {
        this.maxage = maxage;
    }
    public String getNoofattempts() {
        return noofattempts;
    }
    public void setNoofattempts(String noofattempts) {
        this.noofattempts = noofattempts;
    }
    public String getReservations() {
        return reservations;
    }
    public void setReservations(String reservations) {
        this.reservations = reservations;
    }

    
}
