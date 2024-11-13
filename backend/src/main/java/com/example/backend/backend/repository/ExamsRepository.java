package com.example.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.backend.model.Exams;

public interface ExamsRepository extends JpaRepository<Exams, Integer>{
    
}
