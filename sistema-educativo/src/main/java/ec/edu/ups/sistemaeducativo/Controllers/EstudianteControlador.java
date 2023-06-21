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

import ec.edu.ups.sistemaeducativo.Models.Estudiante;
import ec.edu.ups.sistemaeducativo.Services.EstudianteServicio;

@RestController
@RequestMapping(path = "usuario")
public class EstudianteControlador {

    private final EstudianteServicio estudianteServicio;

    @Autowired
    public EstudianteControlador (EstudianteServicio estudianteServicio){
        this.estudianteServicio = estudianteServicio;
    }

    @GetMapping(path = "listar")
    public List<Estudiante> getUsuarios(){
        return this.estudianteServicio.getEstudiantes();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarEstudiante(@RequestBody Estudiante estudiante){
        return this.estudianteServicio.nuevoEstudiante(estudiante);    
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarEstudiante(@RequestBody Estudiante estudiante){
        return this.estudianteServicio.actualizarEstudiante(estudiante);
    }
 
    @DeleteMapping(path = "eliminar/{estId}")
    public ResponseEntity<Object> eliminarEstudiante(@PathVariable("estId") Long id){
        return this.estudianteServicio.eliminarEstudiante(id);
    }

    @GetMapping(path = "buscar/{estId}")
    public ResponseEntity<Object> buscarEstudiante (@PathVariable("estId") Long id){
        return this.estudianteServicio.buscarEstudiante(id);
    }
}