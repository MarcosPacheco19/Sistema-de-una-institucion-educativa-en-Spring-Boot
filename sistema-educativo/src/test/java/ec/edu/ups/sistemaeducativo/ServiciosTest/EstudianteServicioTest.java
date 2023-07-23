package ec.edu.ups.sistemaeducativo.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import ec.edu.ups.sistemaeducativo.Models.Estudiante;
import ec.edu.ups.sistemaeducativo.Repositories.EstudianteRepositorio;
import ec.edu.ups.sistemaeducativo.Services.EstudianteServicio;

@ExtendWith(MockitoExtension.class)
public class EstudianteServicioTest {
    
    @Mock
    private EstudianteRepositorio estudianteRepositorio;

    @InjectMocks
    private EstudianteServicio estudianteServicio;
    
    @Test
    public void testGetEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>(); 
        estudiantes.add(new Estudiante());
        
        when(estudianteRepositorio.findAll()).thenReturn(estudiantes);

        List<Estudiante> resultado = estudianteServicio.getEstudiantes();

        verify(estudianteRepositorio).findAll();
        assertEquals(estudiantes, resultado);
    }

    @Test
    public void testNuevoEstudianteExistente() {
        Estudiante estudiante = new Estudiante();
        estudiante.setUsuCedula("1234567890");

        when(estudianteRepositorio.findEstudianteByUsuCedula(estudiante.getUsuCedula())).thenReturn(Optional.of(estudiante));

        ResponseEntity<Object> resultado = estudianteServicio.nuevoEstudiante(estudiante);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoEstudianteNuevo() {
        Estudiante estudiante = new Estudiante();
        estudiante.setUsuCedula("1234567890");

        when(estudianteRepositorio.findEstudianteByUsuCedula(estudiante.getUsuCedula())).thenReturn(Optional.empty());
        when(estudianteRepositorio.save(estudiante)).thenReturn(estudiante);

        ResponseEntity<Object> resultado = estudianteServicio.nuevoEstudiante(estudiante);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarEstudianteNoExistente() {
        Estudiante estudiante = new Estudiante();
        estudiante.setUsuId(1L);

        when(estudianteRepositorio.findById(estudiante.getUsuId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = estudianteServicio.actualizarEstudiante(estudiante);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarEstudianteExistente() {
        Estudiante estudiante = new Estudiante();
        estudiante.setUsuId(1L);

        when(estudianteRepositorio.findById(estudiante.getUsuId())).thenReturn(Optional.of(estudiante));
        when(estudianteRepositorio.save(estudiante)).thenReturn(estudiante);

        ResponseEntity<Object> resultado = estudianteServicio.actualizarEstudiante(estudiante);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarEstudianteNoExistente() {
        Long id = 1L;

        when(estudianteRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = estudianteServicio.eliminarEstudiante(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarEstudianteExistente() {
        Long id = 1L;

        when(estudianteRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(estudianteRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = estudianteServicio.eliminarEstudiante(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarEstudianteNoExistente() {
        Long id = 1L;

        when(estudianteRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = estudianteServicio.buscarEstudiante(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarEstudianteExistente() {
        Long id = 1L;
        Estudiante estudiante = new Estudiante();
        estudiante.setUsuId(id);

        when(estudianteRepositorio.findById(id)).thenReturn(Optional.of(estudiante));

        ResponseEntity<Object> resultado = estudianteServicio.buscarEstudiante(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(estudiante, resultado.getBody());
    }

}
