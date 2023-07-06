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

import ec.edu.ups.sistemaeducativo.Models.PeriodoLectivo;
import ec.edu.ups.sistemaeducativo.Repositories.PeriodoLectivoRepositorio;
import ec.edu.ups.sistemaeducativo.Services.PeriodoLectivoServicio;

@ExtendWith(MockitoExtension.class)
public class PeriodoLectivoServicioTest {

    @InjectMocks
    private PeriodoLectivoServicio periodoLectivoServicio;

    @Mock
    private PeriodoLectivoRepositorio periodoLectivoRepositorio;

    @Test
    public void testGetPeriodoLectivos() {
        List<PeriodoLectivo> lista = new ArrayList<>();
        lista.add(new PeriodoLectivo());

        when(periodoLectivoRepositorio.findAll()).thenReturn(lista);

        List<PeriodoLectivo> resultado = periodoLectivoServicio.getPeriodoLectivos();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoPeriodoLectivoExistente() {
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();
        periodoLectivo.setPlId(1L);

        when(periodoLectivoRepositorio.findPeridiodoLectivobyId(periodoLectivo.getPlId())).thenReturn(Optional.of(periodoLectivo));

        ResponseEntity<Object> resultado = periodoLectivoServicio.nuevoPeriodoLectivo(periodoLectivo);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoPeriodoLectivoNuevo() {
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();
        periodoLectivo.setPlId(1L);

        when(periodoLectivoRepositorio.findPeridiodoLectivobyId(periodoLectivo.getPlId())).thenReturn(Optional.empty());
        when(periodoLectivoRepositorio.save(periodoLectivo)).thenReturn(periodoLectivo);

        ResponseEntity<Object> resultado = periodoLectivoServicio.nuevoPeriodoLectivo(periodoLectivo);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarPeriodoLectivoNoExistente() {
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();
        periodoLectivo.setPlId(1L);

        when(periodoLectivoRepositorio.findById(periodoLectivo.getPlId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = periodoLectivoServicio.actualizarPeriodoLectivo(periodoLectivo);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarPeriodoLectivoExistente() {
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();
        periodoLectivo.setPlId(1L);

        when(periodoLectivoRepositorio.findById(periodoLectivo.getPlId())).thenReturn(Optional.of(periodoLectivo));
        when(periodoLectivoRepositorio.save(periodoLectivo)).thenReturn(periodoLectivo);

        ResponseEntity<Object> resultado = periodoLectivoServicio.actualizarPeriodoLectivo(periodoLectivo);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarPeriodoLectivoNoExistente() {
        Long id = 1L;

        when(periodoLectivoRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = periodoLectivoServicio.eliminarPeriodoLectivo(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarPeriodoLectivoExistente() {
        Long id = 1L;

        when(periodoLectivoRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(periodoLectivoRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = periodoLectivoServicio.eliminarPeriodoLectivo(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarPeriodoLectivoNoExistente() {
        Long id = 1L;

        when(periodoLectivoRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = periodoLectivoServicio.buscarPeriodoLectivo(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarPeriodoLectivoExistente() {
        Long id = 1L;
        PeriodoLectivo periodoLectivo = new PeriodoLectivo();
        periodoLectivo.setPlId(id);

        when(periodoLectivoRepositorio.findById(id)).thenReturn(Optional.of(periodoLectivo));

        ResponseEntity<Object> resultado = periodoLectivoServicio.buscarPeriodoLectivo(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(periodoLectivo, resultado.getBody());
    }

}

