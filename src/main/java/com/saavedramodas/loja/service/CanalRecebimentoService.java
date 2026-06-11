package com.saavedramodas.loja.service;

import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.repository.CanalRecebimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.saavedramodas.loja.dto.request.CanalRecebimentoUpdateDTO;

@Service
@RequiredArgsConstructor

public class CanalRecebimentoService {

        private final CanalRecebimentoRepository canalRecebimentoRepository;

        public CanalRecebimento salvar(CanalRecebimento canalRecebimento){
            return canalRecebimentoRepository.save(canalRecebimento);
        }

        public List<CanalRecebimento> listarTodos(){
            return  canalRecebimentoRepository.findAll();
        }

        public CanalRecebimento buscarPorId(Long id){
            return canalRecebimentoRepository.findById(id)
                    .orElseThrow();
        }

        public CanalRecebimento editar(Long id, CanalRecebimentoUpdateDTO dto){
            CanalRecebimento canalRecebimento =
                    buscarPorId(id);
            canalRecebimento.setNome(dto.getNome());

            return canalRecebimentoRepository.save(canalRecebimento);
        }
}
