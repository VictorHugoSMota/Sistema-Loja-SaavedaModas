package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.response.HomeResponseDTO;
import com.saavedramodas.loja.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/home")
    public HomeResponseDTO buscarDadosHome(){
        return homeService.buscarDadosHome();


    }
}
