package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.CabeceraFactura;
import ec.edu.ups.sistemaeducativo.Repositories.CabeceraFacturaRepositorio;

@Service
public class CabeceraFacturaServicio {
    
    private final CabeceraFacturaRepositorio cabeceraFacturaRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public CabeceraFacturaServicio(CabeceraFacturaRepositorio cabeceraFacturaRepositorio){
        this.cabeceraFacturaRepositorio= cabeceraFacturaRepositorio;
    }

    public List<CabeceraFactura> getCabeceras(){
        return this.cabeceraFacturaRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevaCabecera (CabeceraFactura cabeceraFactura){
        datos = new HashMap<>();

        Optional<CabeceraFactura> respuesta = cabeceraFacturaRepositorio.findCabeceraPorCorreo(cabeceraFactura.getCabCorreo());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "Ya existe una cabecera con el correo ingresado");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        cabeceraFacturaRepositorio.save(cabeceraFactura);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarCabeceraFactura (CabeceraFactura cabeceraFactura){
        datos = new HashMap<>();
        
        Optional<CabeceraFactura> respuesta = cabeceraFacturaRepositorio.findById(cabeceraFactura.getCabId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontro la cabecera con el ID proporcionado");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }
        
        cabeceraFacturaRepositorio.save(cabeceraFactura);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarCabeceraFactura (Long id) {
        boolean existencia = this.cabeceraFacturaRepositorio.existsById(id);
        datos = new HashMap<>();

        if(!existencia){
            datos.put("Error", true);
            datos.put("message", "El ID de la cabecera no existe");
            return new  ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        cabeceraFacturaRepositorio.deleteById(id);
        datos.put("message", "Cabecera Eliminada");
        return new ResponseEntity<Object>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarCabeceraFactura (Long id) {
        Optional<CabeceraFactura> cabeceraFacturaOptional = cabeceraFacturaRepositorio.findById(id);
        if (cabeceraFacturaOptional.isPresent()) {
            CabeceraFactura cabeceraFactura = cabeceraFacturaOptional.get();
            return new ResponseEntity<>(cabeceraFactura, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Cabecera De Factura No Encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
