package ec.edu.ups.sistemaeducativo.Repositories;
import ec.edu.ups.sistemaeducativo.Models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
     Optional<Usuario> findByUsuCorreoAndUsuPassword(String usuCorreo, String usuPassword);
}