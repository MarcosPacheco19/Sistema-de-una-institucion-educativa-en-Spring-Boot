package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.sistemaeducativo.Models.Profesor;
import ec.edu.ups.sistemaeducativo.Services.ProfesorServicio;

@RestController
@RequestMapping(name = "profesores")
public class ProfesorControlador {
    private final ProfesorServicio profesorServicio;

    @Autowired
    public ProfesorControlador (ProfesorServicio profesorServicio){
        this.profesorServicio = profesorServicio;
    }

    @GetMapping(path = "listar")
    public List<Profesor> getUsuarios(){
        return this.profesorServicio.getProfesores();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarProfesor(@RequestBody Profesor profesor){
        return this.profesorServicio.nuevoProfesor(profesor);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarProfesor(@RequestBody Profesor profesor){
        return this.profesorServicio.actualizarProfesor(profesor);
    }

    @DeleteMapping(path = "eliminar/{proID}")
    public ResponseEntity<Object> eliminarProfesor(@PathVariable("proID") Long id){
        return this.profesorServicio.eliminarProfesor(id);
    }

    @GetMapping(path = "buscar/{proID}")
    public ResponseEntity<Object> buscarProfesor (@PathVariable("proID") Long id){
        return this.profesorServicio.buscarProfesor(id);
    }
}
