package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
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

     public ResponseEntity<Object> nuevoUsuario(Estudiante estudiante) {
        //Optional<Estudiante> respuesta = estudianteRepositorio.findUserByCedula(estudiante.getUsuCedula());
		datos = new HashMap<>();
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
     }
}
