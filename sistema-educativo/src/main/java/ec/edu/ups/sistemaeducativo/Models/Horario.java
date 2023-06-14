package ec.edu.ups.sistemaeducativo.Models;

public class Horario {

    private Long hor_id;
    private String hor_date;
    private String hor_hora_entrada;
    private String hor_hora_salida;

    public Horario() {
    }

    public Horario(Long hor_id, String hor_date, String hor_hora_entrada, String hor_hora_salida) {
        this.hor_id = hor_id;
        this.hor_date = hor_date;
        this.hor_hora_entrada = hor_hora_entrada;
        this.hor_hora_salida = hor_hora_salida;
    }

    public Long getHor_id() {
        return hor_id;
    }

    public void setHor_id(Long hor_id) {
        this.hor_id = hor_id;
    }

    public String getHor_date() {
        return hor_date;
    }

    public void setHor_date(String hor_date) {
        this.hor_date = hor_date;
    }

    public String getHor_hora_entrada() {
        return hor_hora_entrada;
    }

    public void setHor_hora_entrada(String hor_hora_entrada) {
        this.hor_hora_entrada = hor_hora_entrada;
    }

    public String getHor_hora_salida() {
        return hor_hora_salida;
    }

    public void setHor_hora_salida(String hor_hora_salida) {
        this.hor_hora_salida = hor_hora_salida;
    }

}
