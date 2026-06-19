package com.saavedramodas.loja.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CanalRecebimentoUpdateDTO {

    @NotBlank(
            message = "O nome do canal é obrigatório"
    )
    @Size(
            max = 50,
            message = "O nome pode ter no máximo 50 caracteres"
    )
    private String nome;
}