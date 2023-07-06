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

import ec.edu.ups.sistemaeducativo.Models.DetalleMatricula;
import ec.edu.ups.sistemaeducativo.Repositories.DetalleMatriculaRepositorio;
import ec.edu.ups.sistemaeducativo.Services.DetalleMatriculaServicio;

@ExtendWith(MockitoExtension.class)
public class DetalleMatriculaServicioTest {

    @InjectMocks
    private DetalleMatriculaServicio detalleMatriculaServicio;

    @Mock
    private DetalleMatriculaRepositorio detalleMatriculaRepositorio;

    @Test
    public void testGetDetalles() {
        List<DetalleMatricula> lista = new ArrayList<>();
        lista.add(new DetalleMatricula());

        when(detalleMatriculaRepositorio.findAll()).thenReturn(lista);

        List<DetalleMatricula> resultado = detalleMatriculaServicio.getDetalles();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoDetalleMatriculaExistente() {
        DetalleMatricula detalleMatricula = new DetalleMatricula();
        detalleMatricula.setTipoMatricula("tipo1");

        when(detalleMatriculaRepositorio.findDetalleMatriculaByTipoMatricula(detalleMatricula.getTipoMatricula())).thenReturn(Optional.of(detalleMatricula));

        ResponseEntity<Object> resultado = detalleMatriculaServicio.nuevoDetalleMatricula(detalleMatricula);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoDetalleMatriculaNuevo() {
        DetalleMatricula detalleMatricula = new DetalleMatricula();
        detalleMatricula.setTipoMatricula("tipo1");

        when(detalleMatriculaRepositorio.findDetalleMatriculaByTipoMatricula(detalleMatricula.getTipoMatricula())).thenReturn(Optional.empty());
        when(detalleMatriculaRepositorio.save(detalleMatricula)).thenReturn(detalleMatricula);

        ResponseEntity<Object> resultado = detalleMatriculaServicio.nuevoDetalleMatricula(detalleMatricula);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarDetalleMatriculaNoExistente() {
        DetalleMatricula detalleMatricula = new DetalleMatricula();
        detalleMatricula.setDetMatId(1L);

        when(detalleMatriculaRepositorio.findById(detalleMatricula.getDetMatId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = detalleMatriculaServicio.actualizarDetalleMatricula(detalleMatricula);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarDetalleMatriculaExistente() {
        DetalleMatricula detalleMatricula = new DetalleMatricula();
        detalleMatricula.setDetMatId(1L);

        when(detalleMatriculaRepositorio.findById(detalleMatricula.getDetMatId())).thenReturn(Optional.of(detalleMatricula));
        when(detalleMatriculaRepositorio.save(detalleMatricula)).thenReturn(detalleMatricula);

        ResponseEntity<Object> resultado = detalleMatriculaServicio.actualizarDetalleMatricula(detalleMatricula);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarDetalleMatriculaNoExistente() {
        Long id = 1L;

        when(detalleMatriculaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = detalleMatriculaServicio.eliminarDetalleMatricula(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarDetalleMatriculaExistente() {
        Long id = 1L;

        when(detalleMatriculaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(detalleMatriculaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = detalleMatriculaServicio.eliminarDetalleMatricula(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarDetalleMatriculaNoExistente() {
        Long id = 1L;

        when(detalleMatriculaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = detalleMatriculaServicio.buscarDetalleMatricula(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarDetalleMatriculaExistente() {
        Long id = 1L;
        DetalleMatricula detalleMatricula = new DetalleMatricula();
        detalleMatricula.setDetMatId(id);

        when(detalleMatriculaRepositorio.findById(id)).thenReturn(Optional.of(detalleMatricula));

        ResponseEntity<Object> resultado = detalleMatriculaServicio.buscarDetalleMatricula(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(detalleMatricula, resultado.getBody());
    }
}

