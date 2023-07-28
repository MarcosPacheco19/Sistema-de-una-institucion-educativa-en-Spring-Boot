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
@Table(name = "Matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_Id")
    private long matId;
    @Column(name = "mat_tipo")
    private String matTipo;
    @Column(name = "mat_fecha")
    private String matFecha;
    @Column(name = "mat_eliminado")
    private boolean matEliminado;

    @ManyToOne
    @JoinColumn(name = "usu_id")
    private Estudiante estudiante;

    public Matricula() {
    }

    public Matricula(long matId, String matTipo, String matFecha, boolean matEliminado, Estudiante estudiante) {
        this.matId = matId;
        this.matTipo = matTipo;
        this.matFecha = matFecha;
        this.matEliminado = matEliminado;
        this.estudiante = estudiante;
    }

    public Matricula(long matId) {
        this.matId = matId;
    }

    public long getMat_id() {
        return matId;
    }

    public void setMat_id(long matId) {
        this.matId = matId;
    }

    public String getMat_tipo() {
        return matTipo;
    }

    public void setMat_tipo(String matTipo) {
        this.matTipo = matTipo;
    }

    public String getMat_fecha() {
        return matFecha;
    }

    public void setMat_fecha(String matFecha) {
        this.matFecha = matFecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isMatEliminado() {
        return matEliminado;
    }

    public void setMatEliminado(boolean matEliminado) {
        this.matEliminado = matEliminado;
    }

   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (matId ^ (matId >>> 32));
        result = prime * result + ((matTipo == null) ? 0 : matTipo.hashCode());
        result = prime * result + ((matFecha == null) ? 0 : matFecha.hashCode());
        result = prime * result + (matEliminado ? 1231 : 1237);
        result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
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
        Matricula other = (Matricula) obj;
        if (matId != other.matId)
            return false;
        if (matTipo == null) {
            if (other.matTipo != null)
                return false;
        } else if (!matTipo.equals(other.matTipo))
            return false;
        if (matFecha == null) {
            if (other.matFecha != null)
                return false;
        } else if (!matFecha.equals(other.matFecha))
            return false;
        if (matEliminado != other.matEliminado)
            return false;
        if (estudiante == null) {
            if (other.estudiante != null)
                return false;
        } else if (!estudiante.equals(other.estudiante))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Matricula [matId=" + matId + ", matTipo=" + matTipo + ", matFecha=" + matFecha + ", matEliminado="
                + matEliminado + ", estudiante=" + estudiante + "]";
    }

}
