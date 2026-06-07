package com.saavedramodas.loja.service;

import com.saavedramodas.loja.domain.entity.CanalRecebimento;
import com.saavedramodas.loja.repository.CanalRecebimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CanalRecebimentoService {

        private final CanalRecebimentoRepository canalRecebimentoRepository;

        public CanalRecebimento salvar(CanalRecebimento canalRecebimento){
            return canalRecebimentoRepository.save(canalRecebimento);
        }
}
