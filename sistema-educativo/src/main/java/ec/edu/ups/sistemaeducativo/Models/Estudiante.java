package ec.edu.ups.sistemaeducativo.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Estudiantes")
@PrimaryKeyJoinColumn(name = "usu_id")
public class Estudiante extends Usuario {

    @Column(name="est_grado_academico")
    private String estGradoAcademico;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mat_id")
    private List<Matricula> matriculas;

    public Estudiante() {
    }

    public Estudiante(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, boolean usuEliminado, String estGradoAcademico) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula, usuEliminado);
        this.estGradoAcademico = estGradoAcademico;
    }

    public Estudiante(Long usuId) {
        super(usuId);
    }

    public String getEstGradoAcademico() {
        return estGradoAcademico;
    }

    public void setEstGradoAcademico(String estGradoAcademico) {
        this.estGradoAcademico = estGradoAcademico;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}