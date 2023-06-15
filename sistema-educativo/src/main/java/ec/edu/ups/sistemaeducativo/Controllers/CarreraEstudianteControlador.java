package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.sistemaeducativo.Models.CarreraEstudiante;
import ec.edu.ups.sistemaeducativo.Services.CarreraEstudianteServicio;


@RestController
@RequestMapping("/carreraestudiantes")
public class CarreraEstudianteControlador {
    
     @Autowired
    private CarreraEstudianteServicio carreraEstudianteServicio;

    @PostMapping
    public CarreraEstudiante crearCarreraEstudiante(@RequestBody CarreraEstudiante carreraEstudiante) {
        return CarreraEstudianteServicio(carreraEstudiante);
    }

    @GetMapping("/{id}")
    public CarreraEstudiante obtenerCarreraEstudiante(@PathVariable String id) {
        return CarreraEstudianteServicio.obtenerCarreraEstudiante(id);
    }

    @PutMapping("/{id}")
    public CarreraEstudiante actualizarCarreraEstudiante(@PathVariable String id, @RequestBody CarreraEstudiante carreraEstudiante) {
        return CarreraEstudianteServicio.actualizarCarreraEstudiante(id, carreraEstudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarreraEstudiante(@PathVariable String id) {
        carreraEstudianteServicio.eliminarCarreraEstudiante(id);
    }

    @GetMapping
    public List<CarreraEstudiante> listarCarreraEstudiantes() {
        return carreraEstudianteServicio.listarCarreraEstudiantes();
    }
}
