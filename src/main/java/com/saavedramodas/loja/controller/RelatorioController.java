package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.response.RelatorioDiarioResponseDTO;
import com.saavedramodas.loja.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.saavedramodas.loja.dto.response.RelatorioResponseDTO;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final RelatorioService relatorioService;

    // Metodo Diario
    @GetMapping("/diario")
    public RelatorioResponseDTO buscarRelatorioDiario(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate data){

        return relatorioService.buscarRelatorioDiario(data);
    }

    // Metodo Perido
    @GetMapping("/periodo")
    public RelatorioResponseDTO buscarRelatorioPeriodo(

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

    // Metodo Mes Atual
    @GetMapping("/mes-atual")
    public RelatorioResponseDTO buscarRelatorioMesAtual(){

        return relatorioService.buscarRelatorioMesAtual();
    }

    // Metodo Ultimos 30 Dias
    @GetMapping("/ultimos-30-dias")
    public RelatorioResponseDTO buscarRelatorioUltimos30Dias(){

        return relatorioService.buscarRelatorioUltimos30Dias();
    }

    // Metodo Ano Atual
    @GetMapping("/ano-atual")
    public RelatorioResponseDTO buscarRelatorioAnoAtual(){

        return relatorioService.buscarRelatorioAnoAtual();
    }
}