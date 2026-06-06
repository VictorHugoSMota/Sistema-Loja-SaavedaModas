package com.saavedramodas.loja.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "canal_recebimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CanalRecebimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String nome;

}
