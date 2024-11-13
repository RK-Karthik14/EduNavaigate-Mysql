package com.example.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.backend.model.Schools;

public interface SchoolRepository extends JpaRepository<Schools, String>{
    
}
