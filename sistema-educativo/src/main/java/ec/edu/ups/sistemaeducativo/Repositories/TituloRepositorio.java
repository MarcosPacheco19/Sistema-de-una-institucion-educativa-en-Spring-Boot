package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Titulo;

@Repository
public interface TituloRepositorio extends JpaRepository<Titulo, Long> {
    
     Optional<Titulo> findTituloByTitNombre(String nombreTitulo);
}
