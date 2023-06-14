package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleados")
public class Empleado extends Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long empId;
    @Column(name="emp_cargo")
    private String empCargo;
    @Column(name="emp_area_trabajo")
    private String empAreaTrabajo;

    public Empleado() {
    }

    public Empleado(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, Long empId, String empCargo, String empAreaTrabajo) {
        super(usuId, usuNombre, usuApellido, usuCorreo, usuPassword, usuPerfilAcceso, usuCedula);
        this.empId = empId;
        this.empCargo = empCargo;
        this.empAreaTrabajo = empAreaTrabajo;
    }
    public Empleado(Long empId) {
        this.empId = empId;
    }
    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((empId == null) ? 0 : empId.hashCode());
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
        if (empId == null) {
            if (other.empId != null)
                return false;
        } else if (!empId.equals(other.empId))
            return false;
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
        return "Empleado [empId=" + empId + ", empCargo=" + empCargo + ", empAreaTrabajo=" + empAreaTrabajo + "]";
    }  
}
