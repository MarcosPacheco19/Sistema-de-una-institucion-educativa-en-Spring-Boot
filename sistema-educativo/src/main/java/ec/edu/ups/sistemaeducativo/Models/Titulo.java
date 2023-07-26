package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Titulos")
public class Titulo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tit_id")
    private long titId;

    @Column(name="tit_nombre")
    private String titNombre;

    @Column(name="tit_eliminado")
    private boolean titEliminado;

    @ManyToOne
    @JoinColumn(name="pro_id")
    private Profesor profesor;
    
    public Titulo() {
    }

    public Titulo(long titId) {
        this.titId = titId;
    }

    public Titulo(long titId, String titNombre, boolean titEliminado) {
        this.titId = titId;
        this.titNombre = titNombre;
        this.titEliminado = titEliminado;
    }

    public long getTitId() {
        return titId;
    }

    public void setTitId(long titId) {
        this.titId = titId;
    }

    public String getTitnombre() {
        return titNombre;
    }

    public void setTitnombre(String titnombre) {
        this.titNombre = titnombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getTitNombre() {
        return titNombre;
    }

    public void setTitNombre(String titNombre) {
        this.titNombre = titNombre;
    }

    public boolean isTitEliminado() {
        return titEliminado;
    }

    public void setTitEliminado(boolean titEliminado) {
        this.titEliminado = titEliminado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (titId ^ (titId >>> 32));
        result = prime * result + ((titNombre == null) ? 0 : titNombre.hashCode());
        result = prime * result + (titEliminado ? 1231 : 1237);
        result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
        Titulo other = (Titulo) obj;
        if (titId != other.titId)
            return false;
        if (titNombre == null) {
            if (other.titNombre != null)
                return false;
        } else if (!titNombre.equals(other.titNombre))
            return false;
        if (titEliminado != other.titEliminado)
            return false;
        if (profesor == null) {
            if (other.profesor != null)
                return false;
        } else if (!profesor.equals(other.profesor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Titulo [titId=" + titId + ", titNombre=" + titNombre + ", titEliminado=" + titEliminado + ", profesor="
                + profesor + "]";
    }
}
