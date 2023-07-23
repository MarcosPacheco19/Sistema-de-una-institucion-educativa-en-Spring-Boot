package ec.edu.ups.sistemaeducativo.Services;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Repositories.LogeoUsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogeoUsuarioServicio  {
    
 @Autowired
    private LogeoUsuarioRepository logeoUsuarioRepository;

    public Usuario findByUsername(String correo) {
        Optional<Usuario> usuarioOptional = logeoUsuarioRepository.findUsuarioByUsuCorreo(correo);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            return null;
        }
    }

    public boolean validateUser(Usuario user) {
        Usuario foundUser = findByUsername(user.getUsuNombre());

        if(foundUser != null) {
            return foundUser.getUsuPassword().equals(user.getUsuPassword());
        }

        return false;
    }
}