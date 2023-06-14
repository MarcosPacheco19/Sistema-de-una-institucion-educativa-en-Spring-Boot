package ec.edu.ups.sistemaeducativo.Models;

public class Periodo_Lectivo {

    private Long pl_id;
    private String pl_descripcion;

    public Periodo_Lectivo() {
    }

    public Periodo_Lectivo(Long pl_id, String pl_descripcion) {
        this.pl_id = pl_id;
        this.pl_descripcion = pl_descripcion;
    }

    public Long getPl_id() {
        return pl_id;
    }

    public void setPl_id(Long pl_id) {
        this.pl_id = pl_id;
    }

    public String getPl_descripcion() {
        return pl_descripcion;
    }

    public void setPl_descripcion(String pl_descripcion) {
        this.pl_descripcion = pl_descripcion;
    }

}
