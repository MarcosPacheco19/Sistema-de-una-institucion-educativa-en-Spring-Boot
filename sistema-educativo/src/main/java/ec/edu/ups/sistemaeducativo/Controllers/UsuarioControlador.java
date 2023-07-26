package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Services.UsuarioServicio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping(path = "usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("login")
    public Usuario login(@RequestBody Usuario usuario){
        Optional<Usuario> optionalUsuario = usuarioServicio.findByUsuCorreoAndUsuPassword(usuario.getUsuCorreo(), usuario.getUsuPassword());
        if(optionalUsuario.isPresent()){
            return optionalUsuario.get();
        } else {
            throw new RuntimeException("Usuario y/o contraseña incorrectos.");
        }
    }
}
