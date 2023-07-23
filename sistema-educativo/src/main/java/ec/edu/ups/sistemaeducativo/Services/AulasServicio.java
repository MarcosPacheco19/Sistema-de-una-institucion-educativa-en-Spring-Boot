package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.Aulas;
import ec.edu.ups.sistemaeducativo.Repositories.AulasRepositorio;

@Service
public class AulasServicio {
    @Autowired
    private final AulasRepositorio aulasRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public AulasServicio(AulasRepositorio aulasRepositorio) {
        this.aulasRepositorio = aulasRepositorio;
    }

    public List<Aulas> getAulas() {
        return this.aulasRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevaAula(Aulas aulas) {
        datos = new HashMap<>();

        Optional<Aulas> respuesta = aulasRepositorio.findAulasByAulId(aulas.getAulId());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "Ya existe la Aula");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        aulasRepositorio.save(aulas);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarAula(Aulas aulas) {
        datos = new HashMap<>();

        Optional<Aulas> respuesta = aulasRepositorio.findById(aulas.getAulId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontró el aula con el ID proporcionado");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        aulasRepositorio.save(aulas);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarAula(Long id) {
        boolean existencia = this.aulasRepositorio.existsById(id);
        datos = new HashMap<>();

        if (!existencia) {
            datos.put("Error", true);
            datos.put("message", "El ID de la Aula no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        aulasRepositorio.deleteById(id);
        datos.put("message", "Aula Eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarAula(Long id) {
        Optional<Aulas> aulasOptional = aulasRepositorio.findById(id);
        if (aulasOptional.isPresent()) {
            Aulas aulas = aulasOptional.get();
            return new ResponseEntity<>(aulas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Aula no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
