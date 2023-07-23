package ec.edu.ups.sistemaeducativo.Repositories;

import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Aulas;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface AulasRepositorio extends JpaRepository<Aulas, Long> {

    Optional<Aulas> findAulatebyId(Long aulId);

}

