package com.saavedramodas.loja.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class PasswordService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String criptografar(String senha){
        return encoder.encode(senha);
    }

    public boolean verificar(
            String senhaDigitada,
            String senhaBanco){

        return encoder.matches(senhaDigitada,senhaBanco);
    }

}