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

import ec.edu.ups.sistemaeducativo.Models.CarreraEstudiante;
import ec.edu.ups.sistemaeducativo.Services.CarreraEstudianteServicio;

@RestController
@RequestMapping(path = "carreraEstudiantes")
public class CarreraEstudianteControlador {
    
    private final CarreraEstudianteServicio carreraEstudianteServicio;

    @Autowired
    public CarreraEstudianteControlador (CarreraEstudianteServicio carreraEstudianteServicio){
        this.carreraEstudianteServicio = carreraEstudianteServicio;
    }

    @GetMapping(path = "listar")
    public List<CarreraEstudiante> getUsuarios(){
        return this.carreraEstudianteServicio.getCarrerasEstudiantes();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarEstudiante(@RequestBody CarreraEstudiante estudiante){
        return this.carreraEstudianteServicio.nuevoCarreraEstudiante(estudiante);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarEstudiante(@RequestBody CarreraEstudiante estudiante){
        return this.carreraEstudianteServicio.actualizarCarreraEstudiante(estudiante);
    }

    @DeleteMapping(path = "eliminar/{carEstId}")
    public ResponseEntity<Object> eliminarEstudiante(@PathVariable("carEstId") Long id){
        return this.carreraEstudianteServicio.eliminarCarreraEstudiante(id);
    }

    @GetMapping(path = "buscar/{carEstId}")
    public ResponseEntity<Object> buscarEstudiante (@PathVariable("carEstId") Long id){
        return this.carreraEstudianteServicio.buscarCarreraEstudiante(id);
    }
}
