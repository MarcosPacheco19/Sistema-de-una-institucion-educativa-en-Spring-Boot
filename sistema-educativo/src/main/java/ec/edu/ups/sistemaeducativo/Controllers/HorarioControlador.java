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

import ec.edu.ups.sistemaeducativo.Models.Horario;

import ec.edu.ups.sistemaeducativo.Services.HorarioServicio;

@RestController
@RequestMapping(path = "horario")
public class HorarioControlador {
    private final HorarioServicio horarioServicio;

    @Autowired
    public HorarioControlador(HorarioServicio horarioServicio) {
        this.horarioServicio = horarioServicio;
    }

    @GetMapping(path = "listar")
    public List<Horario> getHorario() {
        return this.horarioServicio.getHorario();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarPeriodoLectivo(@RequestBody Horario horario) {
        return this.horarioServicio.nuevoHorario(horario);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarPeriodoLectivo(@RequestBody Horario horario) {
        return this.horarioServicio.actualizarHorario(horario);
    }

    @DeleteMapping(path = "eliminar/{hor_id}")
    public ResponseEntity<Object> eliminarPeriodoLectivo(@PathVariable("hor_id") Long id) {
        return this.horarioServicio.eliminarHorario(id);
    }

    @GetMapping(path = "buscar/{hor_id}")
    public ResponseEntity<Object> buscarPeriodoLectivo(@PathVariable("hor_id") Long id) {
        return this.horarioServicio.buscarHorario(id);
    }

}
