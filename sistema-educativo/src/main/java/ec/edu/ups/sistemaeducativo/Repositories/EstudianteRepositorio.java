package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Usuario;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findUserByCedula(String usuario);
}
