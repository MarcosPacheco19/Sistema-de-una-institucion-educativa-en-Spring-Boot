package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Estudiante;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
    
    Optional<Estudiante> findEstudiantebyCedula(String Cedula);
}
