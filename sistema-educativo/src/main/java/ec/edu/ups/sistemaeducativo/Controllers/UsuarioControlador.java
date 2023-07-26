package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Services.UsuarioServicio;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("login")
    public ResponseEntity<String> login(@RequestParam String usuCorreo, @RequestParam String usuPassword) {
        Optional<Usuario> optionalUsuario = usuarioServicio.findByUsuCorreoAndUsuPassword(usuCorreo, usuPassword);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get().getUsuPerfilAcceso());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario y/o contraseña incorrectos.");
        }
    }
}
