package com.saavedramodas.loja.service;

import com.saavedramodas.loja.domain.entity.Fiado;
import com.saavedramodas.loja.domain.enums.StatusFiado;
import com.saavedramodas.loja.dto.request.FiadoRequestDTO;
import com.saavedramodas.loja.dto.response.FiadoResponseDTO;
import com.saavedramodas.loja.repository.FiadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FiadoService {

    private final FiadoRepository fiadoRepository;

    public FiadoResponseDTO cadastrar(FiadoRequestDTO dto) {
        Fiado fiado = Fiado.builder()
                .nomeCliente(dto.getNomeCliente())
                .valor(dto.getValor())
                .dataPegou(dto.getDataPegou())
                .dataVencimento(dto.getDataVencimento())
                .descricao(dto.getDescricao())
                .status(StatusFiado.PENDENTE)
                .build();

        Fiado fiadoSalvo = fiadoRepository.save(fiado);

        return converterParaResponseDTO(fiadoSalvo);
    }

    public List<FiadoResponseDTO> listarTodos() {
        return fiadoRepository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public FiadoResponseDTO buscarPorId(Long id) {
        Fiado fiado = buscarEntidadePorId(id);

        return converterParaResponseDTO(fiado);
    }

    public FiadoResponseDTO editar(Long id, FiadoRequestDTO dto) {
        Fiado fiado = buscarEntidadePorId(id);

        fiado.setNomeCliente(dto.getNomeCliente());
        fiado.setValor(dto.getValor());
        fiado.setDataPegou(dto.getDataPegou());
        fiado.setDataVencimento(dto.getDataVencimento());
        fiado.setDescricao(dto.getDescricao());

        Fiado fiadoAtualizado = fiadoRepository.save(fiado);

        return converterParaResponseDTO(fiadoAtualizado);
    }

    public FiadoResponseDTO marcarComoPago(Long id) {
        Fiado fiado = buscarEntidadePorId(id);

        fiado.setStatus(StatusFiado.PAGO);
        fiado.setDataPagamento(LocalDate.now());

        Fiado fiadoPago = fiadoRepository.save(fiado);

        return converterParaResponseDTO(fiadoPago);
    }

    public void excluir(Long id) {
        Fiado fiado = buscarEntidadePorId(id);

        fiadoRepository.delete(fiado);
    }

    private Fiado buscarEntidadePorId(Long id) {
        return fiadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fiado não encontrado."));
    }

    private FiadoResponseDTO converterParaResponseDTO(Fiado fiado) {
        return FiadoResponseDTO.builder()
                .id(fiado.getId())
                .nomeCliente(fiado.getNomeCliente())
                .valor(fiado.getValor())
                .dataPegou(fiado.getDataPegou())
                .dataVencimento(fiado.getDataVencimento())
                .dataPagamento(fiado.getDataPagamento())
                .descricao(fiado.getDescricao())
                .status(fiado.getStatus())
                .build();
    }
}