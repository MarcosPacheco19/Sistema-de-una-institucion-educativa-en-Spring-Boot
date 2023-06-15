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

import ec.edu.ups.sistemaeducativo.Models.Calificacion;
import ec.edu.ups.sistemaeducativo.Services.CalificacionServicio;

@RestController
@RequestMapping(path="calificacion")
public class CalificacionControlador {
    
    private final CalificacionServicio calificacionServicio;

    @Autowired
    public CalificacionControlador (CalificacionServicio calificacionServicio){
        this.calificacionServicio = calificacionServicio;
    }

    @GetMapping(path = "listar")
    public List<Calificacion> getCalificaciones(){
        return this.calificacionServicio.getCalificaciones();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarCalificacion(@RequestBody Calificacion calificacion){
        return this.calificacionServicio.nuevaCalificaciones(calificacion);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarCalificacion(@RequestBody Calificacion calificacion){
        return this.calificacionServicio.actualizarCalificaciones(calificacion);
    }

    @DeleteMapping(path = "eliminar/{caliId}")
    public ResponseEntity<Object> eliminarCalificacion(@PathVariable("caliId") Long id){
        return this.calificacionServicio.eliminarCalificaciones(id);
    }

    @GetMapping(path = "buscar/{caliId}")
    public ResponseEntity<Object> buscarCalificacion (@PathVariable("caliId") Long id){
        return this.calificacionServicio.buscarCalificaciones(id);
    }
}
