package com.example.demo.service;

import com.example.demo.repository.ApejotistaRepository;
import org.springframework.stereotype.Service;

@Service
public class ApejotistaService {

    private ApejotistaRepository apejotistaRepository;

    public ApejotistaService(ApejotistaRepository apejotistaRepository) {
        this.apejotistaRepository = apejotistaRepository;
    }


}
