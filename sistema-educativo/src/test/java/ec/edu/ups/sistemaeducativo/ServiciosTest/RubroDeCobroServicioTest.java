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

import ec.edu.ups.sistemaeducativo.Models.RubroDeCobro;
import ec.edu.ups.sistemaeducativo.Repositories.RubroDeCobroRepositorio;
import ec.edu.ups.sistemaeducativo.Services.RubroDeCobroServicio;

@ExtendWith(MockitoExtension.class)
public class RubroDeCobroServicioTest {

    @InjectMocks
    private RubroDeCobroServicio rubroDeCobroServicio;

    @Mock
    private RubroDeCobroRepositorio rubroDeCobroRepositorio;

    @Test
    public void testGetRubroDeCobros() {
        List<RubroDeCobro> lista = new ArrayList<>();
        lista.add(new RubroDeCobro());

        when(rubroDeCobroRepositorio.findAll()).thenReturn(lista);

        List<RubroDeCobro> resultado = rubroDeCobroServicio.getRubroDeCobros();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoRubroDeCobroExistente() {
        RubroDeCobro rubro = new RubroDeCobro();
        rubro.setAdmTipoDePago("tipo1");

        when(rubroDeCobroRepositorio.findRubroDeCobroByAdmTipoDePago(rubro.getAdmTipoDePago())).thenReturn(Optional.of(rubro));

        ResponseEntity<Object> resultado = rubroDeCobroServicio.nuevoRubroDeCobro(rubro);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoRubroDeCobroNuevo() {
        RubroDeCobro rubro = new RubroDeCobro();
        rubro.setAdmTipoDePago("tipo1");

        when(rubroDeCobroRepositorio.findRubroDeCobroByAdmTipoDePago(rubro.getAdmTipoDePago())).thenReturn(Optional.empty());
        when(rubroDeCobroRepositorio.save(rubro)).thenReturn(rubro);

        ResponseEntity<Object> resultado = rubroDeCobroServicio.nuevoRubroDeCobro(rubro);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarRubroDeCobroNoExistente() {
        RubroDeCobro rubro = new RubroDeCobro();
        rubro.setAdmId(1L);

        when(rubroDeCobroRepositorio.findById(rubro.getAdmId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = rubroDeCobroServicio.actualizarRubroDeCobro(rubro);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarRubroDeCobroExistente() {
        RubroDeCobro rubro = new RubroDeCobro();
        rubro.setAdmId(1L);

        when(rubroDeCobroRepositorio.findById(rubro.getAdmId())).thenReturn(Optional.of(rubro));
        when(rubroDeCobroRepositorio.save(rubro)).thenReturn(rubro);

        ResponseEntity<Object> resultado = rubroDeCobroServicio.actualizarRubroDeCobro(rubro);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarRubroDeCobroNoExistente() {
        Long id = 1L;

        when(rubroDeCobroRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = rubroDeCobroServicio.eliminarRubroDeCobro(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarRubroDeCobroExistente() {
        Long id = 1L;

        when(rubroDeCobroRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(rubroDeCobroRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = rubroDeCobroServicio.eliminarRubroDeCobro(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarRubroDeCobroNoExistente() {
        Long id = 1L;

        when(rubroDeCobroRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = rubroDeCobroServicio.buscarRubroDeCobro(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarRubroDeCobroExistente() {
        Long id = 1L;
        RubroDeCobro rubro = new RubroDeCobro();
        rubro.setAdmId(id);

        when(rubroDeCobroRepositorio.findById(id)).thenReturn(Optional.of(rubro));

        ResponseEntity<Object> resultado = rubroDeCobroServicio.buscarRubroDeCobro(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(rubro, resultado.getBody());
    }
}

