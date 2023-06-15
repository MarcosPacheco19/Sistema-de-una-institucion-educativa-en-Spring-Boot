package ec.edu.ups.sistemaeducativo.Repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.GrupoAsignatura;

@Repository
public interface GrupoAsignaturaRepositorio extends JpaRepository<GrupoAsignatura, Long>{
    
    Optional<GrupoAsignatura> findGrupoAsignatura(String idGrpAsignatura);
}

