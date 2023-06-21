package ec.edu.ups.sistemaeducativo.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ec.edu.ups.sistemaeducativo.Models.Estudiante;
import ec.edu.ups.sistemaeducativo.Repositories.EstudianteRepositorio;
import ec.edu.ups.sistemaeducativo.Services.EstudianteServicio;

public class EstudianteServicioTest {
    
    @Mock
    private EstudianteRepositorio estudianteRepositorio;

    @InjectMocks
    private EstudianteServicio estudianteServicio;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>(); 
        estudiantes.add(new Estudiante());
        
        when(estudianteRepositorio.findAll()).thenReturn(estudiantes);

        List<Estudiante> resultado = estudianteServicio.getEstudiantes();

        verify(estudianteRepositorio).findAll();
        assertEquals(estudiantes, resultado);
    }

}
