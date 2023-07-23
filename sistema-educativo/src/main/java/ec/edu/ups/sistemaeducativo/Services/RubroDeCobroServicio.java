package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.RubroDeCobro;
import ec.edu.ups.sistemaeducativo.Repositories.RubroDeCobroRepositorio;


@Service
public class RubroDeCobroServicio {
    
    private final RubroDeCobroRepositorio rubroDeCobroRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public RubroDeCobroServicio(RubroDeCobroRepositorio rubroDeCobroRepositorio){
        this.rubroDeCobroRepositorio= rubroDeCobroRepositorio;
    }

    public List<RubroDeCobro> getRubroDeCobros(){
        return this.rubroDeCobroRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoRubroDeCobro (RubroDeCobro rubroDeCobro) {
        datos = new HashMap<>();

        Optional<RubroDeCobro> respuesta = rubroDeCobroRepositorio.findRubroDeCobroByAdmTipoDePago(rubroDeCobro.getAdmTipoDePago());

        if(respuesta.isPresent()){
            datos.put("Error", true);
            datos.put("message", "Ya existe un rubro de cobro con ese tipo de pago");
            return new ResponseEntity<>(datos,HttpStatus.CONFLICT);
        }

        rubroDeCobroRepositorio.save(rubroDeCobro);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarRubroDeCobro (RubroDeCobro rubroDeCobro) {
        datos = new HashMap<>();

        Optional<RubroDeCobro> respuesta = rubroDeCobroRepositorio.findById(rubroDeCobro.getAdmId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontro un rubro con el ID proporcionado");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        rubroDeCobroRepositorio.save(rubroDeCobro);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarRubroDeCobro (Long id){
        boolean existencia = this.rubroDeCobroRepositorio.existsById(id);
        datos = new HashMap<>();

        if(!existencia){
            datos.put("Error", true);
            datos.put("message", "El ID del rubro de cobro no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        rubroDeCobroRepositorio.deleteById(id);
        datos.put("message", "Rubro de cobro Eliminado");
        return new ResponseEntity<Object>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarRubroDeCobro (Long id) {
        Optional<RubroDeCobro> rubroDeCobroOptional = rubroDeCobroRepositorio.findById(id);
        if(rubroDeCobroOptional.isPresent()){
            RubroDeCobro rubroDeCobro = rubroDeCobroOptional.get();
            return new ResponseEntity<>(rubroDeCobro, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Rubro de Cobro no encontrado", HttpStatus.NOT_FOUND);
        }
    }


}
