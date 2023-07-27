package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "Edificio")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edi_id")
    private Long ediId;
    @Column(name = "edi_nombre")
    private String ediNombre;

    @Column(name = "edi_numero_aulas")
    private int ediNumeroAulas;

    @Column(name = "edi_eliminado")
    private boolean ediEliminado;

    public Edificio() {

    }

    
    public Edificio(Long ediId, String ediNombre, int ediNumeroAulas, boolean ediEliminado) {
        this.ediId = ediId;
        this.ediNombre = ediNombre;
        this.ediNumeroAulas = ediNumeroAulas;
        this.ediEliminado = ediEliminado;
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

    public boolean isEdiEliminado() {
        return ediEliminado;
    }

    public void setEdiEliminado(boolean ediEliminado) {
        this.ediEliminado = ediEliminado;
    }

    public int getEdiNumeroAulas() {
        return ediNumeroAulas;
    }


    public void setEdiNumeroAulas(int ediNumeroAulas) {
        this.ediNumeroAulas = ediNumeroAulas;
    }
    

}
