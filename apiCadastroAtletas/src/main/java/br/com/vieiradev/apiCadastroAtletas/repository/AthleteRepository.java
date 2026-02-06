package br.com.vieiradev.apiCadastroAtletas.repository;

import br.com.vieiradev.apiCadastroAtletas.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
