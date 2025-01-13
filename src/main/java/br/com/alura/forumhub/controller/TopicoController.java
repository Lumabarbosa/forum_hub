package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.TopicoRequestDTO;
import br.com.alura.forumhub.dto.TopicoResponseDTO;
import br.com.alura.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;
    private final AuthenticationManager authenticationManager;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoResponseDTO> criar(@RequestBody @Valid TopicoRequestDTO dto) {
        TopicoResponseDTO response = service.criarTopico(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listar(@PageableDefault(size = 10, sort = "dataCriacao") Pageable pageable) {
        return ResponseEntity.ok(service.listarTopicos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalharTopico(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoRequestDTO dto) {
        TopicoResponseDTO response = service.atualizarTopico(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluirTopico(id);
        return ResponseEntity.noContent().build();
    }
}
