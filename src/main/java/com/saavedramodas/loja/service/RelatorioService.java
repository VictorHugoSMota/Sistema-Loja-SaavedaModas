package com.saavedramodas.loja.service;

import com.saavedramodas.loja.dto.response.RelatorioDiarioResponseDTO;
import com.saavedramodas.loja.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RelatorioService {

    private final LancamentoRepository lancamentoRepository;

    public List<RelatorioDiarioResponseDTO> buscarRelatorioDiario(LocalDate data){

        List<Object[]> resultado=
            lancamentoRepository.buscarRelatorioDiario(data);

        List<RelatorioDiarioResponseDTO> relatorio = new ArrayList<>();

        for(Object[] linha : resultado){

            RelatorioDiarioResponseDTO dto =
                    RelatorioDiarioResponseDTO.builder()
                            .canalRecebimento((String) linha[0])
                            .valor((BigDecimal) linha[1])
                            .build();

            relatorio.add(dto);
        }
        return relatorio;
    }
}
