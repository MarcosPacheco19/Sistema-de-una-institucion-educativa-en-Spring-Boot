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

import ec.edu.ups.sistemaeducativo.Models.DetalleFactura;
import ec.edu.ups.sistemaeducativo.Repositories.DetalleFacturaRepositorio;
import ec.edu.ups.sistemaeducativo.Services.DetalleFacturaServicio;

@ExtendWith(MockitoExtension.class)
public class DetalleFacturaServicioTest {

    @InjectMocks
    private DetalleFacturaServicio detalleFacturaServicio;

    @Mock
    private DetalleFacturaRepositorio detalleFacturaRepositorio;


    @Test
    public void testGetDetalles() {
        List<DetalleFactura> lista = new ArrayList<>();
        lista.add(new DetalleFactura());

        when(detalleFacturaRepositorio.findAll()).thenReturn(lista);

        List<DetalleFactura> resultado = detalleFacturaServicio.getDetalles();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoDetalleFacturaExistente() {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetDescripcion("Detalle existente");

        when(detalleFacturaRepositorio.findDetallePorDescripcion(detalleFactura.getDetDescripcion())).thenReturn(Optional.of(detalleFactura));

        ResponseEntity<Object> resultado = detalleFacturaServicio.nuevoDetalleFactura(detalleFactura);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoDetalleFacturaNuevo() {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetDescripcion("Detalle nuevo");

        when(detalleFacturaRepositorio.findDetallePorDescripcion(detalleFactura.getDetDescripcion())).thenReturn(Optional.empty());
        when(detalleFacturaRepositorio.save(detalleFactura)).thenReturn(detalleFactura);

        ResponseEntity<Object> resultado = detalleFacturaServicio.nuevoDetalleFactura(detalleFactura);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarDetalleFacturaNoExistente() {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetId(1L);

        when(detalleFacturaRepositorio.findById(detalleFactura.getDetId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = detalleFacturaServicio.actualizarDetalleFactura(detalleFactura);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarDetalleFacturaExistente() {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetId(1L);

        when(detalleFacturaRepositorio.findById(detalleFactura.getDetId())).thenReturn(Optional.of(detalleFactura));
        when(detalleFacturaRepositorio.save(detalleFactura)).thenReturn(detalleFactura);

        ResponseEntity<Object> resultado = detalleFacturaServicio.actualizarDetalleFactura(detalleFactura);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarDetalleFacturaNoExistente() {
        Long id = 1L;

        when(detalleFacturaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = detalleFacturaServicio.eliminarDetalleFactura(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarDetalleFacturaExistente() {
        Long id = 1L;

        when(detalleFacturaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(detalleFacturaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = detalleFacturaServicio.eliminarDetalleFactura(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarDetalleFacturaNoExistente() {
        Long id = 1L;

        when(detalleFacturaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = detalleFacturaServicio.buscarDetalleFactura(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarDetalleFacturaExistente() {
        Long id = 1L;
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setDetId(id);

        when(detalleFacturaRepositorio.findById(id)).thenReturn(Optional.of(detalleFactura));

        ResponseEntity<Object> resultado = detalleFacturaServicio.buscarDetalleFactura(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(detalleFactura, resultado.getBody());
    }
}

