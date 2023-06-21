package ec.edu.ups.sistemaeducativo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ec.edu.ups.sistemaeducativo.Models.Horario;

import ec.edu.ups.sistemaeducativo.Repositories.HorarioRepositorio;

public class HorarioServicio {

    @Autowired
    private HorarioRepositorio horarioRepositorio;
    HashMap<String, Object> datos;

    @Autowired
    public HorarioServicio(HorarioRepositorio horarioRepositorio) {
        this.horarioRepositorio = horarioRepositorio;
    }

    public List<Horario> getHorario() {
        return this.horarioRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoHorario(Horario horario) {
        datos = new HashMap<>();

        Optional<Horario> respuesta = horarioRepositorio
                .findHorariobyId(horario.getHorId());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "Ya existe el Horario");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        horarioRepositorio.save(horario);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarHorario(Horario horario) {
        datos = new HashMap<>();

        Optional<Horario> respuesta = horarioRepositorio.findById(horario.getHorId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontró el Horario con el ID proporcionado");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        horarioRepositorio.save(horario);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarHorario(Long id) {
        boolean existencia = this.horarioRepositorio.existsById(id);
        datos = new HashMap<>();

        if (!existencia) {
            datos.put("Error", true);
            datos.put("message", "El ID del Horario no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        horarioRepositorio.deleteById(id);
        datos.put("message", "Horario Eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarHorario(Long id) {
        Optional<Horario> periodoLectivoOptional = horarioRepositorio.findById(id);
        if (periodoLectivoOptional.isPresent()) {
            Horario horario = periodoLectivoOptional.get();
            return new ResponseEntity<>(horario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Horario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
