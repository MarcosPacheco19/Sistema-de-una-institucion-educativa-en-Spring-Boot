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

import ec.edu.ups.sistemaeducativo.Models.Calificacion;
import ec.edu.ups.sistemaeducativo.Repositories.CalificacionRespositorio;
import ec.edu.ups.sistemaeducativo.Services.CalificacionServicio;

@ExtendWith(MockitoExtension.class)
public class CalificacionServicioTest {

    @InjectMocks
    private CalificacionServicio calificacionServicio;

    @Mock
    private CalificacionRespositorio calificacionRespositorio;

    @Test
    public void testGetCalificaciones() {
        List<Calificacion> lista = new ArrayList<>();
        lista.add(new Calificacion());

        when(calificacionRespositorio.findAll()).thenReturn(lista);

        List<Calificacion> resultado = calificacionServicio.getCalificaciones();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevaCalificacionExistente() {
        Calificacion calificacion = new Calificacion();
        calificacion.setCaliId(1L);

        when(calificacionRespositorio.findById(calificacion.getCaliId())).thenReturn(Optional.of(calificacion));

        ResponseEntity<Object> resultado = calificacionServicio.nuevaCalificaciones(calificacion);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevaCalificacionNueva() {
        Calificacion calificacion = new Calificacion();
        calificacion.setCaliId(1L);

        when(calificacionRespositorio.findById(calificacion.getCaliId())).thenReturn(Optional.empty());
        when(calificacionRespositorio.save(calificacion)).thenReturn(calificacion);

        ResponseEntity<Object> resultado = calificacionServicio.nuevaCalificaciones(calificacion);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCalificacionNoExistente() {
        Calificacion calificacion = new Calificacion();
        calificacion.setCaliId(1L);

        when(calificacionRespositorio.findById(calificacion.getCaliId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = calificacionServicio.actualizarCalificaciones(calificacion);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCalificacionExistente() {
        Calificacion calificacion = new Calificacion();
        calificacion.setCaliId(1L);

        when(calificacionRespositorio.findById(calificacion.getCaliId())).thenReturn(Optional.of(calificacion));
        when(calificacionRespositorio.save(calificacion)).thenReturn(calificacion);

        ResponseEntity<Object> resultado = calificacionServicio.actualizarCalificaciones(calificacion);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCalificacionNoExistente() {
        Long id = 1L;

        when(calificacionRespositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = calificacionServicio.eliminarCalificaciones(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCalificacionExistente() {
        Long id = 1L;

        when(calificacionRespositorio.existsById(id)).thenReturn(true);
        doNothing().when(calificacionRespositorio).deleteById(id);

        ResponseEntity<Object> resultado = calificacionServicio.eliminarCalificaciones(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCalificacionNoExistente() {
        Long id = 1L;

        when(calificacionRespositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = calificacionServicio.buscarCalificaciones(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCalificacionExistente() {
        Long id = 1L;
        Calificacion calificacion = new Calificacion();
        calificacion.setCaliId(id);

        when(calificacionRespositorio.findById(id)).thenReturn(Optional.of(calificacion));

        ResponseEntity<Object> resultado = calificacionServicio.buscarCalificaciones(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(calificacion, resultado.getBody());
    }
}

