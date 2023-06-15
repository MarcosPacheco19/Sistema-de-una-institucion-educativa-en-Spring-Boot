package ec.edu.ups.sistemaeducativo.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DetalleFacturas")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="det_id")
    private long detId;

    @Column(name="det_descripcion")
    private String detDescripcion;

    @Column(name="det_subTotal")
    private double detSubtotal;

    @Column(name="det_total")
    private double detTotal;
    
    public long getDet_id() {
        return detId;
    }
    public void setDet_id(long det_id) {
        this.detId = det_id;
    }
    public String getDetDescripcion() {
        return detDescripcion;
    }
    public void setDetDescripcion(String detDescripcion) {
        this.detDescripcion = detDescripcion;
    }
    public double getDetSubtotal() {
        return detSubtotal;
    }
    public void setDetSubtotal(double detSubtotal) {
        this.detSubtotal = detSubtotal;
    }
    public double getDetTotal() {
        return detTotal;
    }
    public void setDetTotal(double detTotal) {
        this.detTotal = detTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (detId ^ (detId >>> 32));
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
        DetalleFactura other = (DetalleFactura) obj;
        if (detId != other.detId)
            return false;
        return true;
    }
}
