package ec.edu.ups.sistemaeducativo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.sistemaeducativo.Models.Empleado;
import ec.edu.ups.sistemaeducativo.Services.EmpleadoServicio;


@RestController
@RequestMapping(path = "empleados")
public class EmpleadoControlador {
    
    private final EmpleadoServicio empleadoServicio;

    @Autowired
    public EmpleadoControlador (EmpleadoServicio empleadoServicio){
        this.empleadoServicio = empleadoServicio;
    }

    @GetMapping(path = "listar")
    public List<Empleado> getEmpleados(){
        return this.empleadoServicio.getEmpleados();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarEmpleado(@RequestBody Empleado empleado){
        return this.empleadoServicio.nuevoEmpleado(empleado);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarEmpleado(@RequestBody Empleado empleado){
        return this.empleadoServicio.actualizarEmpleado(empleado);
    }

    @DeleteMapping(path = "eliminar/{empId}")
    public ResponseEntity<Object> eliminarEmpleado(@PathVariable("empId") Long id){
        return this.empleadoServicio.eliminarEmpleado(id);
    }

    @GetMapping(path = "buscar/{empId}")
    public ResponseEntity<Object> buscarEmpleado (@PathVariable("empId") Long id){
        return this.empleadoServicio.buscarEmpleado(id);
    }
}
 