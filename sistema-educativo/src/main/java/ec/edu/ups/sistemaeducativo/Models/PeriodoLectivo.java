package ec.edu.ups.sistemaeducativo.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "PeriodoLectivo")
public class PeriodoLectivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long plId;
    @Column(name = "per_descripcion")
    private String plDescripcion;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "grp_id")
    private List<GrupoAsignatura> grupoAsignaturas;

    @Column(name = "per_eliminado")
    private boolean perEliminado;

    public PeriodoLectivo() {
    }

    public PeriodoLectivo(Long plId, String plDescripcion, List<GrupoAsignatura> grupoAsignaturas,
            boolean perEliminado) {
        this.plId = plId;
        this.plDescripcion = plDescripcion;
        this.grupoAsignaturas = grupoAsignaturas;
        this.perEliminado = perEliminado;
    }

    public Long getPlId() {
        return plId;
    }

    public void setPlId(Long plId) {
        this.plId = plId;
    }

    public String getPlDescripcion() {
        return plDescripcion;
    }

    public void setPlDescripcion(String plDescripcion) {
        this.plDescripcion = plDescripcion;
    }

    public List<GrupoAsignatura> getGrupoAsignaturas() {
        return grupoAsignaturas;
    }

    public void setGrupoAsignaturas(List<GrupoAsignatura> grupoAsignaturas) {
        this.grupoAsignaturas = grupoAsignaturas;
    }

      public boolean isPerEliminado() {
        return perEliminado;
    }

    public void setPerEliminado(boolean perEliminado) {
        this.perEliminado = perEliminado;
    }

    @Override
    public String toString() {
        return "PeriodoLectivo [plId=" + plId + ", plDescripcion=" + plDescripcion + ", grupoAsignaturas="
                + grupoAsignaturas + "]";
    }
}
