package com.saavedramodas.loja.service;

import com.saavedramodas.loja.domain.entity.Lancamento;
import com.saavedramodas.loja.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

}