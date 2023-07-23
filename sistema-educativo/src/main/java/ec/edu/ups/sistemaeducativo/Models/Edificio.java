package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Edificio")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edi_id")
    private Long ediId;
    @Column(name = "edi_nombre")
    private String ediNombre;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aul_id")
    private List<Aulas> aulas;

    public Edificio() {

    }

    public Edificio(Long ediId, String ediNombre, List<Aulas> aulas) {
        this.ediId = ediId;
        this.ediNombre = ediNombre;
        this.aulas = aulas;
    }

    public Edificio(Long ediId, String ediNombre) {
        this.ediId = ediId;
        this.ediNombre = ediNombre;
    }

    public Long getEdiId() {
        return ediId;
    }

    public void setEdiId(Long ediId) {
        this.ediId = ediId;
    }

    public String getEdiNombre() {
        return ediNombre;
    }

    public void setEdiNombre(String ediNombre) {
        this.ediNombre = ediNombre;
    }

    @Override
    public String toString() {
        return "Edificio [ediId=" + ediId + ", ediNombre=" + ediNombre + "]";
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }

}
