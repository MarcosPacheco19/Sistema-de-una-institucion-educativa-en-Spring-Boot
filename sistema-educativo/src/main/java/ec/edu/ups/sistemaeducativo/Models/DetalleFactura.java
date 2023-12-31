package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DetalleFacturas")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id")
    private long detId;

    @Column(name = "det_descripcion")
    private String detDescripcion;

    @Column(name = "det_subTotal")
    private double detSubtotal;

    @Column(name = "det_total")
    private double detTotal;

    @Column(name = "det_eliminado")
    private boolean detEliminado;

    public DetalleFactura(long detId, String detDescripcion, double detSubtotal, double detTotal,
            boolean detEliminado) {
        this.detId = detId;
        this.detDescripcion = detDescripcion;
        this.detSubtotal = detSubtotal;
        this.detTotal = detTotal;
        this.detEliminado = detEliminado;
    }

    public DetalleFactura() {
    }

    public DetalleFactura(long detId) {
        this.detId = detId;
    }

    public long getDetId() {
        return detId;
    }

    public void setDetId(long det_id) {
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
