package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.GrupoAsignatura;
import ec.edu.ups.sistemaeducativo.Repositories.GrupoAsignaturaRepositorio;

@Service
public class GrupoAsignaturaServicio {
    
    private final GrupoAsignaturaRepositorio grupoAsignaturaRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public GrupoAsignaturaServicio(GrupoAsignaturaRepositorio grupoAsignaturaRepositorio){
		this.grupoAsignaturaRepositorio=grupoAsignaturaRepositorio;
	}

    public List<GrupoAsignatura> getGruposAsignaturas(){
		return this.grupoAsignaturaRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoGrupoAsignatura (GrupoAsignatura grupoAsignatura) {
		datos = new HashMap<>();

        Optional<GrupoAsignatura> respuesta = grupoAsignaturaRepositorio.findGrupoAsignaturaByGrupo(grupoAsignatura.getGrupoAcademino());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el GrupoAsignatura");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        grupoAsignaturaRepositorio.save(grupoAsignatura);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarCarrera (GrupoAsignatura grupoAsignatura){
        datos = new HashMap<>();

        Optional<GrupoAsignatura> respuesta = grupoAsignaturaRepositorio.findById(grupoAsignatura.getGrpId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el GrupoAsignatura con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        grupoAsignaturaRepositorio.save(grupoAsignatura);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarCarrera (Long id){
		boolean existencia =this.grupoAsignaturaRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del GrupoAsignatura no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		grupoAsignaturaRepositorio.deleteById(id);
		datos.put("message", "GrupoAsignatura Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarCarrera (Long id){
		Optional<GrupoAsignatura> CarreraOptional = grupoAsignaturaRepositorio.findById(id);
    	if (CarreraOptional.isPresent()) {
        	GrupoAsignatura GrupoAsignatura = CarreraOptional.get();
        return new ResponseEntity<>(GrupoAsignatura, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("GrupoAsignatura no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
