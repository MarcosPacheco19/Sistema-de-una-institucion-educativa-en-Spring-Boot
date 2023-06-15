package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.sistemaeducativo.Models.DetalleFactura;
import ec.edu.ups.sistemaeducativo.Models.RubroDeCobro;
import ec.edu.ups.sistemaeducativo.Services.DetalleFacturaServicio;
import ec.edu.ups.sistemaeducativo.Services.RubroDeCobroServicio;

@RestController
@RequestMapping(name = "detalleFactura")
public class DetalleFacturaControlador {
    private final DetalleFacturaServicio detalleFacturaServicio;

    @Autowired
    public DetalleFacturaControlador(DetalleFacturaServicio detalleFacturaServicio){
        this.detalleFacturaServicio = detalleFacturaServicio;
    }

    // @GetMapping(path = "listar")
    // public List<DetalleFactura> getDetalleFacturas(){
    //     return this.detalleFacturaServicio.get
    // }
}
