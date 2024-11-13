package com.example.backend.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="internships")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String site;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }

    

    
}
