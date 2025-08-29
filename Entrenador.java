public class Entrenador {
    private String nombre;
    private String apellido;
    private int cantidadMiembros;

    public Entrenador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public void addMiembro() {
        cantidadMiembros++;
    }

    public void removeMiembro() {
        if (cantidadMiembros > 0) {
            cantidadMiembros--;
        }
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String datos() {
        return "Entrenador: " + nombre + " " + apellido + ", Cantidad de Miembros: " + cantidadMiembros;
    }
}