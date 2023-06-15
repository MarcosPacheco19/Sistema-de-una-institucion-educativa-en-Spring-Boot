package ec.edu.ups.sistemaeducativo.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import ec.edu.ups.sistemaeducativo.Models.CarreraEstudiante;

@Repository
public interface CarreraEstudianteRepositorio extends JpaRepository<CarreraEstudiante,Long> {
    
    Optional<CarreraEstudiante> findByCarEstId(Long carEstId);
}
