package ec.edu.ups.sistemaeducativo.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ec.edu.ups.sistemaeducativo.Models.CarreraEstudiante;
import ec.edu.ups.sistemaeducativo.Repositories.CarreraEstudianteRepositorio;
import ec.edu.ups.sistemaeducativo.Services.CarreraEstudianteServicio;

@ExtendWith(MockitoExtension.class)
public class CarreraEstudianteServicioTest {

    @InjectMocks
    private CarreraEstudianteServicio carreraEstudianteServicio;

    @Mock
    private CarreraEstudianteRepositorio carreraEstudianteRepositorio;

    @Test
    public void testGetCarrerasEstudiantes() {
        List<CarreraEstudiante> lista = new ArrayList<>();
        lista.add(new CarreraEstudiante());

        when(carreraEstudianteRepositorio.findAll()).thenReturn(lista);

        List<CarreraEstudiante> resultado = carreraEstudianteServicio.getCarrerasEstudiantes();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoCarreraEstudianteExistente() {
        CarreraEstudiante carreraEstudiante = new CarreraEstudiante();
        carreraEstudiante.setCarEstId(1L);

        when(carreraEstudianteRepositorio.findByCarEstId(carreraEstudiante.getCarEstId())).thenReturn(Optional.of(carreraEstudiante));

        ResponseEntity<Object> resultado = carreraEstudianteServicio.nuevoCarreraEstudiante(carreraEstudiante);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoCarreraEstudianteNuevo() {
        CarreraEstudiante carreraEstudiante = new CarreraEstudiante();
        carreraEstudiante.setCarEstId(1L);

        when(carreraEstudianteRepositorio.findByCarEstId(carreraEstudiante.getCarEstId())).thenReturn(Optional.empty());
        when(carreraEstudianteRepositorio.save(carreraEstudiante)).thenReturn(carreraEstudiante);

        ResponseEntity<Object> resultado = carreraEstudianteServicio.nuevoCarreraEstudiante(carreraEstudiante);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCarreraEstudianteNoExistente() {
        CarreraEstudiante carreraEstudiante = new CarreraEstudiante();
        carreraEstudiante.setCarEstId(1L);

        when(carreraEstudianteRepositorio.findByCarEstId(carreraEstudiante.getCarEstId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = carreraEstudianteServicio.actualizarCarreraEstudiante(carreraEstudiante);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCarreraEstudianteExistente() {
        CarreraEstudiante carreraEstudiante = new CarreraEstudiante();
        carreraEstudiante.setCarEstId(1L);

        when(carreraEstudianteRepositorio.findByCarEstId(carreraEstudiante.getCarEstId())).thenReturn(Optional.of(carreraEstudiante));
        when(carreraEstudianteRepositorio.save(carreraEstudiante)).thenReturn(carreraEstudiante);

        ResponseEntity<Object> resultado = carreraEstudianteServicio.actualizarCarreraEstudiante(carreraEstudiante);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCarreraEstudianteNoExistente() {
        Long id = 1L;

        when(carreraEstudianteRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = carreraEstudianteServicio.eliminarCarreraEstudiante(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCarreraEstudianteExistente() {
        Long id = 1L;

        when(carreraEstudianteRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(carreraEstudianteRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = carreraEstudianteServicio.eliminarCarreraEstudiante(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCarreraEstudianteNoExistente() {
        Long id = 1L;

        when(carreraEstudianteRepositorio.findByCarEstId(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = carreraEstudianteServicio.buscarCarreraEstudiante(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCarreraEstudianteExistente() {
        Long id = 1L;
        CarreraEstudiante carreraEstudiante = new CarreraEstudiante();
        carreraEstudiante.setCarEstId(id);

        when(carreraEstudianteRepositorio.findByCarEstId(id)).thenReturn(Optional.of(carreraEstudiante));

        ResponseEntity<Object> resultado = carreraEstudianteServicio.buscarCarreraEstudiante(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(carreraEstudiante, resultado.getBody());
    }
}

