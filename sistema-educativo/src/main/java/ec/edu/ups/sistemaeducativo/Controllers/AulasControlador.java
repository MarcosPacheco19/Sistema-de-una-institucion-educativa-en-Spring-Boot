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

import ec.edu.ups.sistemaeducativo.Models.Aulas;
import ec.edu.ups.sistemaeducativo.Services.AulasServicio;

@RestController
@RequestMapping(path = "aulas")
public class AulasControlador {

    private final AulasServicio aulasServicio;

    @Autowired
    public AulasControlador(AulasServicio aulasServicio) {
        this.aulasServicio = aulasServicio;
    }

    @GetMapping(path = "listar")
    public List<Aulas> getAulas() {
        return this.aulasServicio.getAulas();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarAulas(@RequestBody Aulas aulas) {
        return this.aulasServicio.nuevaAula(aulas);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarAulas(@RequestBody Aulas aulas) {
        return this.aulasServicio.actualizarAula(aulas);
    }

    @DeleteMapping(path = "eliminar/{aulId}")
    public ResponseEntity<Object> eliminarAulas(@PathVariable("aulId") Long id) {
        return this.aulasServicio.eliminarAula(id);
    }

    @GetMapping(path = "buscar/{aulId}")
    public ResponseEntity<Object> buscarAulas(@PathVariable("aulId") Long id) {
        return this.aulasServicio.buscarAula(id);
    }

}
