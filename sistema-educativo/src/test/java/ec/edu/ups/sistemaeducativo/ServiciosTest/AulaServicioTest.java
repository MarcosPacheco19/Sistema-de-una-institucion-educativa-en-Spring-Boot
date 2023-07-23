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

import ec.edu.ups.sistemaeducativo.Models.Aulas;
import ec.edu.ups.sistemaeducativo.Repositories.AulasRepositorio;
import ec.edu.ups.sistemaeducativo.Services.AulasServicio;

@ExtendWith(MockitoExtension.class)
public class AulaServicioTest {

    @InjectMocks
    private AulasServicio aulaServicio;

    @Mock
    private AulasRepositorio aulaRepositorio;
    @Test
    public void testGetAulas() {
        List<Aulas> lista = new ArrayList<>();
        lista.add(new Aulas());

        when(aulaRepositorio.findAll()).thenReturn(lista);

        List<Aulas> resultado = aulaServicio.getAulas();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevaAulaExistente() {
        Aulas aulas = new Aulas();
        aulas.setAulId(1L);

        when(aulaRepositorio.findAulasByAulId(aulas.getAulId())).thenReturn(Optional.of(aulas));

        ResponseEntity<Object> resultado = aulaServicio.nuevaAula(aulas);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevaAulaNueva() {
        Aulas aulas = new Aulas();
        aulas.setAulId(1L);

        when(aulaRepositorio.findAulasByAulId(aulas.getAulId())).thenReturn(Optional.empty());
        when(aulaRepositorio.save(aulas)).thenReturn(aulas);

        ResponseEntity<Object> resultado = aulaServicio.nuevaAula(aulas);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarAulaNoExistente() {
        Aulas aulas = new Aulas();
        aulas.setAulId(1L);

        when(aulaRepositorio.findById(aulas.getAulId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = aulaServicio.actualizarAula(aulas);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarAulaExistente() {
        Aulas aulas = new Aulas();
        aulas.setAulId(1L);

        when(aulaRepositorio.findById(aulas.getAulId())).thenReturn(Optional.of(aulas));
        when(aulaRepositorio.save(aulas)).thenReturn(aulas);

        ResponseEntity<Object> resultado = aulaServicio.actualizarAula(aulas);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarAulaNoExistente() {
        Long id = 1L;

        when(aulaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = aulaServicio.eliminarAula(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarAulaExistente() {
        Long id = 1L;

        when(aulaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(aulaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = aulaServicio.eliminarAula(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarAulaNoExistente() {
        Long id = 1L;

        when(aulaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = aulaServicio.buscarAula(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarAulaExistente() {
        Long id = 1L;
        Aulas aulas = new Aulas();
        aulas.setAulId(id);

        when(aulaRepositorio.findById(id)).thenReturn(Optional.of(aulas));

        ResponseEntity<Object> resultado = aulaServicio.buscarAula(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(aulas, resultado.getBody());
    }
}

