package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "Caja")
public class Caja {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caj_id")
    private Long cajId;
    @Column(name = "caj_saldo_inicial")
    private double cajSaldoInicial;
    @Column(name = "caj_fecha")
    private String cajFecha;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cab_id")
    private CabeceraFactura cabeceraFactura;

    public Caja() {
    }

    public Caja(Long cajId, double cajSaldoInicial, String cajFecha, CabeceraFactura cabeceraFactura) {
        this.cajId = cajId;
        this.cajSaldoInicial = cajSaldoInicial;
        this.cajFecha = cajFecha;
        this.cabeceraFactura = cabeceraFactura;
    }

    public Long getCajId() {
        return cajId;
    }

    public void setCajId(Long cajId) {
        this.cajId = cajId;
    }

    public double getCajSaldoInicial() {
        return cajSaldoInicial;
    }

    public void setCajSaldoInicial(double cajSaldoInicial) {
        this.cajSaldoInicial = cajSaldoInicial;
    }

    public String getCajFecha() {
        return cajFecha;
    }

    public void setCajFecha(String cajFecha) {
        this.cajFecha = cajFecha;
    }

    public CabeceraFactura getCabeceraFactura() {
        return cabeceraFactura;
    }

    public void setCabeceraFactura(CabeceraFactura cabeceraFactura) {
        this.cabeceraFactura = cabeceraFactura;
    }

}
