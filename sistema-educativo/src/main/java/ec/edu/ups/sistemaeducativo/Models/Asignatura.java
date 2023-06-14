package ec.edu.ups.sistemaeducativo.Models;

public class Asignatura {
    private int asigId;
    private String asignombre;
    private int asigCreditos;


    public Asignatura(int asigId, String asignombre, int asigCreditos) {
        this.asigId = asigId;
        this.asignombre = asignombre;
        this.asigCreditos = asigCreditos;
    }


    public int getAsigId() {
        return asigId;
    }


    public void setAsigId(int asigId) {
        this.asigId = asigId;
    }


    public String getAsignombre() {
        return asignombre;
    }


    public void setAsignombre(String asignombre) {
        this.asignombre = asignombre;
    }


    public int getAsigCreditos() {
        return asigCreditos;
    }


    public void setAsigCreditos(int asigCreditos) {
        this.asigCreditos = asigCreditos;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + asigId;
        result = prime * result + ((asignombre == null) ? 0 : asignombre.hashCode());
        result = prime * result + asigCreditos;
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
        Asignatura other = (Asignatura) obj;
        if (asigId != other.asigId)
            return false;
        if (asignombre == null) {
            if (other.asignombre != null)
                return false;
        } else if (!asignombre.equals(other.asignombre))
            return false;
        if (asigCreditos != other.asigCreditos)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Asignatura [asigId=" + asigId + ", asignombre=" + asignombre + ", asigCreditos=" + asigCreditos + "]";
    }

    
    
}