package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante extends Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="est_id")
    private Long estId;
    @Column(name="est_grado_academico")
    private String estGradoAcademico;

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
}
