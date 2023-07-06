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

import ec.edu.ups.sistemaeducativo.Models.Matricula;
import ec.edu.ups.sistemaeducativo.Services.MatriculaServicio;

public class MatriculaControlador {
    
     private final MatriculaServicio matriculaServicio;

    @Autowired
    public MatriculaControlador (MatriculaServicio matriculaServicio){
        this.matriculaServicio = matriculaServicio;
    }

    @GetMapping(path = "listar")
    public List<Matricula> getMatriculas(){
        return this.matriculaServicio.getMatriculas();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarMatricula(@RequestBody Matricula matricula){
        return this.matriculaServicio.nuevoMatricula(matricula);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarMatricula(@RequestBody Matricula matricula){
        return this.matriculaServicio.actualizarMatricula(matricula);
    }

    @DeleteMapping(path = "eliminar/{asigId}")
    public ResponseEntity<Object> eliminarMatricula(@PathVariable("asigId") Long id){
        return this.matriculaServicio.eliminarMatricula(id);
    }

    @GetMapping(path = "buscar/{asigId}")
    public ResponseEntity<Object> buscarMatricula (@PathVariable("asigId") Long id){
        return this.matriculaServicio.buscarMatricula(id);
    }
}
