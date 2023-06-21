package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ups.sistemaeducativo.Models.Horario;

public interface HorarioRepositorio extends JpaRepository<Horario, Long> {

    Optional<Horario> findHorariobyId(Long horId);

}
