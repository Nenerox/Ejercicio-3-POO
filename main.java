
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1. Agregar Miembro");
            System.out.println("2. Agregar Rutina");
            System.out.println("3. Agregar Entrenador");
            System.out.println("4. Asignar Rutina a Miembro");
            System.out.println("5. Asignar Entrenador a Miembro");
            System.out.println("6. Buscar Miembro");
            System.out.println("7. Eliminar Miembro");
            System.out.println("8. Mostrar Resumen de datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido:");
                    String apellido = scanner.nextLine();
                    controlador.addMiembro(nombre, apellido);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la rutina:");
                    String nombreRutina = scanner.nextLine();
                    System.out.println("Ingrese la duración de la rutina:");
                    String duracion = scanner.nextLine();
                    controlador.addRutina(nombreRutina, duracion);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del entrenador:");
                    String nombreEntrenador = scanner.nextLine();
                    System.out.println("Ingrese el apellido del entrenador:");
                    String apellidoEntrenador = scanner.nextLine();
                    controlador.addEntrenador(nombreEntrenador, apellidoEntrenador);
                    break;
                case 4:
                    for (Miembro miembro : controlador.mostrarMiembrosSinAsignar()) {
                        System.out.println(miembro.datos());
                    }
                    System.out.println("Ingrese el nombre del miembro:");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del miembro:");
                    apellido = scanner.nextLine();

                    System.out.println("Rutinas disponibles:");
                    for (Rutina rutina : controlador.getRutinas()) {
                        System.out.println(rutina.datos());
                    }
                    System.out.println("Ingrese el nombre de la rutina:");
                    nombreRutina = scanner.nextLine();
                    controlador.asignarRutinaAMiembro(nombre, apellido, nombreRutina);
                    break;
                case 5:
                    for (Miembro miembro : controlador.mostrarMiembrosSinAsignar()) {
                        System.out.println(miembro.datos());
                    }                    
                    System.out.println("Ingrese el nombre del miembro:");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del miembro:");
                    apellido = scanner.nextLine();
                    
                    System.out.println("Entrenadores disponibles:");
                    for (Entrenador entrenador : controlador.getEntrenadores()) {
                        System.out.println(entrenador.datos());
                    }
                    System.out.println("Ingrese el nombre del entrenador:");
                    nombreEntrenador = scanner.nextLine();
                    System.out.println("Ingrese el apellido del entrenador:");
                    apellidoEntrenador = scanner.nextLine();
                    controlador.asignarEntrenadorAMiembro(nombre, apellido, nombreEntrenador, apellidoEntrenador);
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del miembro:");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del miembro:");
                    apellido = scanner.nextLine();
                    if (controlador.buscarMiembro(nombre, apellido) != null) {
                        System.out.println(controlador.buscarMiembro(nombre, apellido).datos());
                    } else {
                        System.out.println("Miembro no encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del miembro:");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del miembro:");
                    apellido = scanner.nextLine();
                    controlador.eliminarMiembro(nombre, apellido);
                    break;
                case 8:
                    System.out.println("Total de rutinas activas:" + controlador.totalRutinas());
                    System.out.println("Total de entrenadores activos:" + controlador.totalEntrenadores());
                    System.out.println("Total de miembros activos:" + controlador.totalMiembros());
                    System.out.println("Miembros sin asignar:" + controlador.mostrarMiembrosSinAsignar().size());
                    System.out.println("Rutina mas popular:" + controlador.rutinaMasPopular());
                    System.out.println("Entrenador con mas miembros:" + controlador.entrenadorMasPopular());
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
        }
    }
    }
}