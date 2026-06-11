package com.saavedramodas.loja.repository;

import com.saavedramodas.loja.domain.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query("""
            SELECT SUM(l.valor)
            FROM Lancamento l
            WHERE l.data = :data
            """)
    BigDecimal somarPorData(LocalDate data);

    @Query("""
       SELECT c.nome, COALESCE(SUM(l.valor),0)
       FROM CanalRecebimento c
       LEFT JOIN Lancamento l
           ON l.canalRecebimento.id = c.id
           AND l.data = :data
       GROUP BY c.nome
       """)

    List<Object[]> buscarRelatorioDiario(LocalDate data);

    @Query("""
       SELECT c.nome, COALESCE(SUM(l.valor),0)
       FROM CanalRecebimento c
       LEFT JOIN Lancamento l
           ON l.canalRecebimento.id = c.id
           AND l.data BETWEEN :dataInicio AND :dataFim
       GROUP BY c.nome
       """)
    List<Object[]> buscarRelatorioPeriodo(
            LocalDate dataInicio,
            LocalDate dataFim
    );

    List<Lancamento > findByData(LocalDate data);

}