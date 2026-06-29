package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.dto.request.CanalRecebimentoRequestDTO;
import com.saavedramodas.loja.dto.request.CanalRecebimentoUpdateDTO;
import com.saavedramodas.loja.service.CanalRecebimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canais")
@RequiredArgsConstructor

public class CanalRecebimentoController {

    private final CanalRecebimentoService canalRecebimentoService;

    @PostMapping
    public CanalRecebimento salvar(@Valid @RequestBody CanalRecebimentoRequestDTO request){
        CanalRecebimento canalRecebimento = new CanalRecebimento();

        canalRecebimento.setNome(request.getNome());

        return canalRecebimentoService.salvar(canalRecebimento);
    }

    @GetMapping
    public List<CanalRecebimento> listarTodos(){

        return canalRecebimentoService.listarTodos();
    }

    @PutMapping("/{id}")
    public CanalRecebimento editar(
            @PathVariable Long id,
            @Valid @RequestBody CanalRecebimentoUpdateDTO dto){

        return canalRecebimentoService.editar(id,dto);
    }


}
