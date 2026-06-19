package com.saavedramodas.loja.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LancamentoUpdateDTO {

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(
            value = "0.01",
            message = "O valor deve ser maior que zero"
    )
    private BigDecimal valor;

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    @NotNull(message = "O canal de recebimento é obrigatório")
    private Long canalRecebimentoId;
}