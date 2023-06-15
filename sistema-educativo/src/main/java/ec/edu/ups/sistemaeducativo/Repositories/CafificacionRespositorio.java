package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.ups.sistemaeducativo.Models.Calificacion;

@Repository
public interface CafificacionRespositorio extends JpaRepository<Calificacion, Long>{
    
    Optional<Calificacion> findCalificacion(String id_Calificacion);

}
