package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Estudiante;
import ec.edu.ups.sistemaeducativo.Repositories.EstudianteRepositorio;

@Service
public class EstudianteServicio {
    
    private final EstudianteRepositorio estudianteRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public EstudianteServicio(EstudianteRepositorio estudianteRepositorio){
		this.estudianteRepositorio=estudianteRepositorio;
	}

    public List<Estudiante> getEstudiantes(){
		return this.estudianteRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoEstudiante (Estudiante estudiante) {
		datos = new HashMap<>();

        Optional<Estudiante> respuesta = estudianteRepositorio.findEstudiantebyCedula(estudiante.getUsuCedula());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el estudiante");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        estudianteRepositorio.save(estudiante);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarEstudiante (Estudiante estudiante){
        datos = new HashMap<>();

        Optional<Estudiante> respuesta = estudianteRepositorio.findById(estudiante.getEstId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el estudiante con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        estudianteRepositorio.save(estudiante);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarEstudiante (Long id){
		boolean existencia =this.estudianteRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Estudiante no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		estudianteRepositorio.deleteById(id);
		datos.put("message", "Estudiante Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarEstudiante (Long id){
		Optional<Estudiante> estudianteOptional = estudianteRepositorio.findById(id);
    	if (estudianteOptional.isPresent()) {
        	Estudiante estudiante = estudianteOptional.get();
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Estudiante no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
