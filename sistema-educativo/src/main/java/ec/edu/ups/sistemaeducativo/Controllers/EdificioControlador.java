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

import ec.edu.ups.sistemaeducativo.Models.Edificio;
import ec.edu.ups.sistemaeducativo.Services.EdificioServicio;

@RestController
@RequestMapping(path = "edificio")
public class EdificioControlador {

    private final EdificioServicio edificioServicio;

    @Autowired
    public EdificioControlador(EdificioServicio edificioServicio) {
        this.edificioServicio = edificioServicio;
    }

    @GetMapping(path = "listar")
    public List<Edificio> getEdificio() {
        return this.edificioServicio.getEdificio();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarEdificio(@RequestBody Edificio edificio) {
        return this.edificioServicio.nuevoEdificio(edificio);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarEdificio(@RequestBody Edificio edificio) {
        return this.edificioServicio.actualizarEdificio(edificio);
    }

    @DeleteMapping(path = "eliminar/{edi_id}")
    public ResponseEntity<Object> eliminarEdificio(@PathVariable("edi_id") Long id) {
        return this.edificioServicio.eliminarEdificio(id);
    }

    @GetMapping(path = "buscar/{edi_id}")
    public ResponseEntity<Object> buscarPeriodoLectivo(@PathVariable("edi_id") Long id) {
        return this.edificioServicio.buscarEdificio(id);
    }
}
