package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.DetalleMatricula;

@Repository
public interface DetalleMatriculaRepositorio extends JpaRepository<DetalleMatricula, Long>{
    
        Optional<DetalleMatricula> findDetalleMatriculaByTipoMatricula(String matTipoMatricula);
}
