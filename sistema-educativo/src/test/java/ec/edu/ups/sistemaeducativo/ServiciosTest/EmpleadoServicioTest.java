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

import ec.edu.ups.sistemaeducativo.Models.Empleado;
import ec.edu.ups.sistemaeducativo.Repositories.EmpleadoRepositorio;
import ec.edu.ups.sistemaeducativo.Services.EmpleadoServicio;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServicioTest {

    @InjectMocks
    private EmpleadoServicio empleadoServicio;

    @Mock
    private EmpleadoRepositorio empleadoRepositorio;

    @Test
    public void testGetEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        lista.add(new Empleado());

        when(empleadoRepositorio.findAll()).thenReturn(lista);

        List<Empleado> resultado = empleadoServicio.getEmpleados();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoEmpleadoExistente() {
        Empleado empleado = new Empleado();
        empleado.setUsuCedula("1234567890");

        when(empleadoRepositorio.findEmpleadoByAreaTrabajo(empleado.getUsuCedula())).thenReturn(Optional.of(empleado));

        ResponseEntity<Object> resultado = empleadoServicio.nuevoEmpleado(empleado);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoEmpleadoNuevo() {
        Empleado empleado = new Empleado();
        empleado.setUsuCedula("1234567890");

        when(empleadoRepositorio.findEmpleadoByAreaTrabajo(empleado.getUsuCedula())).thenReturn(Optional.empty());
        when(empleadoRepositorio.save(empleado)).thenReturn(empleado);

        ResponseEntity<Object> resultado = empleadoServicio.nuevoEmpleado(empleado);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarEmpleadoNoExistente() {
        Empleado empleado = new Empleado();
        empleado.setEmpId(1L);

        when(empleadoRepositorio.findById(empleado.getEmpId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = empleadoServicio.actualizarEmpleado(empleado);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarEmpleadoExistente() {
        Empleado empleado = new Empleado();
        empleado.setEmpId(1L);

        when(empleadoRepositorio.findById(empleado.getEmpId())).thenReturn(Optional.of(empleado));
        when(empleadoRepositorio.save(empleado)).thenReturn(empleado);

        ResponseEntity<Object> resultado = empleadoServicio.actualizarEmpleado(empleado);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarEmpleadoNoExistente() {
        Long id = 1L;

        when(empleadoRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = empleadoServicio.eliminarEmpleado(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarEmpleadoExistente() {
        Long id = 1L;

        when(empleadoRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(empleadoRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = empleadoServicio.eliminarEmpleado(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarEmpleadoNoExistente() {
        Long id = 1L;

        when(empleadoRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = empleadoServicio.buscarEmpleado(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testBuscarEmpleadoExistente() {
        Long id = 1L;
        Empleado empleado = new Empleado();
        empleado.setEmpId(id);

        when(empleadoRepositorio.findById(id)).thenReturn(Optional.of(empleado));

        ResponseEntity<Object> resultado = empleadoServicio.buscarEmpleado(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(empleado, resultado.getBody());
    }
}
