package ec.edu.ups.sistemaeducativo.Controllers;
import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<Map<String, String>> login(@RequestParam String usuCorreo, @RequestParam String usuPassword) {
    Optional<Usuario> optionalUsuario = usuarioServicio.findByUsuCorreoAndUsuPassword(usuCorreo, usuPassword);
    if (optionalUsuario.isPresent()) {
        Map<String, String> response = new HashMap<>();
        response.put("perfilAcceso", optionalUsuario.get().getUsuPerfilAcceso());
        return ResponseEntity.ok(response);
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("perfilAcceso", "Usuario y/o contraseña incorrectos.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
}
