package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.DetalleFactura;
import ec.edu.ups.sistemaeducativo.Repositories.DetalleFacturaRepositorio;

@Service
public class DetalleFacturaServicio {
    
    private final DetalleFacturaRepositorio detalleFacturaRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public DetalleFacturaServicio(DetalleFacturaRepositorio detalleFacturaRepositorio){
        this.detalleFacturaRepositorio = detalleFacturaRepositorio;
    }

    public List<DetalleFactura> getDetalles(){
        return this.detalleFacturaRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoDetalleFactura(DetalleFactura detalleFactura){
        datos = new HashMap<>();

        Optional<DetalleFactura> respuesta = detalleFacturaRepositorio.findDetalleFacturaByDetDescripcion(detalleFactura.getDetDescripcion());

        if(respuesta.isPresent()){
            datos.put("Error", true);
            datos.put("message", "Ya existe un detalle con esa descripción");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        detalleFacturaRepositorio.save(detalleFactura);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarDetalleFactura(DetalleFactura detalleFactura){
        datos = new HashMap<>();

        Optional<DetalleFactura> respuesta = detalleFacturaRepositorio.findById(detalleFactura.getDetId());

        if(respuesta.isEmpty()){
            datos.put("Error", true);
            datos.put("message", "No se encontro el detalle con la descripcion proporcionada");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        detalleFacturaRepositorio.save(detalleFactura);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarDetalleFactura(Long id){
        boolean existencia = this.detalleFacturaRepositorio.existsById(id);
        datos = new HashMap<>();

        if(!existencia){
            datos.put("Error", true);
            datos.put("message", "El ID del detalle no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        detalleFacturaRepositorio.deleteById(id);
        datos.put("message", "Detalle de Factura eliminado");
        return new ResponseEntity<Object>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarDetalleFactura (Long id){
        Optional<DetalleFactura> detalleFacturOptional = detalleFacturaRepositorio.findById(id);
        if(detalleFacturOptional.isPresent()){
            DetalleFactura detalleFactura = detalleFacturOptional.get();
            return new ResponseEntity<>(detalleFactura, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Detalle De Factura no Encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
