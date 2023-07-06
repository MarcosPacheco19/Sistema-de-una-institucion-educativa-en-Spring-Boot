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

import ec.edu.ups.sistemaeducativo.Models.Asignatura;
import ec.edu.ups.sistemaeducativo.Repositories.AsignaturaRepositorio;
import ec.edu.ups.sistemaeducativo.Services.AsignaturaServicio;

@ExtendWith(MockitoExtension.class)
public class AsignaturaServicioTest {
    @InjectMocks
    private AsignaturaServicio asignaturaServicio;

    @Mock
    private AsignaturaRepositorio asignaturaRepositorio;

    @Test
    public void testGetAsignaturas() {
        List<Asignatura> lista = new ArrayList<>();
        lista.add(new Asignatura());

        when(asignaturaRepositorio.findAll()).thenReturn(lista);

        List<Asignatura> resultado = asignaturaServicio.getAsignaturas();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoAsignaturaExistente() {
        Asignatura asignatura = new Asignatura();
        asignatura.setAsigNombre("Matemáticas");

        when(asignaturaRepositorio.findAsignaturaByNombre(asignatura.getAsigNombre())).thenReturn(Optional.of(asignatura));

        ResponseEntity<Object> resultado = asignaturaServicio.nuevoAsignatura(asignatura);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoAsignaturaNuevo() {
        Asignatura asignatura = new Asignatura();
        asignatura.setAsigNombre("Matemáticas");

        when(asignaturaRepositorio.findAsignaturaByNombre(asignatura.getAsigNombre())).thenReturn(Optional.empty());
        when(asignaturaRepositorio.save(asignatura)).thenReturn(asignatura);

        ResponseEntity<Object> resultado = asignaturaServicio.nuevoAsignatura(asignatura);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarAsignaturaNoExistente() {
        Asignatura asignatura = new Asignatura();
        asignatura.setAsigId(1L);

        when(asignaturaRepositorio.findById(asignatura.getAsigId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = asignaturaServicio.actualizarAsignatura(asignatura);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarAsignaturaExistente() {
        Asignatura asignatura = new Asignatura();
        asignatura.setAsigId(1L);

        when(asignaturaRepositorio.findById(asignatura.getAsigId())).thenReturn(Optional.of(asignatura));
        when(asignaturaRepositorio.save(asignatura)).thenReturn(asignatura);

        ResponseEntity<Object> resultado = asignaturaServicio.actualizarAsignatura(asignatura);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarAsignaturaNoExistente() {
        Long id = 1L;

        when(asignaturaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = asignaturaServicio.eliminarAsignatura(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarAsignaturaExistente() {
        Long id = 1L;

        when(asignaturaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(asignaturaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = asignaturaServicio.eliminarAsignatura(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarAsignaturaNoExistente() {
        Long id = 1L;

        when(asignaturaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = asignaturaServicio.buscarAsignatura(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarAsignaturaExistente() {
        Long id = 1L;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsigId(id);

        when(asignaturaRepositorio.findById(id)).thenReturn(Optional.of(asignatura));

        ResponseEntity<Object> resultado = asignaturaServicio.buscarAsignatura(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(asignatura, resultado.getBody());
    }
}
