package ec.edu.ups.sistemaeducativo.Services;
import org.springframework.beans.factory.annotation.Autowired;
import ec.edu.ups.sistemaeducativo.Models.CarreraEstudiante;
import ec.edu.ups.sistemaeducativo.Repositories.CarreraEstudianteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;



@Service
public class CarreraEstudianteServicio {
     private final CarreraEstudianteRepositorio carreraEstudianteRepositorio;
    private HashMap<String, Object> datos;

    @Autowired
    public CarreraEstudianteServicio(CarreraEstudianteRepositorio carreraEstudianteRepositorio) {
        this.carreraEstudianteRepositorio = carreraEstudianteRepositorio;
    }

    public List<CarreraEstudiante> getEstudiantes() {
        return this.carreraEstudianteRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoEstudiante(CarreraEstudiante carreraEstudiante) {
        datos = new HashMap<>();

        Optional<CarreraEstudiante> respuesta = carreraEstudianteRepositorio.findByCarEstId(carreraEstudiante.getCarEstId());

        if (respuesta.isPresent()) {
            datos.put("Error", true);
            datos.put("message", "El estudiante ya esta en una Carrra");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        carreraEstudianteRepositorio.save(carreraEstudiante);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> actualizarEstudiante(CarreraEstudiante carreraEstudiante) {
        datos = new HashMap<>();

        Optional<CarreraEstudiante> respuesta = carreraEstudianteRepositorio.findByCarEstId(carreraEstudiante.getCarEstId());

        if (respuesta.isEmpty()) {
            datos.put("Error", true);
            datos.put("message", "No se encontró el La carrera del estudiante por el id");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        carreraEstudianteRepositorio.save(carreraEstudiante);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> eliminarEstudiante(String id) {
        boolean existencia = this.carreraEstudianteRepositorio.existsByCarEstId(id);
        datos = new HashMap<>();

        if (!existencia) {
            datos.put("Error", true);
            datos.put("message", "El ID de la Carrera del estudiante no existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        carreraEstudianteRepositorio.deleteByCarEstId(id);
        datos.put("message", "Carrera Estudiante eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> buscarEstudiante(String id) {
        Optional<CarreraEstudiante> carreraEstudianteOptional = carreraEstudianteRepositorio.findByCarEstId(id);
        if (carreraEstudianteOptional.isPresent()) {
            CarreraEstudiante carreraEstudiante = carreraEstudianteOptional.get();
            return new ResponseEntity<>(carreraEstudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Carrera estudiante no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
