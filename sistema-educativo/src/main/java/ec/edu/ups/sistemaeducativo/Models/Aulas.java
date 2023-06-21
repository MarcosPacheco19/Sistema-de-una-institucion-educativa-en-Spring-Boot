package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "Aulas")

public class Aulas {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aul_id")
    private Long aulId;
    @Column(name = "aul_descripcion")
    private String auldescripcion;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "edi_id")
    private Edificio edificio;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hor_id")
    private List<Horario> horarios;

    public Aulas() {
    }

    public Aulas(Long aulId, String auldescripcion, Edificio edificio, List<Horario> horarios) {
        this.aulId = aulId;
        this.auldescripcion = auldescripcion;
        this.edificio = edificio;
        this.horarios = horarios;
    }

    public Aulas(Long aulId, String auldescripcion, Edificio edificio) {
        this.aulId = aulId;
        this.auldescripcion = auldescripcion;
        this.edificio = edificio;
    }

    public Aulas(Long aulId, String auldescripcion) {
        this.aulId = aulId;
        this.auldescripcion = auldescripcion;
    }

    public Long getAulId() {
        return aulId;
    }

    public void setAulId(Long aulId) {
        this.aulId = aulId;
    }

    public String getAuldescripcion() {
        return auldescripcion;
    }

    public void setAuldescripcion(String auldescripcion) {
        this.auldescripcion = auldescripcion;
    }

    @Override
    public String toString() {
        return "Aulas [aulId=" + aulId + ", auldescripcion=" + auldescripcion + "]";
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

}
