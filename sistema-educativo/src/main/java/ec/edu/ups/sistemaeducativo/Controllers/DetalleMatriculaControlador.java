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

import ec.edu.ups.sistemaeducativo.Models.DetalleMatricula;
import ec.edu.ups.sistemaeducativo.Services.DetalleMatriculaServicio;

@RestController
@RequestMapping(path = "detalleMatricula")
public class DetalleMatriculaControlador {
    
    private final DetalleMatriculaServicio detalleMatriculaServicio;

    @Autowired
    public DetalleMatriculaControlador(DetalleMatriculaServicio detalleMatriculaServicio) {
        this.detalleMatriculaServicio = detalleMatriculaServicio;
    }

    @GetMapping(path = "listar")
    public List<DetalleMatricula> getDetalleMatricula() {
        return this.detalleMatriculaServicio.getDetalles();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarDetalleMatricula(@RequestBody DetalleMatricula DetalleMatricula) {
        return this.detalleMatriculaServicio.nuevoDetalleMatricula(DetalleMatricula);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarDetalleMatricula(@RequestBody DetalleMatricula DetalleMatricula) {
        return this.detalleMatriculaServicio.actualizarDetalleMatricula(DetalleMatricula);
    }

    @DeleteMapping(path = "eliminar/{edi_id}")
    public ResponseEntity<Object> eliminarDetalleMatricula(@PathVariable("edi_id") Long id) {
        return this.detalleMatriculaServicio.eliminarDetalleMatricula(id);
    }

    @GetMapping(path = "buscar/{edi_id}")
    public ResponseEntity<Object> buscarDetalleMatricula(@PathVariable("edi_id") Long id) {
        return this.detalleMatriculaServicio.buscarDetalleMatricula(id);
    }
}
