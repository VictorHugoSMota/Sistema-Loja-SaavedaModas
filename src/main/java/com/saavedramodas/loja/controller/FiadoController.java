package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.request.FiadoRequestDTO;
import com.saavedramodas.loja.dto.response.FiadoResponseDTO;
import com.saavedramodas.loja.service.FiadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiados")
@RequiredArgsConstructor

public class FiadoController {

    private final FiadoService fiadoService;

    @PostMapping
    public ResponseEntity<FiadoResponseDTO> cadastrar(@RequestBody FiadoRequestDTO dto) {
        FiadoResponseDTO fiado = fiadoService.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(fiado);
    }

    @GetMapping
    public ResponseEntity<List<FiadoResponseDTO>> listarTodos() {
        List<FiadoResponseDTO> fiados = fiadoService.listarTodos();

        return ResponseEntity.ok(fiados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiadoResponseDTO> buscarPorId(@PathVariable Long id) {
        FiadoResponseDTO fiado = fiadoService.buscarPorId(id);

        return ResponseEntity.ok(fiado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiadoResponseDTO> editar(
            @PathVariable Long id,
            @RequestBody FiadoRequestDTO dto
    ) {
        FiadoResponseDTO fiado = fiadoService.editar(id, dto);

        return ResponseEntity.ok(fiado);
    }

    @PatchMapping("/{id}/pagar")
    public ResponseEntity<FiadoResponseDTO> marcarComoPago(@PathVariable Long id) {
        FiadoResponseDTO fiado = fiadoService.marcarComoPago(id);

        return ResponseEntity.ok(fiado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        fiadoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}