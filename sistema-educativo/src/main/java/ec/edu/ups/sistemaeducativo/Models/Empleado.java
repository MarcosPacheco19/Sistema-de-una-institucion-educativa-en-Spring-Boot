package ec.edu.ups.sistemaeducativo.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleados")
@PrimaryKeyJoinColumn(name = "usu_id")
public class Empleado extends Usuario {
    
    @Column(name="emp_cargo")
    private String empCargo;
    @Column(name="emp_area_trabajo")
    private String empAreaTrabajo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cab_id")
    private List<CabeceraFactura> cabeceras;

    public Empleado() {
    }

    public Empleado(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, Long empId, String empCargo, String empAreaTrabajo) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula);
        this.empCargo = empCargo;
        this.empAreaTrabajo = empAreaTrabajo;
    }

    public String getEmpCargo() {
        return empCargo;
    }

    public void setEmpCargo(String empCargo) {
        this.empCargo = empCargo;
    }
    
    public String getEmpAreaTrabajo() {
        return empAreaTrabajo;
    }
    public void setEmpAreaTrabajo(String empAreaTrabajo) {
        this.empAreaTrabajo = empAreaTrabajo;
    }

    public List<CabeceraFactura> getCabeceras() {
        return cabeceras;
    }

    public void setCabeceras(List<CabeceraFactura> cabeceras) {
        this.cabeceras = cabeceras;
    }  

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((empCargo == null) ? 0 : empCargo.hashCode());
        result = prime * result + ((empAreaTrabajo == null) ? 0 : empAreaTrabajo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (empCargo == null) {
            if (other.empCargo != null)
                return false;
        } else if (!empCargo.equals(other.empCargo))
            return false;
        if (empAreaTrabajo == null) {
            if (other.empAreaTrabajo != null)
                return false;
        } else if (!empAreaTrabajo.equals(other.empAreaTrabajo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empleado [ empCargo=" + empCargo + ", empAreaTrabajo=" + empAreaTrabajo + "]";
    }
}
