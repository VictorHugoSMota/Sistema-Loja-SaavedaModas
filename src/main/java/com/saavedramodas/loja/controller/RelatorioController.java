package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.response.RelatorioDiarioResponseDTO;
import com.saavedramodas.loja.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final RelatorioService relatorioService;

    //Metodo Diario
    @GetMapping("/diario")
    public List<RelatorioDiarioResponseDTO> buscarRelatorioDiario(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate data){

        return relatorioService.buscarRelatorioDiario(data);
    }

    // Metodo Perido
    @GetMapping("/periodo")
    public List<RelatorioDiarioResponseDTO> buscarRelatorioPeriodo(

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataInicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate dataFim){

        return relatorioService.buscarRelatorioPeriodo(
                dataInicio,
                dataFim
        );
    }
}