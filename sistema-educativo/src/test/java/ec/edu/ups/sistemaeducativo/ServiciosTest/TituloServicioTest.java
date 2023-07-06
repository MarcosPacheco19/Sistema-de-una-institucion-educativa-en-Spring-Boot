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

import ec.edu.ups.sistemaeducativo.Models.Titulo;
import ec.edu.ups.sistemaeducativo.Repositories.TituloRepositorio;
import ec.edu.ups.sistemaeducativo.Services.TituloServicio;

@ExtendWith(MockitoExtension.class)
public class TituloServicioTest {

    @InjectMocks
    private TituloServicio tituloServicio;

    @Mock
    private TituloRepositorio tituloRepositorio;

    @Test
    public void testGetTitulos() {
        List<Titulo> lista = new ArrayList<>();
        lista.add(new Titulo());

        when(tituloRepositorio.findAll()).thenReturn(lista);

        List<Titulo> resultado = tituloServicio.getTitulos();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoTituloExistente() {
        Titulo titulo = new Titulo();
        titulo.setTitnombre("titulo1");

        when(tituloRepositorio.findTituloByNombre(titulo.getTitnombre())).thenReturn(Optional.of(titulo));

        ResponseEntity<Object> resultado = tituloServicio.nuevoTitulo(titulo);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoTituloNuevo() {
        Titulo titulo = new Titulo();
        titulo.setTitnombre("titulo1");

        when(tituloRepositorio.findTituloByNombre(titulo.getTitnombre())).thenReturn(Optional.empty());
        when(tituloRepositorio.save(titulo)).thenReturn(titulo);

        ResponseEntity<Object> resultado = tituloServicio.nuevoTitulo(titulo);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarTituloNoExistente() {
        Titulo titulo = new Titulo();
        titulo.setTitId(1L);

        when(tituloRepositorio.findById(titulo.getTitId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = tituloServicio.actualizarTitulo(titulo);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarTituloExistente() {
        Titulo titulo = new Titulo();
        titulo.setTitId(1L);

        when(tituloRepositorio.findById(titulo.getTitId())).thenReturn(Optional.of(titulo));
        when(tituloRepositorio.save(titulo)).thenReturn(titulo);

        ResponseEntity<Object> resultado = tituloServicio.actualizarTitulo(titulo);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarTituloNoExistente() {
        Long id = 1L;

        when(tituloRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = tituloServicio.eliminarTitulo(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarTituloExistente() {
        Long id = 1L;

        when(tituloRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(tituloRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = tituloServicio.eliminarTitulo(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarTituloNoExistente() {
        Long id = 1L;

        when(tituloRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = tituloServicio.buscarTitulo(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarTituloExistente() {
        Long id = 1L;
        Titulo titulo = new Titulo();
        titulo.setTitId(id);

        when(tituloRepositorio.findById(id)).thenReturn(Optional.of(titulo));

        ResponseEntity<Object> resultado = tituloServicio.buscarTitulo(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(titulo, resultado.getBody());
    }
}

