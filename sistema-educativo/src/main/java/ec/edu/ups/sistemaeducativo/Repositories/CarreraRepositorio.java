package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Carrera;

@Repository
public interface CarreraRepositorio extends JpaRepository<Carrera, Long> {
    
    Optional<Carrera> findCarreraByCarNombre(String nombreCarrera);
}

