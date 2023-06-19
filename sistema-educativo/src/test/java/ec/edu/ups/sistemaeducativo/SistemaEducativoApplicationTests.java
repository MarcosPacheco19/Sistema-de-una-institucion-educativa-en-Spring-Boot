package ec.edu.ups.sistemaeducativo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

//IMPORTACIONES DE TODAS LA CASES
import ec.edu.ups.sistemaeducativo.Models.*;
import ec.edu.ups.sistemaeducativo.Controllers.*;
import ec.edu.ups.sistemaeducativo.Repositories.*;
import ec.edu.ups.sistemaeducativo.Services.*;
import jakarta.inject.Inject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@SpringBootTest
class SistemaEducativoApplicationTests {

	@InjectMocks
	EstudianteControlador estudianteControlador;

	@Mock
	EstudianteServicio estudianteServicio;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	static Stream<Estudiante> generadorEstudiantes(){
		Estudiante estudiante = new Estudiante();
		List<Matricula> matriculas = new ArrayList<>();

		estudiante.setUsuId((long)1.0);
		estudiante.setUsuNombre("David");
		estudiante.setEstGradoAcademico("Ciclo");
		estudiante.setUsuPerfilAcceso("ddutans");
		estudiante.setUsuPassword("1234");
		estudiante.setUsuCorreo("ddutans@est.ups.edu.ec");
		estudiante.setUsuCedula("0106113632");
		estudiante.setUsuApellido("Dutan");
		estudiante.setMatriculas(null);
	
		return Stream.of(estudiante);

	}

	@ParameterizedTest
	@MethodSource("generadorEstudiantes")
	public void crearEstudiante(Estudiante estudiante){
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(estudianteServicio.nuevoEstudiante(any(Estudiante.class))).thenReturn(estudiante);

		ResponseEntity<Estudiante> response = estudianteControlador.registrarEstudiante(estudiante);
		assertTrue(response.getStatusCodeValue()==201);
	}

}
