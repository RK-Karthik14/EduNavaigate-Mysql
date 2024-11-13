package com.example.backend.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="coursesafter12")
public class CourseAfter12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String domain;
    private String coursename; 
    private String duration;
    private String eligibility;
    private String description;
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getCoursename() {
        return coursename;
    }
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getEligibility() {
        return eligibility;
    }
    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
