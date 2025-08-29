public class Miembro {
    private String nombre;
    private String apellido;
    private Rutina rutinaAsignada;
    private Entrenador entrenadorAsignado;

    public Miembro(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setRutina(Rutina rutina) {
        this.rutinaAsignada = rutina;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenadorAsignado = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Rutina getRutina() {
        return rutinaAsignada;
    }

    public Entrenador getEntrenador() {
        return entrenadorAsignado;
    }

    public String datos() {
        String rutinaInfo = (rutinaAsignada != null) ? rutinaAsignada.getNombre() : "No asignada";
        String entrenadorInfo = (entrenadorAsignado != null) ? entrenadorAsignado.getNombre() + " " + entrenadorAsignado.getApellido() : "No asignado";
        return "Miembro: " + nombre + " " + apellido + ", Rutina: " + rutinaInfo + ", Entrenador: " + entrenadorInfo;
    }   
}