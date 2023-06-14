package ec.edu.ups.sistemaeducativo.Models;

public class DetalleFactura {
    private String detDescripcion;
    private double detSubtotal;
    private double detTotal;
    
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

    
}
