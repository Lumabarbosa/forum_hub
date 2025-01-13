package br.com.alura.forumhub.dto;

import java.time.LocalDateTime;

public record TopicoResponseDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String estado,
        String autor,
        String curso
) {
}
