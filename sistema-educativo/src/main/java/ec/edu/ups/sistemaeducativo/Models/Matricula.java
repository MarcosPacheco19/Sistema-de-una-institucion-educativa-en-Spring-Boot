package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_id")
    private long mat_id;
    @Column(name = "mat_tipo")
    private String mat_tipo;
    @Column(name = "mat_fecha")
    private String mat_fecha;

    @Column(name = "mat_eliminado")
    private boolean matEliminado;

    @OneToOne
    @JoinColumn(name = "est_id")
    private Estudiante estudiante;

    public Matricula() {
    }

    public Matricula(long mat_id, String mat_tipo, String mat_fecha, boolean matEliminado, Estudiante estudiante) {
        this.mat_id = mat_id;
        this.mat_tipo = mat_tipo;
        this.mat_fecha = mat_fecha;
        this.matEliminado = matEliminado;
        this.estudiante = estudiante;
    }

    public Matricula(long mat_id) {
        this.mat_id = mat_id;
    }

    public long getMat_id() {
        return mat_id;
    }

    public void setMat_id(long mat_id) {
        this.mat_id = mat_id;
    }

    public String getMat_tipo() {
        return mat_tipo;
    }

    public void setMat_tipo(String mat_tipo) {
        this.mat_tipo = mat_tipo;
    }

    public String getMat_fecha() {
        return mat_fecha;
    }

    public void setMat_fecha(String mat_fecha) {
        this.mat_fecha = mat_fecha;
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
        result = prime * result + (int) (mat_id ^ (mat_id >>> 32));
        result = prime * result + ((mat_tipo == null) ? 0 : mat_tipo.hashCode());
        result = prime * result + ((mat_fecha == null) ? 0 : mat_fecha.hashCode());
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
        if (mat_id != other.mat_id)
            return false;
        if (mat_tipo == null) {
            if (other.mat_tipo != null)
                return false;
        } else if (!mat_tipo.equals(other.mat_tipo))
            return false;
        if (mat_fecha == null) {
            if (other.mat_fecha != null)
                return false;
        } else if (!mat_fecha.equals(other.mat_fecha))
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
        return "Matricula [mat_id=" + mat_id + ", mat_tipo=" + mat_tipo + ", mat_fecha=" + mat_fecha + ", matEliminado="
                + matEliminado + ", estudiante=" + estudiante + "]";
    }

}
