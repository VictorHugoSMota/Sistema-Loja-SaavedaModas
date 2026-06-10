package com.saavedramodas.loja.repository;

import com.saavedramodas.loja.domain.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query("""
            SELECT SUM(l.valor)
            FROM Lancamento l
            WHERE l.data = :data
            """)
    BigDecimal somarPorData(LocalDate data);

}