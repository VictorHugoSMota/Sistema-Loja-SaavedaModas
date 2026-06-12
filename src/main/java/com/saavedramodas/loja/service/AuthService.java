package com.saavedramodas.loja.service;

import com.saavedramodas.loja.domain.entity.Usuario;
import com.saavedramodas.loja.dto.request.LoginRequestDTO;
import com.saavedramodas.loja.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;

    public boolean login(LoginRequestDTO request){

        Usuario usuario = usuarioRepository
                .findByUsername(request.getUsername())
                .orElse(null);

        if(usuario == null){
            return false;
        }

        return passwordService.verificar(
                request.getPassword(),
                usuario.getPassword()
        );
    }
}
