package com.example.demo.service;

import com.example.demo.model.Apejotista;
import com.example.demo.repository.ApejotistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApejotistaService {

    private ApejotistaRepository apejotistaRepository;

    public ApejotistaService(ApejotistaRepository apejotistaRepository) {
        this.apejotistaRepository = apejotistaRepository;
    }

}
