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

import ec.edu.ups.sistemaeducativo.Models.GrupoAsignatura;
import ec.edu.ups.sistemaeducativo.Services.GrupoAsignaturaServicio;

@RestController
@RequestMapping(path="grupos_asignaturas")
public class GrupoAsignaturaControlador {
    
    private final GrupoAsignaturaServicio grupoAsignaturaServicio;

    @Autowired
    public GrupoAsignaturaControlador (GrupoAsignaturaServicio grupoAsignaturaServicio){
        this.grupoAsignaturaServicio = grupoAsignaturaServicio;
    }

    @GetMapping(path = "listar")
    public List<GrupoAsignatura> getGruposAsignaturas(){
        return this.grupoAsignaturaServicio.getGruposAsignaturas();
    }

    @PostMapping(path = "registrar")
    public ResponseEntity<Object> registrarGruposAsignatura(@RequestBody GrupoAsignatura grupoAsignatura){
        return this.grupoAsignaturaServicio.nuevoGrupoAsignatura(grupoAsignatura);
    }

    @PatchMapping(path = "actualizar")
    public ResponseEntity<Object> actualizarGruposAsignatura(@RequestBody GrupoAsignatura grupoAsignatura){
        return this.grupoAsignaturaServicio.actualizarCarrera(grupoAsignatura);
    }

    @DeleteMapping(path = "eliminar/{grpId}")
    public ResponseEntity<Object> eliminarGruposAsignatura(@PathVariable("grpId") Long id){
        return this.grupoAsignaturaServicio.eliminarCarrera(id);
    }

    @GetMapping(path = "buscar/{grpId}")
    public ResponseEntity<Object> buscarGruposAsignatura (@PathVariable("grpId") Long id){
        return this.grupoAsignaturaServicio.buscarCarrera(id);
    }
}