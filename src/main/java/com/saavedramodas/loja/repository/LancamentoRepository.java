package com.saavedramodas.loja.repository;

import com.saavedramodas.loja.domain.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}