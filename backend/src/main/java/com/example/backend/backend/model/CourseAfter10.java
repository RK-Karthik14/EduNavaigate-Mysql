package com.example.backend.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="courseafter10")
public class CourseAfter10 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String course;
    private String duration;
    private String eligibility;
    private String description;
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
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
