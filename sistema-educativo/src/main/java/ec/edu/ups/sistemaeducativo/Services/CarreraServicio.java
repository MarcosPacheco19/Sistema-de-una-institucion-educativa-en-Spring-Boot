package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Carrera;
import ec.edu.ups.sistemaeducativo.Repositories.CarreraRepositorio;

@Service
public class CarreraServicio {

    private final CarreraRepositorio carreraRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public CarreraServicio(CarreraRepositorio carreraRepositorio){
		this.carreraRepositorio=carreraRepositorio;
	}

    public List<Carrera> getCarreras(){
		return this.carreraRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoCarrera (Carrera Carrera) {
		datos = new HashMap<>();

        Optional<Carrera> respuesta = carreraRepositorio.findCarreraByNombre(Carrera.getCarNombre());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el Carrera");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        carreraRepositorio.save(Carrera);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarCarrera (Carrera Carrera){
        datos = new HashMap<>();

        Optional<Carrera> respuesta = carreraRepositorio.findById(Carrera.getCarId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el Carrera con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        carreraRepositorio.save(Carrera);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarCarrera (Long id){
		boolean existencia =this.carreraRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Carrera no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		carreraRepositorio.deleteById(id);
		datos.put("message", "Carrera Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarCarrera (Long id){
		Optional<Carrera> CarreraOptional = carreraRepositorio.findById(id);
    	if (CarreraOptional.isPresent()) {
        	Carrera Carrera = CarreraOptional.get();
        return new ResponseEntity<>(Carrera, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Carrera no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}