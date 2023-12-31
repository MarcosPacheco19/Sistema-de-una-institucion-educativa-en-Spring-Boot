package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RubroDeCobro")
public class RubroDeCobro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adm_id")
    private long admId;

    @Column(name = "adm_tipoDePago")
    public String admTipoDePago;

    @Column(name = "adm_areaDeTrabajo")
    public String admAreaDeTrabajo;

    @Column(name = "adm_eliminado")
    private boolean admEliminado;

    public RubroDeCobro() {
    }

    public RubroDeCobro(long admId, String admTipoDePago, String admAreaDeTrabajo, boolean admEliminado) {
        this.admId = admId;
        this.admTipoDePago = admTipoDePago;
        this.admAreaDeTrabajo = admAreaDeTrabajo;
        this.admEliminado = admEliminado;
    }

    public RubroDeCobro(long admId) {
        this.admId = admId;
    }

    public long getAdmId() {
        return admId;
    }

    public void setAdmId(long admId) {
        this.admId = admId;
    }

    public String getAdmTipoDePago() {
        return admTipoDePago;
    }

    public void setAdmTipoDePago(String admTipoDePago) {
        this.admTipoDePago = admTipoDePago;
    }

    public String getAdmAreaDeTrabajo() {
        return admAreaDeTrabajo;
    }

    public void setAdmAreaDeTrabajo(String admAreaDeTrabajo) {
        this.admAreaDeTrabajo = admAreaDeTrabajo;
    }

    public boolean isAdmEliminado() {
        return admEliminado;
    }

    public void setAdmEliminado(boolean admEliminado) {
        this.admEliminado = admEliminado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (admId ^ (admId >>> 32));
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
        RubroDeCobro other = (RubroDeCobro) obj;
        if (admId != other.admId)
            return false;
        return true;
    }
}
