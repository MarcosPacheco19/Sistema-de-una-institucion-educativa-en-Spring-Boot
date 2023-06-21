package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ups.sistemaeducativo.Models.Edificio;

public interface EdificioRepositrio extends JpaRepository<Edificio, Long> {

    Optional<Edificio> findEdificiobyId(Long plId);
}
