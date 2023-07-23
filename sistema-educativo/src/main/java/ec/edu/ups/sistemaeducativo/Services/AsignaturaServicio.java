package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Asignatura;
import ec.edu.ups.sistemaeducativo.Repositories.AsignaturaRepositorio;

@Service
public class AsignaturaServicio {
    
    private final AsignaturaRepositorio asignaturaRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public AsignaturaServicio(AsignaturaRepositorio asignaturaRepositorio){
		this.asignaturaRepositorio=asignaturaRepositorio;
	}

    public List<Asignatura> getAsignaturas(){
		return this.asignaturaRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoAsignatura (Asignatura asignatura) {
		datos = new HashMap<>();

        Optional<Asignatura> respuesta = asignaturaRepositorio.findAsignaturaByAsigNombre(asignatura.getAsigNombre());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el asignatura");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        asignaturaRepositorio.save(asignatura);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarAsignatura (Asignatura asignatura){
        datos = new HashMap<>();

        Optional<Asignatura> respuesta = asignaturaRepositorio.findById(asignatura.getAsigId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el asignatura con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        asignaturaRepositorio.save(asignatura);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarAsignatura (Long id){
		boolean existencia =this.asignaturaRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Asignatura no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		asignaturaRepositorio.deleteById(id);
		datos.put("message", "Asignatura Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarAsignatura (Long id){
		Optional<Asignatura> AsignaturaOptional = asignaturaRepositorio.findById(id);
    	if (AsignaturaOptional.isPresent()) {
        	Asignatura asignatura = AsignaturaOptional.get();
        return new ResponseEntity<>(asignatura, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Asignatura no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
