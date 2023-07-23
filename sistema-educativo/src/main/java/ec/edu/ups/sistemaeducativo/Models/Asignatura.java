package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="asig_id")
    private Long asigId;
    @Column(name="asig_nombre")
    private String asigNombre;
    @Column(name="asig_creditos")
    private int asigCreditos;


    public Asignatura(Long asigId, String asigNombre, int asigCreditos) {
        this.asigId = asigId;
        this.asigNombre = asigNombre;
        this.asigCreditos = asigCreditos;
    }

    public Asignatura() {
    }


    public Long getAsigId() {
        return asigId;
    }


    public void setAsigId(Long asigId) {
        this.asigId = asigId;
    }


    public String getAsigNombre() {
        return asigNombre;
    }


    public void setAsigNombre(String asigNombre) {
        this.asigNombre = asigNombre;
    }


    public int getAsigCreditos() {
        return asigCreditos;
    }


    public void setAsigCreditos(int asigCreditos) {
        this.asigCreditos = asigCreditos;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((asigId == null) ? 0 : asigId.hashCode());
        result = prime * result + ((asigNombre == null) ? 0 : asigNombre.hashCode());
        result = prime * result + asigCreditos;
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
        Asignatura other = (Asignatura) obj;
        if (asigId == null) {
            if (other.asigId != null)
                return false;
        } else if (!asigId.equals(other.asigId))
            return false;
        if (asigNombre == null) {
            if (other.asigNombre != null)
                return false;
        } else if (!asigNombre.equals(other.asigNombre))
            return false;
        if (asigCreditos != other.asigCreditos)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Asignatura [asigId=" + asigId + ", asignombre=" + asigNombre + ", asigCreditos=" + asigCreditos + "]";
    }
}
