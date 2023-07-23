package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Empleado;
import ec.edu.ups.sistemaeducativo.Repositories.EmpleadoRepositorio;


@Service
public class EmpleadoServicio {
    
    private final EmpleadoRepositorio empleadoRepositorio;
    HashMap<String, Object> datos;

    @Autowired
	public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio){
		this.empleadoRepositorio=empleadoRepositorio;
	}

    public List<Empleado> getEmpleados(){
		return this.empleadoRepositorio.findAll();
	}

    public ResponseEntity<Object> nuevoEmpleado (Empleado empleado) {
		datos = new HashMap<>();

        Optional<Empleado> respuesta = empleadoRepositorio.findEmpleadoByEmpAreaTrabajo(empleado.getUsuCedula());
        
        if (respuesta.isPresent()) {
			datos.put("Error", true);
			datos.put("message", "Ya existe el empleado");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

        empleadoRepositorio.save(empleado);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarEmpleado (Empleado empleado){
        datos = new HashMap<>();

        Optional<Empleado> respuesta = empleadoRepositorio.findById(empleado.getUsuId());

        if (respuesta.isEmpty()) {
			datos.put("Error", true);
			datos.put("message", "No se encontró el empleado con el ID proporcionado");
			return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
		}

        empleadoRepositorio.save(empleado);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarEmpleado (Long id){
		boolean existencia =this.empleadoRepositorio.existsById(id);
		datos = new HashMap<>();

		if(!existencia){
			datos.put("Error", true);
			datos.put("message", "El ID del Empleado no existe");
			return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
		}

		empleadoRepositorio.deleteById(id);
		datos.put("message", "Empleado Eliminado");
		return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
	}

    public ResponseEntity<Object> buscarEmpleado (Long id){
		Optional<Empleado> empleadoOptional = empleadoRepositorio.findById(id);
    	if (empleadoOptional.isPresent()) {
        	Empleado empleado = empleadoOptional.get();
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    	} else {
        	return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
    	}
	}
}
