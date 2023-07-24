package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="GrupoAsignatura")
public class GrupoAsignatura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="grp_id")
    private Long grpId;
    @Column(name="grp_grupo")
    private String grupoAcademino;
    
    public GrupoAsignatura(Long grpId, String grupoAcademino) {
        this.grpId = grpId;
        this.grupoAcademino = grupoAcademino;
    }

    public GrupoAsignatura() {
    }

    public GrupoAsignatura(Long grpId) {
        this.grpId = grpId;
    }

    public Long getGrpId() {
        return grpId;
    }

    public void setGrpId(Long grpId) {
        this.grpId = grpId;
    }

    public String getGrupoAcademino() {
        return grupoAcademino;
    }

    public void setGrupoAcademino(String grupoAcademino) {
        this.grupoAcademino = grupoAcademino;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grpId == null) ? 0 : grpId.hashCode());
        result = prime * result + ((grupoAcademino == null) ? 0 : grupoAcademino.hashCode());
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
        GrupoAsignatura other = (GrupoAsignatura) obj;
        if (grpId == null) {
            if (other.grpId != null)
                return false;
        } else if (!grpId.equals(other.grpId))
            return false;
        if (grupoAcademino == null) {
            if (other.grupoAcademino != null)
                return false;
        } else if (!grupoAcademino.equals(other.grupoAcademino))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GrupoAsignatura [grpId=" + grpId + ", grupoAcademino=" + grupoAcademino + "]";
    }
}
