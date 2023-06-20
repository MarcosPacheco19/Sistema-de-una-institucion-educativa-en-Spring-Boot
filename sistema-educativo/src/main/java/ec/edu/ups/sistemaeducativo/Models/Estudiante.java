package ec.edu.ups.sistemaeducativo.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Estudiantes")
@PrimaryKeyJoinColumn(referencedColumnName = "est_usuario")
public class Estudiante extends Usuario {
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="est_id")
    private Long estId;
    @Column(name="est_grado_academico")
    private String estGradoAcademico;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mat_id")
    private List<Matricula> matriculas;

    public Estudiante() {
    }

    public Estudiante(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, Long estId, String estGradoAcademico,
            List<Matricula> matriculas) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula);
        this.estId = estId;
        this.estGradoAcademico = estGradoAcademico;
        this.matriculas = matriculas;
    }

    public Estudiante(Long usuId, Long estId) {
        super(usuId);
        this.estId = estId;
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

    public Long getEstId() {
        return estId;
    }

    public void setEstId(Long estId) {
        this.estId = estId;
    }

}