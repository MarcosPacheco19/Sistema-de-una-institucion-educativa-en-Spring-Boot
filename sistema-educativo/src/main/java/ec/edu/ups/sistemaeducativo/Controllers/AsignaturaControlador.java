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

import ec.edu.ups.sistemaeducativo.Models.Asignatura;
import ec.edu.ups.sistemaeducativo.Services.AsignaturaServicio;

@RestController
@RequestMapping(path="asignaturas")
public class AsignaturaControlador {

    private final AsignaturaServicio asignaturaServicio;

    @Autowired
    public AsignaturaControlador (AsignaturaServicio asignaturaServicio){
        this.asignaturaServicio = asignaturaServicio;
    }

    @GetMapping(path = "listar")
    public List<Asignatura> getAsignaturas(){
        return this.asignaturaServicio.getAsignaturas();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarAsignatura(@RequestBody Asignatura asignatura){
        return this.asignaturaServicio.nuevoAsignatura(asignatura);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarAsignatura(@RequestBody Asignatura asignatura){
        return this.asignaturaServicio.actualizarAsignatura(asignatura);
    }

    @DeleteMapping(path = "eliminar/{asigId}")
    public ResponseEntity<Object> eliminarAsignatura(@PathVariable("asigId") Long id){
        return this.asignaturaServicio.eliminarAsignatura(id);
    }

    @GetMapping(path = "buscar/{asigId}")
    public ResponseEntity<Object> buscarAsignatura (@PathVariable("asigId") Long id){
        return this.asignaturaServicio.buscarAsignatura(id);
    }
}