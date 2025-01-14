package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensagem(String titulo, String mensagem);
    
//    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);
}
