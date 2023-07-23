package ec.edu.ups.sistemaeducativo.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Carreras")
public class Carrera {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="car_id")
    private Long carId;
    @Column(name="car_nombre")
    private String carNombre;
    @Column(name="car_Titulo")
    private String carTitulo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pro_id")
    private List<Profesor> profesores;

    public Carrera(Long carId, String carNombre, String carTitulo) {
        this.carId = carId;
        this.carNombre = carNombre;
        this.carTitulo = carTitulo;
    }
    
    public Carrera() {
    }

    public Carrera(Long carId) {
        this.carId = carId;
    }


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }

    public String getCarTitulo() {
        return carTitulo;
    }

    public void setCarTitulo(String carTitulo) {
        this.carTitulo = carTitulo;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carId == null) ? 0 : carId.hashCode());
        result = prime * result + ((carNombre == null) ? 0 : carNombre.hashCode());
        result = prime * result + ((carTitulo == null) ? 0 : carTitulo.hashCode());
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
        Carrera other = (Carrera) obj;
        if (carId == null) {
            if (other.carId != null)
                return false;
        } else if (!carId.equals(other.carId))
            return false;
        if (carNombre == null) {
            if (other.carNombre != null)
                return false;
        } else if (!carNombre.equals(other.carNombre))
            return false;
        if (carTitulo == null) {
            if (other.carTitulo != null)
                return false;
        } else if (!carTitulo.equals(other.carTitulo))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Carrera [carId=" + carId + ", carNombre=" + carNombre + ", carTitulo=" + carTitulo + "]";
    }    
}
