package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ec.edu.ups.sistemaeducativo.Models.PeriodoLectivo;

import ec.edu.ups.sistemaeducativo.Repositories.PeriodoLectivoRepositorio;

@Service
public class PeriodoLectivoServicio {

    @Autowired
    private PeriodoLectivoRepositorio periodoLectivoRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public PeriodoLectivoServicio(PeriodoLectivoRepositorio periodoLectivoRepositorio) {
        this.periodoLectivoRepositorio = periodoLectivoRepositorio;
    }

    public List<PeriodoLectivo> getPeriodoLectivos() {
        return this.periodoLectivoRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        datos = new HashMap<>();

        Optional<PeriodoLectivo> respuesta = periodoLectivoRepositorio
                .findPeridiodoLectivoByPlId(periodoLectivo.getPlId());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "Ya existe el PeriodoLectivo");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        periodoLectivoRepositorio.save(periodoLectivo);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        datos = new HashMap<>();

        Optional<PeriodoLectivo> respuesta = periodoLectivoRepositorio.findById(periodoLectivo.getPlId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontró el PeriodoLectivo con el ID proporcionado");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        periodoLectivoRepositorio.save(periodoLectivo);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarPeriodoLectivo(Long id) {
        boolean existencia = this.periodoLectivoRepositorio.existsById(id);
        datos = new HashMap<>();

        if (!existencia) {
            datos.put("Error", true);
            datos.put("message", "El ID del PeriodoLectivo no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        periodoLectivoRepositorio.deleteById(id);
        datos.put("message", "PeriodoLectivo Eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarPeriodoLectivo(Long id) {
        Optional<PeriodoLectivo> periodoLectivoOptional = periodoLectivoRepositorio.findById(id);
        if (periodoLectivoOptional.isPresent()) {
            PeriodoLectivo periodoLectivo = periodoLectivoOptional.get();
            return new ResponseEntity<>(periodoLectivo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("PeriodoLectivo no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
