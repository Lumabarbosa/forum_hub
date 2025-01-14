package br.com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoRequestDTO(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String autor,
        @NotBlank String curso
) {}