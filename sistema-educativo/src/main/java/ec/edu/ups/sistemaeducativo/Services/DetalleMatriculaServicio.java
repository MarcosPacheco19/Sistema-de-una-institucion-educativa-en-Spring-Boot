package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.DetalleMatricula;
import ec.edu.ups.sistemaeducativo.Repositories.DetalleMatriculaRepositorio;

@Service
public class DetalleMatriculaServicio {
    
    private final DetalleMatriculaRepositorio detalleMatriculaRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public DetalleMatriculaServicio(DetalleMatriculaRepositorio detalleMatriculaRepositorio){
        this.detalleMatriculaRepositorio = detalleMatriculaRepositorio;
    }

    public List<DetalleMatricula> getDetalles(){
        return this.detalleMatriculaRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoDetalleMatricula(DetalleMatricula detalleMatricula){
        datos = new HashMap<>();

        Optional<DetalleMatricula> respuesta = detalleMatriculaRepositorio.findDetalleMatriculaByTipoMatricula(detalleMatricula.getTipoMatricula());

        if(respuesta.isPresent()){
            datos.put("Error", true);
            datos.put("message", "Ya existe un detalle con esa descripción");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        detalleMatriculaRepositorio.save(detalleMatricula);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarDetalleMatricula(DetalleMatricula detalleMatricula){
        datos = new HashMap<>();

        Optional<DetalleMatricula> respuesta = detalleMatriculaRepositorio.findById(detalleMatricula.getDetMatId());

        if(respuesta.isEmpty()){
            datos.put("Error", true);
            datos.put("message", "No se encontro el detalle con la descripcion proporcionada");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        detalleMatriculaRepositorio.save(detalleMatricula);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarDetalleMatricula(Long id){
        boolean existencia = this.detalleMatriculaRepositorio.existsById(id);
        datos = new HashMap<>();

        if(!existencia){
            datos.put("Error", true);
            datos.put("message", "El ID del detalle no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        detalleMatriculaRepositorio.deleteById(id);
        datos.put("message", "Detalle de Factura eliminado");
        return new ResponseEntity<Object>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarDetalleMatricula (Long id){
        Optional<DetalleMatricula> detalleFacturOptional = detalleMatriculaRepositorio.findById(id);
        if(detalleFacturOptional.isPresent()){
            DetalleMatricula detalleMatricula = detalleFacturOptional.get();
            return new ResponseEntity<>(detalleMatricula, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Detalle De Factura no Encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
