package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Titulo;
import ec.edu.ups.sistemaeducativo.Repositories.TituloRepositorio;

@Service
public class TituloServicio {

    private final TituloRepositorio tituloRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public TituloServicio(TituloRepositorio tituloRepositorio){
		this.tituloRepositorio=tituloRepositorio;
	}

    public List<Titulo> getTitulos(){
		return this.tituloRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoTitulo (Titulo titulo) {
		datos = new HashMap<>();

        Optional<Titulo> respuesta = tituloRepositorio.findTituloByTitNombre(titulo.getTitnombre());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el titulo");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        tituloRepositorio.save(titulo);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarTitulo (Titulo titulo){
        datos = new HashMap<>();

        Optional<Titulo> respuesta = tituloRepositorio.findById(titulo.getTitId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el titulo con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        tituloRepositorio.save(titulo);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarTitulo (Long id){
		boolean existencia =this.tituloRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Titulo no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		tituloRepositorio.deleteById(id);
		datos.put("message", "Titulo Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarTitulo (Long id){
		Optional<Titulo> tituloOptional = tituloRepositorio.findById(id);
    	if (tituloOptional.isPresent()) {
        	Titulo titulo = tituloOptional.get();
        return new ResponseEntity<>(titulo, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Titulo no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
