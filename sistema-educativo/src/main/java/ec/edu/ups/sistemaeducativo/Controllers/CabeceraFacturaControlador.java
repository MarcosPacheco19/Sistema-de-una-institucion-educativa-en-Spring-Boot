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

import ec.edu.ups.sistemaeducativo.Models.CabeceraFactura;
import ec.edu.ups.sistemaeducativo.Services.CabeceraFacturaServicio;

@RestController
@RequestMapping(path = "cabeceraFactura")
public class CabeceraFacturaControlador {
    private final CabeceraFacturaServicio cabeceraFacturaServicio;

    @Autowired
    public CabeceraFacturaControlador(CabeceraFacturaServicio cabeceraFacturaServicio){
        this.cabeceraFacturaServicio = cabeceraFacturaServicio;
    }

    @GetMapping(path = "listar")
    public List<CabeceraFactura> getCabeceraFacturas(){
        return this.cabeceraFacturaServicio.getCabeceras();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarCabeceraFactura(@RequestBody CabeceraFactura cabeceraFactura){
        return this.cabeceraFacturaServicio.nuevaCabecera(cabeceraFactura);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarCabeceraFactura(@RequestBody CabeceraFactura cabeceraFactura){
        return this.cabeceraFacturaServicio.actualizarCabeceraFactura(cabeceraFactura);
    }

    @DeleteMapping(path = "eliminar/{cabId}")
    public ResponseEntity<Object> eliminarCabeceraFactura(@PathVariable("cabId") Long id){
        return this.cabeceraFacturaServicio.eliminarCabeceraFactura(id);
    }

    @GetMapping(path = "buscar/{cabId}")
    public ResponseEntity<Object> buscarCabeceraFactura (@PathVariable("cabId") Long id){
        return this.cabeceraFacturaServicio.buscarCabeceraFactura(id);
    }
}
