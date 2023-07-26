package ec.edu.ups.sistemaeducativo.Services;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Repositories.UsuarioRepositorio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio  {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Optional<Usuario> findByUsuCorreoAndUsuPassword(String usuCorreo, String usuPassword){
        return usuarioRepositorio.findByUsuCorreoAndUsuPassword(usuCorreo, usuPassword);
    }
}