package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cali_id")
    private Long caliId;
    @Column(name = "cali_nota")
    private int nota;
    @Column(name = "cali_comentario")
    private String comentario;
    @Column(name = "cali_fecha_calificacion")
    private String fechaCalificacion;

    @Column(name = "cali_eliminado")
    private boolean caliEliminado;

    
    public Calificacion(Long caliId, int nota, String comentario, String fechaCalificacion, boolean caliEliminado) {
        this.caliId = caliId;
        this.nota = nota;
        this.comentario = comentario;
        this.fechaCalificacion = fechaCalificacion;
        this.caliEliminado = caliEliminado;
    }

    public Calificacion() {
    }

    public Calificacion(Long caliId) {
        this.caliId = caliId;
    }

    public Long getCaliId() {
        return caliId;
    }

    public void setCaliId(Long caliId) {
        this.caliId = caliId;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(String fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public boolean isCaliEliminado() {
        return caliEliminado;
    }

    public void setCaliEliminado(boolean caliEliminado) {
        this.caliEliminado = caliEliminado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caliId == null) ? 0 : caliId.hashCode());
        result = prime * result + nota;
        result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
        result = prime * result + ((fechaCalificacion == null) ? 0 : fechaCalificacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Calificacion other = (Calificacion) obj;
        if (caliId == null) {
            if (other.caliId != null)
                return false;
        } else if (!caliId.equals(other.caliId))
            return false;
        if (nota != other.nota)
            return false;
        if (comentario == null) {
            if (other.comentario != null)
                return false;
        } else if (!comentario.equals(other.comentario))
            return false;
        if (fechaCalificacion == null) {
            if (other.fechaCalificacion != null)
                return false;
        } else if (!fechaCalificacion.equals(other.fechaCalificacion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Califiacion [caliId=" + caliId + ", nota=" + nota + ", comentario=" + comentario
                + ", fechaCalificacion=" + fechaCalificacion + "]";
    }
}
