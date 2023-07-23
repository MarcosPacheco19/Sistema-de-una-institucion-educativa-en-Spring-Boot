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

import ec.edu.ups.sistemaeducativo.Models.CabeceraFactura;
import ec.edu.ups.sistemaeducativo.Repositories.CabeceraFacturaRepositorio;
import ec.edu.ups.sistemaeducativo.Services.CabeceraFacturaServicio;

@ExtendWith(MockitoExtension.class)
public class CabeceraFacturasServicioTest {

    @InjectMocks
    private CabeceraFacturaServicio cabeceraFacturaServicio;

    @Mock
    private CabeceraFacturaRepositorio cabeceraFacturaRepositorio;

    @Test
    public void testGetCabeceras() {
        List<CabeceraFactura> lista = new ArrayList<>();
        lista.add(new CabeceraFactura());

        when(cabeceraFacturaRepositorio.findAll()).thenReturn(lista);

        List<CabeceraFactura> resultado = cabeceraFacturaServicio.getCabeceras();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevaCabeceraExistente() {
        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        cabeceraFactura.setCabCorreo("test@test.com");

        when(cabeceraFacturaRepositorio.findCabeceraFacturaByCabCorreo(cabeceraFactura.getCabCorreo())).thenReturn(Optional.of(cabeceraFactura));

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.nuevaCabecera(cabeceraFactura);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevaCabeceraNueva() {
        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        cabeceraFactura.setCabCorreo("test@test.com");

        when(cabeceraFacturaRepositorio.findCabeceraFacturaByCabCorreo(cabeceraFactura.getCabCorreo())).thenReturn(Optional.empty());
        when(cabeceraFacturaRepositorio.save(cabeceraFactura)).thenReturn(cabeceraFactura);

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.nuevaCabecera(cabeceraFactura);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCabeceraFacturaNoExistente() {
        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        cabeceraFactura.setCabId(1L);

        when(cabeceraFacturaRepositorio.findById(cabeceraFactura.getCabId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.actualizarCabeceraFactura(cabeceraFactura);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCabeceraFacturaExistente() {
        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        cabeceraFactura.setCabId(1L);

        when(cabeceraFacturaRepositorio.findById(cabeceraFactura.getCabId())).thenReturn(Optional.of(cabeceraFactura));
        when(cabeceraFacturaRepositorio.save(cabeceraFactura)).thenReturn(cabeceraFactura);

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.actualizarCabeceraFactura(cabeceraFactura);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCabeceraFacturaNoExistente() {
        Long id = 1L;

        when(cabeceraFacturaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.eliminarCabeceraFactura(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCabeceraFacturaExistente() {
        Long id = 1L;

        when(cabeceraFacturaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(cabeceraFacturaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.eliminarCabeceraFactura(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCabeceraFacturaNoExistente() {
        Long id = 1L;

        when(cabeceraFacturaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.buscarCabeceraFactura(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCabeceraFacturaExistente() {
        Long id = 1L;
        CabeceraFactura cabeceraFactura = new CabeceraFactura();
        cabeceraFactura.setCabId(id);

        when(cabeceraFacturaRepositorio.findById(id)).thenReturn(Optional.of(cabeceraFactura));

        ResponseEntity<Object> resultado = cabeceraFacturaServicio.buscarCabeceraFactura(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(cabeceraFactura, resultado.getBody());
    }
}

