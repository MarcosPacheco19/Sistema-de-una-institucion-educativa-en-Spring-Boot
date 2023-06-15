package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Asignatura;

@Repository
public interface AsignaturaRepositorio extends JpaRepository<Asignatura, Long>{
    
    Optional<Asignatura> findAsignaturaByNombre(String nombreAsignatura);
}
