package ec.edu.ups.sistemaeducativo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usu_id")
    private Long usuId;
    @Column(name="usu_nombre")
    private String usuNombre;
    @Column(name="usu_apellido")
    private String usuApellido;
    @Column(name="usu_correo")
    private String usuCorreo;
    @Column(name="usu_password")
    private String usuPassword;
    @Column(name="usu_perfil_acceso")
    private String usuPerfilAcceso;
    @Column(name="usu_cedula")
    private String usuCedula;
    @Column(name="usu_eliminado")
    private boolean usuEliminado;
    
    public Usuario() {
    }

    public Usuario(Long usuId, String usuNombre, String usuApellido, String usuCorreo, String usuPassword,
            String usuPerfilAcceso, String usuCedula, boolean usuEliminado) {
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuCorreo = usuCorreo;
        this.usuPassword = usuPassword;
        this.usuPerfilAcceso = usuPerfilAcceso;
        this.usuCedula = usuCedula;
        this.usuEliminado = usuEliminado;
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

    public boolean isUsuEliminado() {
        return usuEliminado;
    }

    public void setUsuEliminado(boolean usuEliminado) {
        this.usuEliminado = usuEliminado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
        result = prime * result + ((usuNombre == null) ? 0 : usuNombre.hashCode());
        result = prime * result + ((usuApellido == null) ? 0 : usuApellido.hashCode());
        result = prime * result + ((usuCorreo == null) ? 0 : usuCorreo.hashCode());
        result = prime * result + ((usuPassword == null) ? 0 : usuPassword.hashCode());
        result = prime * result + ((usuPerfilAcceso == null) ? 0 : usuPerfilAcceso.hashCode());
        result = prime * result + ((usuCedula == null) ? 0 : usuCedula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (usuId == null) {
            if (other.usuId != null)
                return false;
        } else if (!usuId.equals(other.usuId))
            return false;
        if (usuNombre == null) {
            if (other.usuNombre != null)
                return false;
        } else if (!usuNombre.equals(other.usuNombre))
            return false;
        if (usuApellido == null) {
            if (other.usuApellido != null)
                return false;
        } else if (!usuApellido.equals(other.usuApellido))
            return false;
        if (usuCorreo == null) {
            if (other.usuCorreo != null)
                return false;
        } else if (!usuCorreo.equals(other.usuCorreo))
            return false;
        if (usuPassword == null) {
            if (other.usuPassword != null)
                return false;
        } else if (!usuPassword.equals(other.usuPassword))
            return false;
        if (usuPerfilAcceso == null) {
            if (other.usuPerfilAcceso != null)
                return false;
        } else if (!usuPerfilAcceso.equals(other.usuPerfilAcceso))
            return false;
        if (usuCedula == null) {
            if (other.usuCedula != null)
                return false;
        } else if (!usuCedula.equals(other.usuCedula))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [usuId=" + usuId + ", usuNombre=" + usuNombre + ", usuApellido=" + usuApellido + ", usuCorreo="
                + usuCorreo + ", usuPassword=" + usuPassword + ", usuPerfilAcceso=" + usuPerfilAcceso + ", usuCedula="
                + usuCedula + "]";
    }
}
