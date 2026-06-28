package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.request.LancamentoUpdateDTO;
import com.saavedramodas.loja.service.CanalRecebimentoService;
import com.saavedramodas.loja.service.LancamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.domain.entity.Lancamento;
import com.saavedramodas.loja.dto.request.LancamentoRequestDTO;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor

public class LancamentoController {

    private final LancamentoService lancamentoService;
    private final CanalRecebimentoService canalRecebimentoService;

    @PostMapping
    public Lancamento salvar(@Valid @RequestBody LancamentoRequestDTO request){

        CanalRecebimento canalRecebimento=
                canalRecebimentoService.buscarPorId(request.getCanalRecebimentoId());

        Lancamento lancamento = new Lancamento();

        lancamento.setValor(request.getValor());
        lancamento.setData(request.getData());
        lancamento.setCanalRecebimento(canalRecebimento);

        return lancamentoService.salvar(lancamento);
    }

    @GetMapping
    public List<Lancamento> listartTodos(){
        return lancamentoService.listarTodos();
    }

    @GetMapping("/data")
    public List<Lancamento> buscarPorData(@RequestParam LocalDate data){
        return lancamentoService.buscarPorData(data);
    }

    @PutMapping("/{id}")
    public Lancamento editar(
            @PathVariable Long id,
            @Valid @RequestBody LancamentoUpdateDTO dto){

        return lancamentoService.editar(id,dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){

        lancamentoService.excluir(id);
        return ResponseEntity.noContent().build();

    }
}