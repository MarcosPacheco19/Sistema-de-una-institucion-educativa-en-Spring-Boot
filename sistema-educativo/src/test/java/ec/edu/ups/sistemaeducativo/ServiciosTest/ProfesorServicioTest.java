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

import ec.edu.ups.sistemaeducativo.Models.Profesor;
import ec.edu.ups.sistemaeducativo.Repositories.ProfesorRepositorio;
import ec.edu.ups.sistemaeducativo.Services.ProfesorServicio;

@ExtendWith(MockitoExtension.class)
public class ProfesorServicioTest {

    @InjectMocks
    private ProfesorServicio profesorServicio;

    @Mock
    private ProfesorRepositorio profesorRepositorio;

    @Test
    public void testGetProfesores() {
        List<Profesor> lista = new ArrayList<>();
        lista.add(new Profesor());

        when(profesorRepositorio.findAll()).thenReturn(lista);

        List<Profesor> resultado = profesorServicio.getProfesores();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoProfesorExistente() {
        Profesor profesor = new Profesor();
        profesor.setUsuCedula("1234567890");

        when(profesorRepositorio.findProfesorByCedula(profesor.getUsuCedula())).thenReturn(Optional.of(profesor));

        ResponseEntity<Object> resultado = profesorServicio.nuevoProfesor(profesor);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoProfesorNuevo() {
        Profesor profesor = new Profesor();
        profesor.setUsuCedula("1234567890");

        when(profesorRepositorio.findProfesorByCedula(profesor.getUsuCedula())).thenReturn(Optional.empty());
        when(profesorRepositorio.save(profesor)).thenReturn(profesor);

        ResponseEntity<Object> resultado = profesorServicio.nuevoProfesor(profesor);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarProfesorNoExistente() {
        Profesor profesor = new Profesor();
        profesor.setProId(1L);

        when(profesorRepositorio.findById(profesor.getProId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = profesorServicio.actualizarProfesor(profesor);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarProfesorExistente() {
        Profesor profesor = new Profesor();
        profesor.setProId(1L);

        when(profesorRepositorio.findById(profesor.getProId())).thenReturn(Optional.of(profesor));
        when(profesorRepositorio.save(profesor)).thenReturn(profesor);

        ResponseEntity<Object> resultado = profesorServicio.actualizarProfesor(profesor);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarProfesorNoExistente() {
        Long id = 1L;

        when(profesorRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = profesorServicio.eliminarProfesor(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarProfesorExistente() {
        Long id = 1L;

        when(profesorRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(profesorRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = profesorServicio.eliminarProfesor(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarProfesorNoExistente() {
        Long id = 1L;

        when(profesorRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = profesorServicio.buscarProfesor(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarProfesorExistente() {
        Long id = 1L;
        Profesor profesor = new Profesor();
        profesor.setProId(id);

        when(profesorRepositorio.findById(id)).thenReturn(Optional.of(profesor));

        ResponseEntity<Object> resultado = profesorServicio.buscarProfesor(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(profesor, resultado.getBody());
    }

}
