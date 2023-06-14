package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RubroDeCobro")
public class RubroDeCobro {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="adm_id")
    private long admId;

    @Column(name="adm_tipoDePago")
    public String admTipoDePago;

    @Column(name="adm_areaDeTrabajo")
    public String admAreaDeTrabajo;
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
