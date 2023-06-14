package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    
    Optional<Empleado> findEmpleadoByAreaTrabajo(String areaTrabajoEmpleado);
}
