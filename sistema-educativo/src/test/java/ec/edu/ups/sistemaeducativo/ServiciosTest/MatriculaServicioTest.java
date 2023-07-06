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

import ec.edu.ups.sistemaeducativo.Models.Matricula;
import ec.edu.ups.sistemaeducativo.Repositories.MatriculaRepositorio;
import ec.edu.ups.sistemaeducativo.Services.MatriculaServicio;

@ExtendWith(MockitoExtension.class)
public class MatriculaServicioTest {

    @InjectMocks
    private MatriculaServicio matriculaServicio;

    @Mock
    private MatriculaRepositorio matriculaRepositorio;



    @Test
    public void testGetMatriculas() {
        List<Matricula> lista = new ArrayList<>();
        lista.add(new Matricula());

        when(matriculaRepositorio.findAll()).thenReturn(lista);

        List<Matricula> resultado = matriculaServicio.getMatriculas();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoMatriculaExistente() {
        Matricula matricula = new Matricula();
        matricula.setMat_id(1L);

        when(matriculaRepositorio.findById(matricula.getMat_id())).thenReturn(Optional.of(matricula));

        ResponseEntity<Object> resultado = matriculaServicio.nuevoMatricula(matricula);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoMatriculaNuevo() {
        Matricula matricula = new Matricula();
        matricula.setMat_id(1L);

        when(matriculaRepositorio.findById(matricula.getMat_id())).thenReturn(Optional.empty());
        when(matriculaRepositorio.save(matricula)).thenReturn(matricula);

        ResponseEntity<Object> resultado = matriculaServicio.nuevoMatricula(matricula);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarMatriculaNoExistente() {
        Matricula matricula = new Matricula();
        matricula.setMat_id(1L);

        when(matriculaRepositorio.findById(matricula.getMat_id())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = matriculaServicio.actualizarMatricula(matricula);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarMatriculaExistente() {
        Matricula matricula = new Matricula();
        matricula.setMat_id(1L);

        when(matriculaRepositorio.findById(matricula.getMat_id())).thenReturn(Optional.of(matricula));
        when(matriculaRepositorio.save(matricula)).thenReturn(matricula);

        ResponseEntity<Object> resultado = matriculaServicio.actualizarMatricula(matricula);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarMatriculaNoExistente() {
        Long id = 1L;

        when(matriculaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = matriculaServicio.eliminarMatricula(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarMatriculaExistente() {
        Long id = 1L;

        when(matriculaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(matriculaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = matriculaServicio.eliminarMatricula(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarMatriculaNoExistente() {
        Long id = 1L;

        when(matriculaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = matriculaServicio.buscarMatricula(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarMatriculaExistente() {
        Long id = 1L;
        Matricula matricula = new Matricula();
        matricula.setMat_id(id);

        when(matriculaRepositorio.findById(id)).thenReturn(Optional.of(matricula));

        ResponseEntity<Object> resultado = matriculaServicio.buscarMatricula(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(matricula, resultado.getBody());
    }
}

