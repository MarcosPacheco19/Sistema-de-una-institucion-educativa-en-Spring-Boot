package ec.edu.ups.sistemaeducativo.Models;

public class Edificio {

    private Long edi_id;
    private String edi_nombre;

    public Edificio() {

    }

    public Edificio(Long edi_id, String edi_nombre) {
        this.edi_id = edi_id;
        this.edi_nombre = edi_nombre;
    }

    public Long getEdi_id() {
        return edi_id;
    }

    public void setEdi_id(Long edi_id) {
        this.edi_id = edi_id;
    }

    public String getEdi_nombre() {
        return edi_nombre;
    }

    public void setEdi_nombre(String edi_nombre) {
        this.edi_nombre = edi_nombre;
    }

}
