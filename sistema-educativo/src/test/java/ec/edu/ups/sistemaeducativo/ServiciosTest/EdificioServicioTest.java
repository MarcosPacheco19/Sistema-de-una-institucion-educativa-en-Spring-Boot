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

import ec.edu.ups.sistemaeducativo.Models.Edificio;
import ec.edu.ups.sistemaeducativo.Repositories.EdificioRepositrio;
import ec.edu.ups.sistemaeducativo.Services.EdificioServicio;

@ExtendWith(MockitoExtension.class)
public class EdificioServicioTest {

    @InjectMocks
    private EdificioServicio edificioServicio;

    @Mock
    private EdificioRepositrio edificioRepositrio;

    @Test
    public void testGetEdificio() {
        List<Edificio> lista = new ArrayList<>();
        lista.add(new Edificio());

        when(edificioRepositrio.findAll()).thenReturn(lista);

        List<Edificio> resultado = edificioServicio.getEdificio();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoEdificioExistente() {
        Edificio edificio = new Edificio();
        edificio.setEdiId(1L);

        when(edificioRepositrio.findEdificiobyId(edificio.getEdiId())).thenReturn(Optional.of(edificio));

        ResponseEntity<Object> resultado = edificioServicio.nuevoEdificio(edificio);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoEdificioNuevo() {
        Edificio edificio = new Edificio();
        edificio.setEdiId(1L);

        when(edificioRepositrio.findEdificiobyId(edificio.getEdiId())).thenReturn(Optional.empty());
        when(edificioRepositrio.save(edificio)).thenReturn(edificio);

        ResponseEntity<Object> resultado = edificioServicio.nuevoEdificio(edificio);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarEdificioNoExistente() {
        Edificio edificio = new Edificio();
        edificio.setEdiId(1L);

        when(edificioRepositrio.findById(edificio.getEdiId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = edificioServicio.actualizarEdificio(edificio);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarEdificioExistente() {
        Edificio edificio = new Edificio();
        edificio.setEdiId(1L);

        when(edificioRepositrio.findById(edificio.getEdiId())).thenReturn(Optional.of(edificio));
        when(edificioRepositrio.save(edificio)).thenReturn(edificio);

        ResponseEntity<Object> resultado = edificioServicio.actualizarEdificio(edificio);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarEdificioNoExistente() {
        Long id = 1L;

        when(edificioRepositrio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = edificioServicio.eliminarEdificio(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarEdificioExistente() {
        Long id = 1L;

        when(edificioRepositrio.existsById(id)).thenReturn(true);
        doNothing().when(edificioRepositrio).deleteById(id);

        ResponseEntity<Object> resultado = edificioServicio.eliminarEdificio(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarEdificioNoExistente() {
        Long id = 1L;

        when(edificioRepositrio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = edificioServicio.buscarEdificio(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarEdificioExistente() {
        Long id = 1L;
        Edificio edificio = new Edificio();
        edificio.setEdiId(id);

        when(edificioRepositrio.findById(id)).thenReturn(Optional.of(edificio));

        ResponseEntity<Object> resultado = edificioServicio.buscarEdificio(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(edificio, resultado.getBody());
    }
}
