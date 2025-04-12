package TP;
import java.util.Scanner;

public class GestionReservas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_PROPIEDADES = 80;
        final int ATRIBUTOS = 8;
        int[][] datosEnteros = new int[MAX_PROPIEDADES][5];
        String[][] datosTexto = new String[MAX_PROPIEDADES][3];
        int cantidad = cargarPropiedadesIniciales(datosEnteros, datosTexto);
        ejecutarMenu(sc, datosEnteros, datosTexto, cantidad);
    }

    public static void ejecutarMenu(Scanner sc, int[][] datosEnteros, String[][] datosTexto, int cantidad) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar propiedad");
            System.out.println("2. Consultar propiedad");
            System.out.println("3. Modificar propiedad");
            System.out.println("4. Cambiar disponibilidad");
            System.out.println("5. Eliminar propiedad");
            System.out.println("6. Listar todas las propiedades");
            System.out.println("7. Crear reserva");
            System.out.println("8. Buscar propiedades por ubicación");
            System.out.println("9. Buscar propiedades por tipo");
            System.out.println("10. Calcular estadísticas del sistema");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    cantidad = registrarPropiedad(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 2:
                    consultarPropiedad(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 3:
                    modificarPropiedad(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 4:
                    cambiarDisponibilidad(sc, datosEnteros, cantidad);
                    break;
                case 5:
                    cantidad = eliminarPropiedad(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 6:
                    listarPropiedades(datosEnteros, datosTexto, cantidad);
                    break;
                case 7:
                    crearReserva(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 8:
                    buscarPorUbicacion(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 9:
                    buscarPorTipo(sc, datosEnteros, datosTexto, cantidad);
                    break;
                case 10:
                    calcularEstadisticas(datosEnteros, cantidad);
                    break;
                case 11:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 11);
    }

    public static int cargarPropiedadesIniciales(int[][] enteros, String[][] texto) {
        int[][] inicialesEnteros = {
                {501, 1, 4, 12000, 1},
                {502, 2, 2, 8000, 1},
                {503, 1, 6, 15000, 2},
                {504, 3, 3, 10000, 1},
                {505, 4, 1, 20000, 1},
                {506, 5, 2, 7000, 2},
                {507, 2, 3, 9000, 1},
                {508, 1, 5, 11000, 1},
                {509, 3, 2, 9500, 2},
                {510, 4, 4, 25000, 1}
        };

        String[][] inicialesTexto = {
                {"Casa Central", "Carlos Pérez", "Buenos Aires"},
                {"Depto Sur", "Ana Gómez", "Mendoza"},
                {"Casa Azul", "Luis Torres", "Rosario"},
                {"Cabaña Sol", "Sofía García", "Bariloche"},
                {"Hotel Plaza", "Martín Díaz", "Salta"},
                {"Hostel Joven", "Laura López", "Córdoba"},
                {"Depto Norte", "Pedro Ruiz", "Tucumán"},
                {"Casa de Campo", "Clara Suárez", "San Luis"},
                {"Cabaña Lago", "Juan Herrera", "Ushuaia"},
                {"Hotel Mar", "Julia Fernández", "Mar del Plata"}
        };

        for (int i = 0; i < inicialesEnteros.length; i++) {
            for (int j = 0; j < 5; j++) {
                enteros[i][j] = inicialesEnteros[i][j];
            }
            for (int j = 0; j < 3; j++) {
                texto[i][j] = inicialesTexto[i][j];
            }
        }
        return inicialesEnteros.length;
    }

    public static int registrarPropiedad(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        if (cantidad >= enteros.length) {
            System.out.println("No se pueden agregar más propiedades.");
            return cantidad;
        }

        System.out.print("ID (500-2000): ");
        int id = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][0] == id) {
                System.out.println("ID ya existe.");
                return cantidad;
            }
        }

        sc.nextLine();
        System.out.print("Nombre: ");
        texto[cantidad][0] = sc.nextLine();
        System.out.print("Propietario: ");
        texto[cantidad][1] = sc.nextLine();
        System.out.print("Ubicación: ");
        texto[cantidad][2] = sc.nextLine();

        System.out.print("Tipo (1-Casa, 2-Departamento, 3-Cabaña, 4-Hotel, 5-Hostel): ");
        enteros[cantidad][1] = sc.nextInt();
        System.out.print("Capacidad: ");
        enteros[cantidad][2] = sc.nextInt();
        System.out.print("Precio por noche: ");
        enteros[cantidad][3] = sc.nextInt();
        enteros[cantidad][0] = id;
        enteros[cantidad][4] = 1;

        return cantidad + 1;
    }

    public static void consultarPropiedad(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][0] == id) {
                imprimirPropiedad(i, enteros, texto);
                return;
            }
        }
        System.out.println("Propiedad no encontrada.");
    }

    public static void modificarPropiedad(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        System.out.print("ID a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][0] == id) {
                System.out.print("Nuevo nombre: ");
                texto[i][0] = sc.nextLine();
                System.out.print("Nuevo propietario: ");
                texto[i][1] = sc.nextLine();
                System.out.print("Nueva ubicación: ");
                texto[i][2] = sc.nextLine();
                System.out.print("Nuevo tipo: ");
                enteros[i][1] = sc.nextInt();
                System.out.print("Nueva capacidad: ");
                enteros[i][2] = sc.nextInt();
                System.out.print("Nuevo precio: ");
                enteros[i][3] = sc.nextInt();
                return;
            }
        }
        System.out.println("Propiedad no encontrada.");
    }

    public static void cambiarDisponibilidad(Scanner sc, int[][] enteros, int cantidad) {
        System.out.print("ID de propiedad: ");
        int id = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][0] == id) {
                enteros[i][4] = (enteros[i][4] == 1) ? 2 : 1;
                return;
            }
        }
        System.out.println("Propiedad no encontrada.");
    }

    public static int eliminarPropiedad(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        System.out.print("ID de propiedad: ");
        int id = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][0] == id) {
                for (int j = i; j < cantidad - 1; j++) {
                    for (int k = 0; k < 5; k++) {
                        enteros[j][k] = enteros[j + 1][k];
                    }
                    for (int k = 0; k < 3; k++) {
                        texto[j][k] = texto[j + 1][k];
                    }
                }
                return cantidad - 1;
            }
        }
        System.out.println("Propiedad no encontrada.");
        return cantidad;
    }

    public static void listarPropiedades(int[][] enteros, String[][] texto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            imprimirPropiedad(i, enteros, texto);
        }
    }

    public static void imprimirPropiedad(int i, int[][] enteros, String[][] texto) {
        System.out.println("ID: " + enteros[i][0]);
        System.out.println("Nombre: " + texto[i][0]);
        System.out.println("Propietario: " + texto[i][1]);
        System.out.println("Ubicación: " + texto[i][2]);
        System.out.println("Tipo: " + enteros[i][1]);
        System.out.println("Capacidad: " + enteros[i][2]);
        System.out.println("Precio por noche: $" + enteros[i][3]);
        System.out.println("Disponibilidad: " + ((enteros[i][4] == 1) ? "Disponible" : "No disponible"));
        System.out.println();
    }

    public static void crearReserva(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        System.out.print("Ingrese ID de propiedad: ");
        int id = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][0] == id && enteros[i][4] == 1) {
                System.out.println("Reserva realizada para: " + texto[i][0]);
                enteros[i][4] = 2;
                return;
            }
        }
        System.out.println("No se puede reservar.");
    }

    public static void buscarPorUbicacion(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        System.out.print("Ingrese ubicación: ");
        String ubic = sc.nextLine();
        for (int i = 0; i < cantidad; i++) {
            if (texto[i][2].equalsIgnoreCase(ubic)) {
                imprimirPropiedad(i, enteros, texto);
            }
        }
    }

    public static void buscarPorTipo(Scanner sc, int[][] enteros, String[][] texto, int cantidad) {
        System.out.print("Ingrese tipo (1-Casa, 2-Departamento, 3-Cabaña, 4-Hotel, 5-Hostel): ");
        int tipo = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][1] == tipo) {
                imprimirPropiedad(i, enteros, texto);
            }
        }
    }

    public static void calcularEstadisticas(int[][] enteros, int cantidad) {
        int total = cantidad;
        int disponibles = 0;
        int totalCapacidad = 0;
        for (int i = 0; i < cantidad; i++) {
            if (enteros[i][4] == 1) {
                disponibles++;
            }
            totalCapacidad += enteros[i][2];
        }
        System.out.println("Total de propiedades: " + total);
        System.out.println("Disponibles: " + disponibles);
        System.out.println("Capacidad total de huéspedes: " + totalCapacidad);
    }
}
