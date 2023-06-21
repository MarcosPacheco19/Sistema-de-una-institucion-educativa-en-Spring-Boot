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

import ec.edu.ups.sistemaeducativo.Models.PeriodoLectivo;

import ec.edu.ups.sistemaeducativo.Services.PeriodoLectivoServicio;

@RestController
@RequestMapping(path = "periodoLectivo")
public class PeriodoLectivoControlador {

    private final PeriodoLectivoServicio periodoLectivoServicio;

    @Autowired
    public PeriodoLectivoControlador(PeriodoLectivoServicio periodoLectivoServicio) {
        this.periodoLectivoServicio = periodoLectivoServicio;
    }

    @GetMapping(path = "listar")
    public List<PeriodoLectivo> getPeriodoLectivo() {
        return this.periodoLectivoServicio.getPeriodoLectivos();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarPeriodoLectivo(@RequestBody PeriodoLectivo periodoLectivo) {
        return this.periodoLectivoServicio.nuevoPeriodoLectivo(periodoLectivo);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarPeriodoLectivo(@RequestBody PeriodoLectivo periodoLectivo) {
        return this.periodoLectivoServicio.actualizarEstudiante(periodoLectivo);
    }

    @DeleteMapping(path = "eliminar/{per_id}")
    public ResponseEntity<Object> eliminarPeriodoLectivo(@PathVariable("per_id") Long id) {
        return this.periodoLectivoServicio.eliminarPeriodoLectivo(id);
    }

    @GetMapping(path = "buscar/{per_id}")
    public ResponseEntity<Object> buscarPeriodoLectivo(@PathVariable("per_id") Long id) {
        return this.periodoLectivoServicio.buscarPeriodoLectivo(id);
    }

}
