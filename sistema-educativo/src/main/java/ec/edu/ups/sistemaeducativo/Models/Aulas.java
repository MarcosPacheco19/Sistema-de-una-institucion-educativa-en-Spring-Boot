package ec.edu.ups.sistemaeducativo.Models;

public class Aulas {

    private Long aul_id;
    private String aul_descripcion;

    public Aulas() {
    }

    public Aulas(Long aul_id, String aul_descripcion) {
        this.aul_id = aul_id;
        this.aul_descripcion = aul_descripcion;
    }

    public Long getAul_id() {
        return aul_id;
    }

    public void setAul_id(Long aul_id) {
        this.aul_id = aul_id;
    }

    public String getAul_descripcion() {
        return aul_descripcion;
    }

    public void setAul_descripcion(String aul_descripcion) {
        this.aul_descripcion = aul_descripcion;
    }

}
