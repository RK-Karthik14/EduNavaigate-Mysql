package com.example.backend.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="coursesafterug")
public class CoursesAfterUg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String sal;
    private String job;
    private String course;
    private String duration;
    private String institutes;
    private String eligibility;
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getSal() {
        return sal;
    }
    public void setSal(String sal) {
        this.sal = sal;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
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
    public String getInstitutes() {
        return institutes;
    }
    public void setInstitutes(String institutes) {
        this.institutes = institutes;
    }
    public String getEligibility() {
        return eligibility;
    }
    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    
}
