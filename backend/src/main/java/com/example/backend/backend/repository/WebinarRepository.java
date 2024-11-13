package com.example.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.backend.model.Webinar;

public interface WebinarRepository extends JpaRepository<Webinar, Long>{
    
}
