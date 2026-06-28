package com.saavedramodas.loja.service;

import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.domain.entity.Lancamento;
import com.saavedramodas.loja.dto.request.LancamentoUpdateDTO;
import com.saavedramodas.loja.exception.ResourceNotFoundException;
import com.saavedramodas.loja.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final CanalRecebimentoService canalRecebimentoService;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> listarTodos(){
        return lancamentoRepository.findAll();
    }

    public List<Lancamento> buscarPorData(LocalDate data){
        return lancamentoRepository.findByData(data);
    }

    public Lancamento editar(Long id, LancamentoUpdateDTO dto){

        Lancamento lancamento =
                lancamentoRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Lançamento não encontrado"));

        CanalRecebimento canalRecebimento=
                canalRecebimentoService.buscarPorId(dto.getCanalRecebimentoId());

        lancamento.setValor(dto.getValor());
        lancamento.setData(dto.getData());
        lancamento.setCanalRecebimento(canalRecebimento);

        return lancamentoRepository.save(lancamento);
    }

    public void excluir(Long id){

        Lancamento lancamento=
                lancamentoRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Lançamento não encontrado"));

        lancamentoRepository.delete(lancamento);
        }
    }
