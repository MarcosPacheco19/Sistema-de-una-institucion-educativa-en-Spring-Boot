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

import ec.edu.ups.sistemaeducativo.Models.Titulo;
import ec.edu.ups.sistemaeducativo.Services.TituloServicio;


@RestController
@RequestMapping(path = "titulo")
public class TituloControlador {
    
    private final TituloServicio tituloServicio;

    @Autowired
    public TituloControlador (TituloServicio tituloServicio){
        this.tituloServicio = tituloServicio;
    }

    @GetMapping(path = "listar")
    public List<Titulo> getTitulos(){
        return this.tituloServicio.getTitulos();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarTitulos(@RequestBody Titulo titulo){
        return this.tituloServicio.nuevoTitulo(titulo);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarTitulo(@RequestBody Titulo titulo){
        return this.tituloServicio.actualizarTitulo(titulo);
    }

    @DeleteMapping(path = "eliminar/{titId}")
    public ResponseEntity<Object> eliminarTitulo(@PathVariable("titId") Long id){
        return this.tituloServicio.eliminarTitulo(id);
    }

    @GetMapping(path = "buscar/{titId}")
    public ResponseEntity<Object> buscarTitulo (@PathVariable("titId") Long id){
        return this.tituloServicio.buscarTitulo(id);
    }
}
