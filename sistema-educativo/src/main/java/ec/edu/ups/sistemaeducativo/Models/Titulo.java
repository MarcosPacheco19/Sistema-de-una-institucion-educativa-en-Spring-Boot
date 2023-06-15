package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Titulos")
public class Titulo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tit_id")
    private long titId;

    @Column(name="tit_nombre")
    private String titnombre;

    @OneToMany
    @JoinColumn(name="pro_id")
    private Profesor profesor;
    
    public Titulo() {
    }

    public Titulo(Long usuId, long titId) {
        this.titId = titId;
    }

    public Titulo(long titId, String titnombre) {
        this.titId = titId;
        this.titnombre = titnombre;
    }

    public long getTitId() {
        return titId;
    }

    public void setTitId(long titId) {
        this.titId = titId;
    }

    public String getTitnombre() {
        return titnombre;
    }

    public void setTitnombre(String titnombre) {
        this.titnombre = titnombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (titId ^ (titId >>> 32));
        result = prime * result + ((titnombre == null) ? 0 : titnombre.hashCode());
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
        if (titnombre == null) {
            if (other.titnombre != null)
                return false;
        } else if (!titnombre.equals(other.titnombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Titulo [titId=" + titId + ", titnombre=" + titnombre + "]";
    }
}
