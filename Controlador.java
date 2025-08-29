import java.util.ArrayList;

public class Controlador {
    private ArrayList<Miembro> miembrosList = new ArrayList<>();
    private ArrayList<Rutina> rutinasList = new ArrayList<>();
    private ArrayList<Entrenador> entrenadoresList= new ArrayList<>();

    public void addMiembro(String nombre, String apellido) {
        Miembro miembro = new Miembro(nombre, apellido);
        miembrosList.add(miembro);
    }

    public void addRutina(String nombre, String duracion) {
        Rutina rutina = new Rutina(nombre, duracion);
        rutinasList.add(rutina);
    }

    public void addEntrenador(String nombre, String apellido) {
        Entrenador entrenador = new Entrenador(nombre, apellido);
        entrenadoresList.add(entrenador);
    }

    public Miembro buscarMiembro(String nombre, String apellido) {
        for (Miembro miembro : miembrosList) {
            if (miembro.getNombre().equalsIgnoreCase(nombre) && miembro.getApellido().equalsIgnoreCase(apellido)) {
                return miembro;
            }
        } return null;
    }

    public ArrayList<Miembro> mostrarMiembrosSinAsignar() {
        ArrayList<Miembro> miembrosSinAsignar = new ArrayList<>();
        for (Miembro miembro : miembrosList) {
            if (miembro.getEntrenador() == null && miembro.getRutina() == null) {
                miembrosSinAsignar.add(miembro);
            }
        } return miembrosSinAsignar;
    } 

    public void asignarRutinaAMiembro(String nombreMiembro, String apellidoMiembro, String nombreRutina) {
        for (Miembro miembro : miembrosList) {
            if (miembro.getNombre().equalsIgnoreCase(nombreMiembro) && miembro.getApellido().equalsIgnoreCase(nombreRutina)) {
                for (Rutina rutina : rutinasList) {
                    if (rutina.getNombre().equalsIgnoreCase(nombreRutina)) {
                        miembro.setRutina(rutina);
                        rutina.addMiembro();
                    }
                }
            }
        }
    }

    public void asignarEntrenadorAMiembro(String nombreMiembro, String apellidoMiembro, String nombreEntrenador, String apellidoEntrenador) {
        for (Miembro miembro : miembrosList) {
            if (miembro.getNombre().equalsIgnoreCase(nombreMiembro) && miembro.getApellido().equalsIgnoreCase(apellidoMiembro)) {
                for (Entrenador entrenador : entrenadoresList) {
                    if (entrenador.getNombre().equalsIgnoreCase(nombreEntrenador) && entrenador.getApellido().equalsIgnoreCase(apellidoEntrenador)) {
                        miembro.setEntrenador(entrenador);
                        entrenador.addMiembro();
                    }
                }
            }
        }
    }

    public void eliminarMiembro(String nombre, String apellido) {
        Miembro miembroAEliminar = null;
        for (Miembro miembro : miembrosList) {
            if (miembro.getNombre().equalsIgnoreCase(nombre) && miembro.getApellido().equalsIgnoreCase(apellido)) {
                miembroAEliminar = miembro;
            }
        }
        if (miembroAEliminar != null) {
            if (miembroAEliminar.getRutina() != null) {
                miembroAEliminar.getRutina().removeMiembro();
            }
            if (miembroAEliminar.getEntrenador() != null) {
                miembroAEliminar.getEntrenador().removeMiembro();
            }
            miembrosList.remove(miembroAEliminar);
        }
    }
    
    public int totalRutinas() {
        return rutinasList.size();
    }

    public int totalEntrenadores() {
        return entrenadoresList.size();
    }

    public int totalMiembros() {
        return miembrosList.size();
    }

    public String rutinaMasPopular() {
        String rutinaPopular = "";
        int Miembros = -1;
        for (Rutina rutina : rutinasList) {
            if (rutina.getCantidadMiembros() > Miembros) {
                Miembros = rutina.getCantidadMiembros();
                rutinaPopular = rutina.datos();
            }
        }
        return rutinaPopular;
    }
    public String entrenadorMasPopular() {
        String entrenadorPopular = "";
        int Miembros = -1;
        for (Entrenador entrenador : entrenadoresList) {
            if (entrenador.getCantidadMiembros() > Miembros) {
                Miembros = entrenador.getCantidadMiembros();
                entrenadorPopular = entrenador.datos();
            }
        }
        return entrenadorPopular;
    }
}