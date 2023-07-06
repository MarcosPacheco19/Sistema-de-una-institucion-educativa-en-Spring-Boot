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

import ec.edu.ups.sistemaeducativo.Models.Horario;
import ec.edu.ups.sistemaeducativo.Repositories.HorarioRepositorio;
import ec.edu.ups.sistemaeducativo.Services.HorarioServicio;

@ExtendWith(MockitoExtension.class)
public class HorarioServicioTest {

    @InjectMocks
    private HorarioServicio horarioServicio;

    @Mock
    private HorarioRepositorio horarioRepositorio;


    @Test
    public void testGetHorario() {
        List<Horario> lista = new ArrayList<>();
        lista.add(new Horario());

        when(horarioRepositorio.findAll()).thenReturn(lista);

        List<Horario> resultado = horarioServicio.getHorario();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoHorarioExistente() {
        Horario horario = new Horario();
        horario.setHorId(1L);

        when(horarioRepositorio.findHorariobyId(horario.getHorId())).thenReturn(Optional.of(horario));

        ResponseEntity<Object> resultado = horarioServicio.nuevoHorario(horario);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoHorarioNuevo() {
        Horario horario = new Horario();
        horario.setHorId(1L);

        when(horarioRepositorio.findHorariobyId(horario.getHorId())).thenReturn(Optional.empty());
        when(horarioRepositorio.save(horario)).thenReturn(horario);

        ResponseEntity<Object> resultado = horarioServicio.nuevoHorario(horario);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarHorarioNoExistente() {
        Horario horario = new Horario();
        horario.setHorId(1L);

        when(horarioRepositorio.findById(horario.getHorId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = horarioServicio.actualizarHorario(horario);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarHorarioExistente() {
        Horario horario = new Horario();
        horario.setHorId(1L);

        when(horarioRepositorio.findById(horario.getHorId())).thenReturn(Optional.of(horario));
        when(horarioRepositorio.save(horario)).thenReturn(horario);

        ResponseEntity<Object> resultado = horarioServicio.actualizarHorario(horario);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarHorarioNoExistente() {
        Long id = 1L;

        when(horarioRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = horarioServicio.eliminarHorario(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarHorarioExistente() {
        Long id = 1L;

        when(horarioRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(horarioRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = horarioServicio.eliminarHorario(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarHorarioNoExistente() {
        Long id = 1L;

        when(horarioRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = horarioServicio.buscarHorario(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarHorarioExistente() {
        Long id = 1L;
        Horario horario = new Horario();
        horario.setHorId(id);

        when(horarioRepositorio.findById(id)).thenReturn(Optional.of(horario));

        ResponseEntity<Object> resultado = horarioServicio.buscarHorario(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(horario, resultado.getBody());
    }

}

