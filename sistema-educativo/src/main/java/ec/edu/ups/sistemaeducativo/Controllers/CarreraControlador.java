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

import ec.edu.ups.sistemaeducativo.Models.Carrera;
import ec.edu.ups.sistemaeducativo.Services.CarreraServicio;

@RestController
@RequestMapping(path = "Carreras")
public class CarreraControlador {

    private final CarreraServicio carreraServicio;

    @Autowired
    public CarreraControlador (CarreraServicio carreraServicio){
        this.carreraServicio = carreraServicio;
    }

    @GetMapping(path = "listar")
    public List<Carrera> getCarreras(){
        return this.carreraServicio.getCarreras();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarCarrera(@RequestBody Carrera carrera){
        return this.carreraServicio.nuevoCarrera(carrera);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarCarrera(@RequestBody Carrera carrera){
        return this.carreraServicio.actualizarCarrera(carrera);
    }

    @DeleteMapping(path = "eliminar/{carId}")
    public ResponseEntity<Object> eliminarCarrera(@PathVariable("carId") Long id){
        return this.carreraServicio.eliminarCarrera(id);
    }

    @GetMapping(path = "buscar/{carId}")
    public ResponseEntity<Object> buscarCarrera (@PathVariable("carId") Long id){
        return this.carreraServicio.buscarCarrera(id);
    }
}