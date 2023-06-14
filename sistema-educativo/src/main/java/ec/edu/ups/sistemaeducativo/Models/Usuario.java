package ec.edu.ups.sistemaeducativo.Models;


public class Usuario {
    
    private Long usuId;
    private String usuNombre;
    private String usuApellido;
    private String usuCorreo;
    private String usuPassword;
    private String usuPerfilAcceso;
    private String usuCedula;
    
    public Usuario() {
    }

    public Usuario(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula) {
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuCorreo = usuCorreo;
        this.usuPassword = usuPassword;
        this.usuPerfilAcceso = usuPerfilAcceso;
        this.usuCedula = usuCedula;
    }

    public Usuario(Long usuId) {
        this.usuId = usuId;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuPerfilAcceso() {
        return usuPerfilAcceso;
    }

    public void setUsuPerfilAcceso(String usuPerfilAcceso) {
        this.usuPerfilAcceso = usuPerfilAcceso;
    }

    public String getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(String usuCedula) {
        this.usuCedula = usuCedula;
    }
}
