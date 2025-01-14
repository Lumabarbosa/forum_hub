package br.com.alura.forumhub.service;

import br.com.alura.forumhub.dto.TopicoRequestDTO;
import br.com.alura.forumhub.dto.TopicoResponseDTO;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.model.StatusTopico;
import br.com.alura.forumhub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {this.repository = repository;}

    @Transactional
    public TopicoResponseDTO criarTopico(TopicoRequestDTO dto) {
        if (repository.existsByTituloAndMensagem(dto.titulo(), dto.mensagem())) {
            throw new IllegalArgumentException("Tópico já existe com o mesmo título e mensagem.");
        }

        var topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setDataCriacao(LocalDateTime.now());
        var salvo = repository.save(topico);
        return new TopicoResponseDTO(salvo.getId(), salvo.getTitulo(), salvo.getMensagem(), salvo.getDataCriacao(), salvo.getEstado().name(), salvo.getAutor(), salvo.getCurso());
    }

    public Page<TopicoResponseDTO> listarTopicos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(topico -> new TopicoResponseDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensagem(),
                        topico.getDataCriacao(),
                        topico.getEstado().name(),
                        topico.getAutor(),
                        topico.getCurso()
                ));
    }

    public TopicoResponseDTO detalharTopico(Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tópico não encontrado."));

        return new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getEstado().name(),
                topico.getAutor(),
                topico.getCurso()
        );
    }

    @Transactional
    public TopicoResponseDTO atualizarTopico(Long id, TopicoRequestDTO dto) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tópico não encontrado."));

        if (repository.existsByTituloAndMensagem(dto.titulo(), dto.mensagem())) {
            throw new IllegalArgumentException("Tópico já existe com o mesmo título e mensagem.");
        }

        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setAutor(dto.autor());
        topico.setCurso(dto.curso());

        Topico atualizado = repository.save(topico);

        return new TopicoResponseDTO(
                atualizado.getId(),
                atualizado.getTitulo(),
                atualizado.getMensagem(),
                atualizado.getDataCriacao(),
                atualizado.getEstado().name(),
                atualizado.getAutor(),
                atualizado.getCurso()
        );
    }

    @Transactional
    public void excluirTopico(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Tópico não encontrado.");
        }

        repository.deleteById(id);
    }
}
