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

import ec.edu.ups.sistemaeducativo.Models.RubroDeCobro;
import ec.edu.ups.sistemaeducativo.Services.RubroDeCobroServicio;

@RestController
@RequestMapping(path = "rubroCobro")
public class RubroDeCobroControlador {
    private final RubroDeCobroServicio rubroDeCobroServicio;

    @Autowired
    public RubroDeCobroControlador(RubroDeCobroServicio rubroDeCobroServicio){
        this.rubroDeCobroServicio = rubroDeCobroServicio;
    }

    @GetMapping(path = "listar")
    public List<RubroDeCobro> getRubroDeCobros(){
        return this.rubroDeCobroServicio.getRubroDeCobros();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarRubroDeCobro(@RequestBody RubroDeCobro rubroDeCobro){
        return this.rubroDeCobroServicio.nuevoRubroDeCobro(rubroDeCobro);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarRubroDeCobro(@RequestBody RubroDeCobro rubroDeCobro){
        return this.rubroDeCobroServicio.actualizarRubroDeCobro(rubroDeCobro);
    }

    @DeleteMapping(path = "eliminar/{admId}")
    public ResponseEntity<Object> eliminarRubroDeCobro(@PathVariable("admId") Long id){
        return this.rubroDeCobroServicio.eliminarRubroDeCobro(id);
    }

    @GetMapping(path = "buscar/{admId}")
    public ResponseEntity<Object> buscarRubroDeCobro (@PathVariable("admId") Long id){
        return this.rubroDeCobroServicio.buscarRubroDeCobro(id);
    }
}
