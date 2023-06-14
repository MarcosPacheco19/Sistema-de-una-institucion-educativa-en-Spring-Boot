package ec.edu.ups.sistemaeducativo.Models;

import java.sql.Date;

public class CarreraEstudiante {

    
    private String carEstId;
    private Date carEstFechaInscripcion;



    public CarreraEstudiante(String carEstId, Date carEstFechaInscripcion) {
        this.carEstId = carEstId;
        this.carEstFechaInscripcion = carEstFechaInscripcion;
    }

    public String getCarEstId() {
        return carEstId;
    }
    public void setCarEstId(String carEstId) {
        this.carEstId = carEstId;
    }
    public Date getCarEstFechaInscripcion() {
        return carEstFechaInscripcion;
    }
    public void setCarEstFechaInscripcion(Date carEstFechaInscripcion) {
        this.carEstFechaInscripcion = carEstFechaInscripcion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carEstId == null) ? 0 : carEstId.hashCode());
        result = prime * result + ((carEstFechaInscripcion == null) ? 0 : carEstFechaInscripcion.hashCode());
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
        CarreraEstudiante other = (CarreraEstudiante) obj;
        if (carEstId == null) {
            if (other.carEstId != null)
                return false;
        } else if (!carEstId.equals(other.carEstId))
            return false;
        if (carEstFechaInscripcion == null) {
            if (other.carEstFechaInscripcion != null)
                return false;
        } else if (!carEstFechaInscripcion.equals(other.carEstFechaInscripcion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CarreraEstudiante [carEstId=" + carEstId + ", carEstFechaInscripcion=" + carEstFechaInscripcion + "]";
    }

   
   


  
    
    
    
}
