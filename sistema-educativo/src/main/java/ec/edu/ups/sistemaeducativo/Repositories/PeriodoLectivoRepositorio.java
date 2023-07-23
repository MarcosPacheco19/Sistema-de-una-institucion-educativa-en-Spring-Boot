package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ups.sistemaeducativo.Models.PeriodoLectivo;

public interface PeriodoLectivoRepositorio extends JpaRepository<PeriodoLectivo, Long> {

    Optional<PeriodoLectivo> findPeridiodoLectivobyId(Long plId);
}

