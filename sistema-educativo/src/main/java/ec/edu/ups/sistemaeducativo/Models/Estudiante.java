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
    
    @Column(name="est_grado_academico")
    private String estGradoAcademico;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mat_id")
    private List<Matricula> matriculas;

    public Estudiante() {
    }

    public Estudiante(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, String estGradoAcademico) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula);
        this.estGradoAcademico = estGradoAcademico;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((estGradoAcademico == null) ? 0 : estGradoAcademico.hashCode());
        result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        if (estGradoAcademico == null) {
            if (other.estGradoAcademico != null)
                return false;
        } else if (!estGradoAcademico.equals(other.estGradoAcademico))
            return false;
        if (matriculas == null) {
            if (other.matriculas != null)
                return false;
        } else if (!matriculas.equals(other.matriculas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante [estGradoAcademico=" + estGradoAcademico + ", matriculas=" + matriculas + "]";
    }

    

}