package com.saavedramodas.loja.service;

import com.saavedramodas.loja.dto.response.RelatorioDiarioResponseDTO;
import com.saavedramodas.loja.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.saavedramodas.loja.dto.response.RelatorioItemDTO;
import com.saavedramodas.loja.dto.response.RelatorioResponseDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RelatorioService {

    private final LancamentoRepository lancamentoRepository;

    public RelatorioResponseDTO buscarRelatorioDiario(LocalDate data){

        List<Object[]> resultado =
                lancamentoRepository.buscarRelatorioDiario(data);

        List<RelatorioItemDTO> itens =
                new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for(Object[] linha : resultado){

            BigDecimal valor = (BigDecimal) linha[1];

            itens.add(
                    new RelatorioItemDTO(
                            (String) linha[0],
                            valor
                    )
            );

            total = total.add(valor);
        }

        return new RelatorioResponseDTO(
                itens,
                total
        );
    }

    //Metodo Periodo
    public RelatorioResponseDTO buscarRelatorioPeriodo(
            LocalDate dataInicio,
            LocalDate dataFim) {

        List<Object[]> resultado =
                lancamentoRepository.buscarRelatorioPeriodo(
                        dataInicio,
                        dataFim
                );

        List<RelatorioItemDTO> itens =
                new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for(Object[] linha : resultado){

            BigDecimal valor = (BigDecimal) linha[1];

            itens.add(
                    new RelatorioItemDTO(
                            (String) linha[0],
                            valor
                    )
            );

            total = total.add(valor);
        }

        return new RelatorioResponseDTO(
                itens,
                total
        );
    }

    // Metodo Mes atual
    public RelatorioResponseDTO buscarRelatorioMesAtual() {

        LocalDate hoje = LocalDate.now();

        LocalDate inicioMes =
                hoje.withDayOfMonth(1);

        return buscarRelatorioPeriodo(
                inicioMes,
                hoje
        );
    }

    // Metodo Ultimos 30 Dias
    public RelatorioResponseDTO buscarRelatorioUltimos30Dias(){

        LocalDate hoje = LocalDate.now();

        LocalDate inicio =
                hoje.minusDays(30);

        return buscarRelatorioPeriodo(
                inicio,
                hoje
        );
    }

    // Metodo Ano Atual
    public RelatorioResponseDTO buscarRelatorioAnoAtual(){

        LocalDate hoje = LocalDate.now();

        LocalDate inicioAno =
                hoje.withDayOfYear(1);

        return buscarRelatorioPeriodo(
                inicioAno,
                hoje
        );
    }
}
