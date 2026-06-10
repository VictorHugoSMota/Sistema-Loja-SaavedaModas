package com.saavedramodas.loja.service;

import com.saavedramodas.loja.dto.response.HomeResponseDTO;
import com.saavedramodas.loja.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final LancamentoRepository lancamentoRepository;

    public HomeResponseDTO buscarDadosHome(){

        LocalDate hoje = LocalDate.now();

        BigDecimal faturamentoDia =
                lancamentoRepository.somarPorData(hoje);

        if(faturamentoDia == null){
            faturamentoDia = BigDecimal.ZERO;
        }

        return HomeResponseDTO.builder()
                .data(hoje)
                .faturamentoDia(faturamentoDia)
                .build();
    }
}
