package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Edificio;
import ec.edu.ups.sistemaeducativo.Repositories.EdificioRepositrio;

@Service
public class EdificioServicio {

    @Autowired
    private EdificioRepositrio edificioRepositrio;
    HashMap<String, Object> datos;

    @Autowired
    public EdificioServicio(EdificioRepositrio edificioRepositrio) {
        this.edificioRepositrio = edificioRepositrio;
    }

    public List<Edificio> getEdificio() {
        return this.edificioRepositrio.findAll();
    }

    public ResponseEntity<Object> nuevoEdificio(Edificio edificio) {
        datos = new HashMap<>();

        Optional<Edificio> respuesta = edificioRepositrio
                .findEdificioByEdiId(edificio.getEdiId());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "Ya existe el Edificio");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        edificioRepositrio.save(edificio);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarEdificio(Edificio edificio) {
        datos = new HashMap<>();

        Optional<Edificio> respuesta = edificioRepositrio.findById(edificio.getEdiId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontró el Edificio con el ID proporcionado");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        edificioRepositrio.save(edificio);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarEdificio(Long id) {
        boolean existencia = this.edificioRepositrio.existsById(id);
        datos = new HashMap<>();

        if (!existencia) {
            datos.put("Error", true);
            datos.put("message", "El ID del Edificio no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        edificioRepositrio.deleteById(id);
        datos.put("message", "Edificio Eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarEdificio(Long id) {
        Optional<Edificio> edificioOptional = edificioRepositrio.findById(id);
        if (edificioOptional.isPresent()) {
            Edificio edificio = edificioOptional.get();
            return new ResponseEntity<>(edificio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Edificio no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
