public class Rutina {
    private String nombre;
    private String duracion; 
    private int cantidadMiembros;

    public Rutina(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public void addMiembro() {
        cantidadMiembros++;
    }

    public void removeMiembro() {
        if (cantidadMiembros > 0) {
            cantidadMiembros--;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public String datos() {
        return "Rutina: " + nombre + ", Duracion: " + duracion + ", Cantidad de Miembros: " + cantidadMiembros;
    }
}