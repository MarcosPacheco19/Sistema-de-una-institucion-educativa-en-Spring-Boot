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

import ec.edu.ups.sistemaeducativo.Models.Carrera;
import ec.edu.ups.sistemaeducativo.Repositories.CarreraRepositorio;
import ec.edu.ups.sistemaeducativo.Services.CarreraServicio;

@ExtendWith(MockitoExtension.class)
public class CarreraServicioTest {

    @InjectMocks
    private CarreraServicio carreraServicio;

    @Mock
    private CarreraRepositorio carreraRepositorio;

    @Test
    public void testGetCarreras() {
        List<Carrera> lista = new ArrayList<>();
        lista.add(new Carrera());

        when(carreraRepositorio.findAll()).thenReturn(lista);

        List<Carrera> resultado = carreraServicio.getCarreras();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoCarreraExistente() {
        Carrera carrera = new Carrera();
        carrera.setCarNombre("Ingeniería");

        when(carreraRepositorio.findCarreraByNombre(carrera.getCarNombre())).thenReturn(Optional.of(carrera));

        ResponseEntity<Object> resultado = carreraServicio.nuevoCarrera(carrera);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoCarreraNuevo() {
        Carrera carrera = new Carrera();
        carrera.setCarNombre("Ingeniería");

        when(carreraRepositorio.findCarreraByNombre(carrera.getCarNombre())).thenReturn(Optional.empty());
        when(carreraRepositorio.save(carrera)).thenReturn(carrera);

        ResponseEntity<Object> resultado = carreraServicio.nuevoCarrera(carrera);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCarreraNoExistente() {
        Carrera carrera = new Carrera();
        carrera.setCarId(1L);

        when(carreraRepositorio.findById(carrera.getCarId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = carreraServicio.actualizarCarrera(carrera);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCarreraExistente() {
        Carrera carrera = new Carrera();
        carrera.setCarId(1L);

        when(carreraRepositorio.findById(carrera.getCarId())).thenReturn(Optional.of(carrera));
        when(carreraRepositorio.save(carrera)).thenReturn(carrera);

        ResponseEntity<Object> resultado = carreraServicio.actualizarCarrera(carrera);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCarreraNoExistente() {
        Long id = 1L;

        when(carreraRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = carreraServicio.eliminarCarrera(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCarreraExistente() {
        Long id = 1L;

        when(carreraRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(carreraRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = carreraServicio.eliminarCarrera(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCarreraNoExistente() {
        Long id = 1L;

        when(carreraRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = carreraServicio.buscarCarrera(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCarreraExistente() {
        Long id = 1L;
        Carrera carrera = new Carrera();
        carrera.setCarId(id);

        when(carreraRepositorio.findById(id)).thenReturn(Optional.of(carrera));

        ResponseEntity<Object> resultado = carreraServicio.buscarCarrera(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(carrera, resultado.getBody());
    }
}

