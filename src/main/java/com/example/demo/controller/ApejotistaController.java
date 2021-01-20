package com.example.demo.controller;

import com.example.demo.service.ApejotistaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Apejotistas")
public class ApejotistaController {

    private ApejotistaService apejotistaService;


}
