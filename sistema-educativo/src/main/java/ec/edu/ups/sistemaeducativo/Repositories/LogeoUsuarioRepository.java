package ec.edu.ups.sistemaeducativo.Repositories;
import ec.edu.ups.sistemaeducativo.Models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogeoUsuarioRepository extends JpaRepository<Usuario, Long> {
    
     Optional<Usuario> findUsuarioByUsuCorreo(String usuCorreo);
}