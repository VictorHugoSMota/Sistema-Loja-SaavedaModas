package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.dto.request.CanalRecebimentoRequestDTO;
import com.saavedramodas.loja.service.CanalRecebimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canais")
@RequiredArgsConstructor

public class CanalRecebimentoController {

    private final CanalRecebimentoService canalRecebimentoService;

    @PostMapping
    public CanalRecebimento salvar(@RequestBody CanalRecebimentoRequestDTO request){
        CanalRecebimento canalRecebimento = new CanalRecebimento();

        canalRecebimento.setNome(request.getNome());

        return canalRecebimentoService.salvar(canalRecebimento);
    }
}
