package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Table;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hor_id")
    private Long horId;
    @Column(name = "hor_dia")
    private String horDia;
    @Column(name = "hor_hora_entrada")
    private String horHoraEntrada;
    @Column(name = "hor_hora_salida")
    private String horHoraSalida;
    @ManyToOne
    @JoinColumn(name = "eul_id")
    private Aulas aulas;

    @Column(name = "eul_eliminado")
    private boolean eulEliminado;

    public Horario(Long horId, String horDia, String horHoraEntrada, String horHoraSalida, Aulas aulas,
            boolean eulEliminado) {
        this.horId = horId;
        this.horDia = horDia;
        this.horHoraEntrada = horHoraEntrada;
        this.horHoraSalida = horHoraSalida;
        this.aulas = aulas;
        this.eulEliminado = eulEliminado;
    }

    public boolean isEulEliminado() {
        return eulEliminado;
    }

    public void setEulEliminado(boolean eulEliminado) {
        this.eulEliminado = eulEliminado;
    }

    public Horario() {
    }

    public Long getHorId() {
        return horId;
    }

    public void setHorId(Long horId) {
        this.horId = horId;
    }

    public String getHorDia() {
        return horDia;
    }

    public void setHorDia(String horDia) {
        this.horDia = horDia;
    }

    public String getHorHoraEntrada() {
        return horHoraEntrada;
    }

    public void setHorHoraEntrada(String horHoraEntrada) {
        this.horHoraEntrada = horHoraEntrada;
    }

    public String getHorHoraSalida() {
        return horHoraSalida;
    }

    public void setHorHoraSalida(String horHoraSalida) {
        this.horHoraSalida = horHoraSalida;
    }

    public Aulas getAulas() {
        return aulas;
    }

    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }
}
