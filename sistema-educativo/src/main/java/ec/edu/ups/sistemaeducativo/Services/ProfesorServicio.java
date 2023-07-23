package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Profesor;
import ec.edu.ups.sistemaeducativo.Repositories.ProfesorRepositorio;

@Service
public class ProfesorServicio {
   
	private final ProfesorRepositorio profesorRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public ProfesorServicio(ProfesorRepositorio profesorRepositorio){
		this.profesorRepositorio=profesorRepositorio;
	}

    public List<Profesor> getProfesores(){
		return this.profesorRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoProfesor (Profesor profesor) {
		datos = new HashMap<>();

        Optional<Profesor> respuesta = profesorRepositorio.findProfesorByUsuCedula(profesor.getUsuCedula());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el profesor");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        profesorRepositorio.save(profesor);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarProfesor (Profesor profesor){
        datos = new HashMap<>();

        Optional<Profesor> respuesta = profesorRepositorio.findById(profesor.getUsuId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el profesor con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        profesorRepositorio.save(profesor);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarProfesor (Long id){
		boolean existencia =this.profesorRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Profesor no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		profesorRepositorio.deleteById(id);
		datos.put("message", "Profesor Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarProfesor (Long id){
		Optional<Profesor> profesorOptional = profesorRepositorio.findById(id);
    	if (profesorOptional.isPresent()) {
        	Profesor profesor = profesorOptional.get();
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Profesor no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
