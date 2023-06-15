package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Profesores")
@PrimaryKeyJoinColumn(referencedColumnName = "pro_usuario")
public class Profesor extends Usuario {
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pro_id")
    private Long proId;
    @Column(name="pro_especialidad")
    private String proEspecialidad;
    
    public Profesor() {
    }

    public Profesor(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, Long proId, String proEspecialidad) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula);
        this.proId = proId;
        this.proEspecialidad = proEspecialidad;
    }

    public Profesor(Long usuId, Long proId) {
        super(usuId);
        this.proId = proId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProEspecialidad() {
        return proEspecialidad;
    }

    public void setProEspecialidad(String proEspecialidad) {
        this.proEspecialidad = proEspecialidad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((proId == null) ? 0 : proId.hashCode());
        result = prime * result + ((proEspecialidad == null) ? 0 : proEspecialidad.hashCode());
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
        Profesor other = (Profesor) obj;
        if (proId == null) {
            if (other.proId != null)
                return false;
        } else if (!proId.equals(other.proId))
            return false;
        if (proEspecialidad == null) {
            if (other.proEspecialidad != null)
                return false;
        } else if (!proEspecialidad.equals(other.proEspecialidad))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profesor [proId=" + proId + ", proEspecialidad=" + proEspecialidad + "]";
    }

}
