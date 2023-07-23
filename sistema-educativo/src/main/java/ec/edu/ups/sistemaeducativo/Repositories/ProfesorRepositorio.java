package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Profesor;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Long>{
    
    Optional<Profesor> findProfesorByCedula(String cedulaProfesor);
}

