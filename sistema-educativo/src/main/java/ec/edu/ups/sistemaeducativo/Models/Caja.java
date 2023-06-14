package ec.edu.ups.sistemaeducativo.Models;

public class Caja {

    private Long caj_id;
    private double caj_saldo_inicial;
    private String caj_fecha;

    public Caja() {
    }

    public Caja(Long caj_id, double caj_saldo_inicial, String caj_fecha) {
        this.caj_id = caj_id;
        this.caj_saldo_inicial = caj_saldo_inicial;
        this.caj_fecha = caj_fecha;
    }

    public Long getCaj_id() {
        return caj_id;
    }

    public void setCaj_id(Long caj_id) {
        this.caj_id = caj_id;
    }

    public double getCaj_saldo_inicial() {
        return caj_saldo_inicial;
    }

    public void setCaj_saldo_inicial(double caj_saldo_inicial) {
        this.caj_saldo_inicial = caj_saldo_inicial;
    }

    public String getCaj_fecha() {
        return caj_fecha;
    }

    public void setCaj_fecha(String caj_fecha) {
        this.caj_fecha = caj_fecha;
    }

}
