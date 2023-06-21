package ec.edu.ups.sistemaeducativo.ServicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ec.edu.ups.sistemaeducativo.Models.Estudiante;
import ec.edu.ups.sistemaeducativo.Repositories.EstudianteRepositorio;
import ec.edu.ups.sistemaeducativo.Services.EstudianteServicio;

@DataJpaTest
public class EstudianteServicioTest {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

	private EstudianteServicio estudianteServicio;

    @BeforeEach
	public void setup() {
		estudianteRepositorio = mock(EstudianteRepositorio.class);
		estudianteServicio = new EstudianteServicio(estudianteRepositorio);
	}

    @Test
    void testGetEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(new Estudiante());
		when(estudianteRepositorio.findAll()).thenReturn(estudiantes);

		List<Estudiante> result = estudianteServicio.getEstudiantes();

		assertEquals(1, result.size());
    }
}
