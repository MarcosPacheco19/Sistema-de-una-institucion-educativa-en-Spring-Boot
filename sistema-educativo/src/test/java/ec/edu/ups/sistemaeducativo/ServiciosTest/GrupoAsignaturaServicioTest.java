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

import ec.edu.ups.sistemaeducativo.Models.GrupoAsignatura;
import ec.edu.ups.sistemaeducativo.Repositories.GrupoAsignaturaRepositorio;
import ec.edu.ups.sistemaeducativo.Services.GrupoAsignaturaServicio;

@ExtendWith(MockitoExtension.class)
public class GrupoAsignaturaServicioTest {

    @InjectMocks
    private GrupoAsignaturaServicio grupoAsignaturaServicio;

    @Mock
    private GrupoAsignaturaRepositorio grupoAsignaturaRepositorio;

    @Test
    public void testGetGruposAsignaturas() {
        List<GrupoAsignatura> lista = new ArrayList<>();
        lista.add(new GrupoAsignatura());

        when(grupoAsignaturaRepositorio.findAll()).thenReturn(lista);

        List<GrupoAsignatura> resultado = grupoAsignaturaServicio.getGruposAsignaturas();

        assertEquals(1, resultado.size());
    }

    @Test
    public void testNuevoGrupoAsignaturaExistente() {
        GrupoAsignatura grupoAsignatura = new GrupoAsignatura();
        grupoAsignatura.setGrupoAcademino("Grupo Académico");

        when(grupoAsignaturaRepositorio.findGrupoAsignaturaByGrupo(grupoAsignatura.getGrupoAcademino())).thenReturn(Optional.of(grupoAsignatura));

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.nuevoGrupoAsignatura(grupoAsignatura);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testNuevoGrupoAsignaturaNuevo() {
        GrupoAsignatura grupoAsignatura = new GrupoAsignatura();
        grupoAsignatura.setGrupoAcademino("Grupo Académico");

        when(grupoAsignaturaRepositorio.findGrupoAsignaturaByGrupo(grupoAsignatura.getGrupoAcademino())).thenReturn(Optional.empty());
        when(grupoAsignaturaRepositorio.save(grupoAsignatura)).thenReturn(grupoAsignatura);

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.nuevoGrupoAsignatura(grupoAsignatura);

        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCarreraNoExistente() {
        GrupoAsignatura grupoAsignatura = new GrupoAsignatura();
        grupoAsignatura.setGrpId(1L);

        when(grupoAsignaturaRepositorio.findById(grupoAsignatura.getGrpId())).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.actualizarCarrera(grupoAsignatura);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testActualizarCarreraExistente() {
        GrupoAsignatura grupoAsignatura = new GrupoAsignatura();
        grupoAsignatura.setGrpId(1L);

        when(grupoAsignaturaRepositorio.findById(grupoAsignatura.getGrpId())).thenReturn(Optional.of(grupoAsignatura));
        when(grupoAsignaturaRepositorio.save(grupoAsignatura)).thenReturn(grupoAsignatura);

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.actualizarCarrera(grupoAsignatura);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCarreraNoExistente() {
        Long id = 1L;

        when(grupoAsignaturaRepositorio.existsById(id)).thenReturn(false);

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.eliminarCarrera(id);

        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
    }

    @Test
    public void testEliminarCarreraExistente() {
        Long id = 1L;

        when(grupoAsignaturaRepositorio.existsById(id)).thenReturn(true);
        doNothing().when(grupoAsignaturaRepositorio).deleteById(id);

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.eliminarCarrera(id);

        assertEquals(HttpStatus.ACCEPTED, resultado.getStatusCode());
    }

    @Test
    public void testBuscarCarreraNoExistente() {
        Long id = 1L;

        when(grupoAsignaturaRepositorio.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Object> resultado = grupoAsignaturaServicio.buscarCarrera(id);

        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }
}

