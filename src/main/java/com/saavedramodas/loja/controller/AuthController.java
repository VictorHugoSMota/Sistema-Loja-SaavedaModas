package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.request.LoginRequestDTO;
import com.saavedramodas.loja.dto.response.LoginResponseDTO;
import com.saavedramodas.loja.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request){

        boolean autenticado =
                authService.login(request);

        if(!autenticado){
            return ResponseEntity.badRequest()
                    .body(
                            new LoginResponseDTO(
                                    "Usuário ou senha inválidos"
                            )
                    );
        }

        return ResponseEntity.ok(
                new LoginResponseDTO(
                        "Login realizado com sucesso"
                )
        );
    }
}