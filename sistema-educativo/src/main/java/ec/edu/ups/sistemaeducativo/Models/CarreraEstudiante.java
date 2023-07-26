package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="CarreraEstudiante")
public class CarreraEstudiante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="car_est_id")
    private Long carEstId;
    @Column(name="car_est_fecha_inscripcion")
    private String carEstFechaInscripcion;

    @Column(name = "car_est_eliminado")
    private boolean carEstEliminado;

    public CarreraEstudiante(Long carEstId, String carEstFechaInscripcion, boolean carEstEliminado) {
        this.carEstId = carEstId;
        this.carEstFechaInscripcion = carEstFechaInscripcion;
        this.carEstEliminado = carEstEliminado;
    }

    public CarreraEstudiante() {
    }

    public CarreraEstudiante(Long carEstId) {
        this.carEstId = carEstId;
    }

    public Long getCarEstId() {
        return carEstId;
    }
    public void setCarEstId(Long carEstId) {
        this.carEstId = carEstId;
    }
    public String getCarEstFechaInscripcion() {
        return carEstFechaInscripcion;
    }
    public void setCarEstFechaInscripcion(String carEstFechaInscripcion) {
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
