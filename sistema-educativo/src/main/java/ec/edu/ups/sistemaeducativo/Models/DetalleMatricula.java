package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Detalles_Matriculas")
public class DetalleMatricula {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="det_mat_id")
    private Long detMatId;
    @Column(name="det_mat_tipo_matricula")
    private String tipoMatricula;
    @Column(name="det_mat_modalidad")
    private String modalidad;
    
    public DetalleMatricula() {
    }

    public DetalleMatricula(Long detMatId, String tipoMatricula, String modalidad) {
        this.detMatId = detMatId;
        this.tipoMatricula = tipoMatricula;
        this.modalidad = modalidad;
    }

    public DetalleMatricula(Long detMatId) {
        this.detMatId = detMatId;
    }

    public Long getDetMatId() {
        return detMatId;
    }

    public void setDetMatId(Long detMatId) {
        this.detMatId = detMatId;
    }

    public String getTipoMatricula() {
        return tipoMatricula;
    }

    public void setTipoMatricula(String tipoMatricula) {
        this.tipoMatricula = tipoMatricula;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((detMatId == null) ? 0 : detMatId.hashCode());
        result = prime * result + ((tipoMatricula == null) ? 0 : tipoMatricula.hashCode());
        result = prime * result + ((modalidad == null) ? 0 : modalidad.hashCode());
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
        DetalleMatricula other = (DetalleMatricula) obj;
        if (detMatId == null) {
            if (other.detMatId != null)
                return false;
        } else if (!detMatId.equals(other.detMatId))
            return false;
        if (tipoMatricula == null) {
            if (other.tipoMatricula != null)
                return false;
        } else if (!tipoMatricula.equals(other.tipoMatricula))
            return false;
        if (modalidad == null) {
            if (other.modalidad != null)
                return false;
        } else if (!modalidad.equals(other.modalidad))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DetalleMatricula [detMatId=" + detMatId + ", tipoMatricula=" + tipoMatricula + ", modalidad="
                + modalidad + "]";
    }
}