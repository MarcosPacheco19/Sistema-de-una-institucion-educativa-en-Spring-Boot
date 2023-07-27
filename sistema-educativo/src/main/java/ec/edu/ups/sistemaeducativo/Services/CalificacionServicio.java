package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Calificacion;
import ec.edu.ups.sistemaeducativo.Repositories.CalificacionRespositorio;

@Service
public class CalificacionServicio {
    
    private final CalificacionRespositorio calificacionRespositorio;
    HashMap<String, Object> datos;

    @Autowired
	public CalificacionServicio(CalificacionRespositorio calificacionRespositorio){
		this.calificacionRespositorio=calificacionRespositorio;
	}

    public List<Calificacion> getCalificaciones(){
		return this.calificacionRespositorio.findAll();
	}

    public ResponseEntity<Object> nuevaCalificaciones (Calificacion calificacion) {
		datos = new HashMap<>();

        Optional<Calificacion> respuesta = calificacionRespositorio.findCalificacionByCaliId(calificacion.getCaliId());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el calificacion");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        calificacionRespositorio.save(calificacion);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarCalificaciones (Calificacion calificacion){
        datos = new HashMap<>();

        Optional<Calificacion> respuesta = calificacionRespositorio.findById(calificacion.getCaliId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el calificacion con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        calificacionRespositorio.save(calificacion);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarCalificaciones (Long id){
		boolean existencia =this.calificacionRespositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Calificacion no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		calificacionRespositorio.deleteById(id);
		datos.put("message", "Calificacion Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarCalificaciones (Long id){
		Optional<Calificacion> CalificacionesOptional = calificacionRespositorio.findById(id);
    	if (CalificacionesOptional.isPresent()) {
        	Calificacion calificacion = CalificacionesOptional.get();
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Calificacion no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
