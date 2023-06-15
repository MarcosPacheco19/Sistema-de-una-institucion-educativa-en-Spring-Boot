package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    public Estudiante() {
    }

    public Estudiante(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, Long estId, String estGradoAcademico) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula);
        this.estId = estId;
        this.estGradoAcademico = estGradoAcademico;
    }

    public Estudiante(Long usuId, Long estId) {
        super(usuId);
        this.estId = estId;
    }

    public Long getEstId() {
        return estId;
    }
    public void setEstId(Long estId) {
        this.estId = estId;
    }
    public String getEstGradoAcademico() {
        return estGradoAcademico;
    }
    public void setEstGradoAcademico(String estGradoAcademico) {
        this.estGradoAcademico = estGradoAcademico;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((estId == null) ? 0 : estId.hashCode());
        result = prime * result + ((estGradoAcademico == null) ? 0 : estGradoAcademico.hashCode());
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
        if (estId == null) {
            if (other.estId != null)
                return false;
        } else if (!estId.equals(other.estId))
            return false;
        if (estGradoAcademico == null) {
            if (other.estGradoAcademico != null)
                return false;
        } else if (!estGradoAcademico.equals(other.estGradoAcademico))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante [estId=" + estId + ", estGradoAcademico=" + estGradoAcademico + "]";
    }
}
