package com.example.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.backend.model.Webinar;
import com.example.backend.backend.repository.WebinarRepository;

@Service
public class WebinarService {

    @Autowired
    private WebinarRepository webinarRepository;

    public List<Webinar> getAllWebinars(){
        return webinarRepository.findAll();
    }

    public Webinar saveWebinar(Webinar webinar){
        return webinarRepository.save(webinar);
    }
    
}
