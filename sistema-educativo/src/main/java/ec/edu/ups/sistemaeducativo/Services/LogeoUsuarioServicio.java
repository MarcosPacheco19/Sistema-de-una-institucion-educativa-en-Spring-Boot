package ec.edu.ups.sistemaeducativo.Services;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Repositories.LogeoUsuarioRepository;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogeoUsuarioServicio  {
    
 @Autowired
    private LogeoUsuarioRepository logeoUsuarioRepository;

    public Usuario findByUsername(String username) {
        return logeoUsuarioRepository.findByUsername(username);
    }

    public boolean validateUser(Usuario user) {
        Usuario foundUser = findByUsername(user.getUsuNombre());

        if(foundUser != null) {
            return foundUser.getUsuPassword().equals(user.getUsuPassword());
        }

        return false;
    }
}