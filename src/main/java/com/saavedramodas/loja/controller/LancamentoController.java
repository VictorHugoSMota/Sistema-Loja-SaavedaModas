package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.service.CanalRecebimentoService;
import com.saavedramodas.loja.service.LancamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.domain.entity.Lancamento;
import com.saavedramodas.loja.dto.request.LancamentoRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor

public class LancamentoController {

    private final LancamentoService lancamentoService;

    private final CanalRecebimentoService canalRecebimentoService;

    @PostMapping
    public Lancamento salvar(@RequestBody LancamentoRequestDTO request){

        CanalRecebimento canalRecebimento=
                canalRecebimentoService.buscarPorId(request.getCanalRecebimentoId());

        Lancamento lancamento = new Lancamento();

        lancamento.setValor(request.getValor());
        lancamento.setData(request.getData());
        lancamento.setCanalRecebimento(canalRecebimento);

        return lancamentoService.salvar(lancamento);
    }
}