package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Services.UsuarioServicio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario){
        Optional<Usuario> optionalUsuario = usuarioServicio.findByUsuCorreoAndUsuPassword(usuario.getUsuCorreo(), usuario.getUsuPassword());
        if(optionalUsuario.isPresent()){
            return ResponseEntity.ok(optionalUsuario.get().getUsuPerfilAcceso());
        } else {
            throw new RuntimeException("Usuario y/o contraseña incorrectos.");
        }
    }
}
