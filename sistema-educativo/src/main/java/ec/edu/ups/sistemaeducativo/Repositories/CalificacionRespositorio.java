package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.ups.sistemaeducativo.Models.Calificacion;

@Repository
public interface CalificacionRespositorio extends JpaRepository<Calificacion, Long>{
    
    Optional<Calificacion> findCalificacionById(Long idCalificacion);
}

