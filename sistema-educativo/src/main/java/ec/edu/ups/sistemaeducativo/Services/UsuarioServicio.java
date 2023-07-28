package ec.edu.ups.sistemaeducativo.Services;

import ec.edu.ups.sistemaeducativo.Models.Usuario;
import ec.edu.ups.sistemaeducativo.Repositories.UsuarioRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio  {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    HashMap<String, Object> datos;

    public Optional<Usuario> findByUsuCorreoAndUsuPassword(String usuCorreo, String usuPassword){
        return usuarioRepositorio.findByUsuCorreoAndUsuPassword(usuCorreo, usuPassword);
    }

    public List<Usuario> getUsuarios(){
		return this.usuarioRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoUsuario (Usuario Usuario) {
		datos = new HashMap<>();

        Optional<Usuario> respuesta = usuarioRepositorio.findByUsuCedula(Usuario.getUsuCedula());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el Usuario");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        usuarioRepositorio.save(Usuario);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarUsuario (Usuario Usuario){
        datos = new HashMap<>();

        Optional<Usuario> respuesta = usuarioRepositorio.findById(Usuario.getUsuId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el Usuario con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        usuarioRepositorio.save(Usuario);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarUsuario (Long id){
		boolean existencia =this.usuarioRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Usuario no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		usuarioRepositorio.deleteById(id);
		datos.put("message", "Usuario Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarUsuario (Long id){
		Optional<Usuario> UsuarioOptional = usuarioRepositorio.findById(id);
    	if (UsuarioOptional.isPresent()) {
        	Usuario Usuario = UsuarioOptional.get();
        return new ResponseEntity<>(Usuario, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}