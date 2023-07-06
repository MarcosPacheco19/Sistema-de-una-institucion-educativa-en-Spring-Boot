package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Matricula;
import ec.edu.ups.sistemaeducativo.Repositories.MatriculaRepositorio;

@Service
public class MatriculaServicio {
    
     private final MatriculaRepositorio matriculaRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public MatriculaServicio(MatriculaRepositorio matriculaRepositorio){
		this.matriculaRepositorio=matriculaRepositorio;
	}

    public List<Matricula> getMatriculas(){
		return this.matriculaRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoMatricula (Matricula matricula) {
		datos = new HashMap<>();

        Optional<Matricula> respuesta = matriculaRepositorio.findById(matricula.getMat_id());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el Matricula");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        matriculaRepositorio.save(matricula);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarMatricula (Matricula matricula){
        datos = new HashMap<>();

        Optional<Matricula> respuesta = matriculaRepositorio.findById(matricula.getMat_id());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el Matricula con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        matriculaRepositorio.save(matricula);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarMatricula (Long id){
		boolean existencia =this.matriculaRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Matricula no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		matriculaRepositorio.deleteById(id);
		datos.put("message", "Matricula Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarMatricula (Long id){
		Optional<Matricula> matriculaOptional = matriculaRepositorio.findById(id);
    	if (matriculaOptional.isPresent()) {
        	Matricula matricula = matriculaOptional.get();
        return new ResponseEntity<>(matricula, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Matricula no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
