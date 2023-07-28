package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Usuario> login(@RequestParam String usuCorreo, @RequestParam String usuPassword) {
        Optional<Usuario> optionalUsuario = usuarioServicio.findByUsuCorreoAndUsuPassword(usuCorreo, usuPassword);
        
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

     @GetMapping(path = "listar")
    public List<Usuario> getUsuarios() {
        return this.usuarioServicio.getUsuarios();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarUsuario(@RequestBody Usuario Usuario) {
        return this.usuarioServicio.nuevoUsuario(Usuario);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Usuario Usuario) {
        return this.usuarioServicio.actualizarUsuario(Usuario);
    }

    @DeleteMapping(path = "eliminar/{estId}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("usuId") Long id) {
        return this.usuarioServicio.eliminarUsuario(id);
    }

    @GetMapping(path = "buscar/{estId}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable("usuId") Long id) {
        return this.usuarioServicio.buscarUsuario(id);
    }
}
