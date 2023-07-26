package ec.edu.ups.sistemaeducativo.Models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CabeceraFacturas")
public class CabeceraFactura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cab_id")
    private Long cabId;

    @Column(name="cab_cedula")
    private String cabCedula;

    @Column(name="cab_nombre")
    private String cabNombre;

    @Column(name="car_apellido")
    private String cabApellido;

    @Column(name="cab_fecha")
    private Date cabFecha;

    @Column(name="cab_telefono")
    private String cabTelefono;

    @Column(name="cab_direccion")
    private String cabDireccion;

    @Column(name="cab_correo")
    private String cabCorreo;

    @Column(name="cab_ciudad")
    private String cabCiudad;

    @Column(name="cab_subTotal")
    private double cabSubtotal;

    @Column(name="cab_iva")
    private double cabIva;

    @Column(name="cab_total")
    private double cabTotal;

    @Column(name = "cab_eliminado")
    private boolean cabEliminado;

    @OneToOne
    @JoinColumn(name="est_id")
    private Empleado empleado;

    public CabeceraFactura(Long cabId, String cabCedula, String cabNombre, String cabApellido, Date cabFecha,
            String cabTelefono, String cabDireccion, String cabCorreo, String cabCiudad, double cabSubtotal,
            double cabIva, double cabTotal, boolean cabEliminado, Empleado empleado) {
        this.cabId = cabId;
        this.cabCedula = cabCedula;
        this.cabNombre = cabNombre;
        this.cabApellido = cabApellido;
        this.cabFecha = cabFecha;
        this.cabTelefono = cabTelefono;
        this.cabDireccion = cabDireccion;
        this.cabCorreo = cabCorreo;
        this.cabCiudad = cabCiudad;
        this.cabSubtotal = cabSubtotal;
        this.cabIva = cabIva;
        this.cabTotal = cabTotal;
        this.cabEliminado = cabEliminado;
        this.empleado = empleado;
    }

    public CabeceraFactura(Long cabId) {
        this.cabId = cabId;
    }

    public CabeceraFactura() {
    }


    public Long getCabId(){
        return cabId;
    }

    public void setCabId(Long cabId){
        this.cabId = cabId;
    }

    public String getCabCedula() {
        return cabCedula;
    }
    public void setCabCedula(String cabCedula) {
        this.cabCedula = cabCedula;
    }
    public String getCabNombre() {
        return cabNombre;
    }
    public void setCabNombre(String cabNombre) {
        this.cabNombre = cabNombre;
    }
    public String getCabApellido() {
        return cabApellido;
    }
    public void setCabApellido(String cabApellido) {
        this.cabApellido = cabApellido;
    }
    public Date getCabFecha() {
        return cabFecha;
    }
    public void setCabFecha(Date cabFecha) {
        this.cabFecha = cabFecha;
    }
    public String getCabTelefono() {
        return cabTelefono;
    }
    public void setCabTelefono(String cabTelefono) {
        this.cabTelefono = cabTelefono;
    }
    public String getCabDireccion() {
        return cabDireccion;
    }
    public void setCabDireccion(String cabDireccion) {
        this.cabDireccion = cabDireccion;
    }
    public String getCabCorreo() {
        return cabCorreo;
    }
    public void setCabCorreo(String cabCorreo) {
        this.cabCorreo = cabCorreo;
    }
    public String getCabCiudad() {
        return cabCiudad;
    }
    public void setCabCiudad(String cabCiudad) {
        this.cabCiudad = cabCiudad;
    }
    public double getCabSubtotal() {
        return cabSubtotal;
    }
    public void setCabSubtotal(double cabSubtotal) {
        this.cabSubtotal = cabSubtotal;
    }
    public double getCabIva() {
        return cabIva;
    }
    public void setCabIva(double cabIva) {
        this.cabIva = cabIva;
    }
    public double getCabTotal() {
        return cabTotal;
    }
    public void setCabTotal(double cabTotal) {
        this.cabTotal = cabTotal;
    }    



     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cabId == null) ? 0 : cabId.hashCode());
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
        CabeceraFactura other = (CabeceraFactura) obj;
        if (cabId == null) {
            if (other.cabId != null)
                return false;
        } else if (!cabId.equals(other.cabId))
            return false;
        return true;
    }    



    
    
}
