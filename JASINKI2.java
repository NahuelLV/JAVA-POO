package TP;
import java.util.Scanner;

public class GestionReservas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int MAX_PROPIEDADES = 80;
        final int ATRIBUTOS = 8;

        int cantidad = 10;
        String[][] propiedades = new String[MAX_PROPIEDADES][ATRIBUTOS];

        GestionReservas gr = new GestionReservas();
        gr.cargarPropiedadesBase(propiedades);

        int opcion;
        do {
            opcion = gr.mostrarMenuYElegirOpcion(s);
            gr.generarAccion(opcion, propiedades, s, cantidad);
            if (opcion == 1) cantidad++;
            if (opcion == 5) cantidad--;
        } while (opcion != 11);

        s.close();
    }

    public void cargarPropiedadesBase(String[][] propiedades) {
        String[][] base = {
            {"501", "Hotel Sol", "Juan", "Cordoba", "4", "4", "5000", "1"},
            {"502", "Cabana Luz", "Ana", "Bariloche", "3", "3", "8000", "1"},
            {"503", "Casa Mar", "Carlos", "Mar del Plata", "1", "6", "10000", "2"},
            {"504", "Depto Centro", "Luis", "Buenos Aires", "2", "2", "4500", "1"},
            {"505", "Hostel Viajeros", "Luna", "Mendoza", "5", "10", "2000", "1"},
            {"506", "Hotel Montana", "Pedro", "Bariloche", "4", "5", "7500", "2"},
            {"507", "Casa Norte", "Lucia", "Salta", "1", "4", "6000", "1"},
            {"508", "Depto Roca", "Mauro", "Cordoba", "2", "3", "4000", "1"},
            {"509", "Cabana Nieve", "Julia", "Ushuaia", "3", "2", "9500", "1"},
            {"510", "Hotel Solis", "Raul", "Buenos Aires", "4", "3", "5500", "2"}
        };
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base[i].length; j++) {
                propiedades[i][j] = base[i][j];
            }
        }
    }

    public int mostrarMenuYElegirOpcion(Scanner s) {
        System.out.println("\n1. Registrar propiedad");
        System.out.println("2. Consultar propiedad");
        System.out.println("3. Modificar propiedad");
        System.out.println("4. Cambiar disponibilidad");
        System.out.println("5. Eliminar propiedad");
        System.out.println("6. Listar propiedades");
        System.out.println("7. Crear reserva");
        System.out.println("8. Buscar por ubicacion");
        System.out.println("9. Buscar por tipo");
        System.out.println("10. Estadisticas");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opcion: ");
        return ingresarEntero(s, 1, 11);
    }

    public void generarAccion(int opcion, String[][] propiedades, Scanner s, int cantidad) {
        switch (opcion) {
            case 1:
            	ingresarPropiedad(propiedades, s, cantidad);
            	break;
            case 2:
            	consultarPropiedad(propiedades, s, cantidad);
            	break;
            case 3:
            	modificarPropiedad(propiedades, s, cantidad);
            	break;
            case 4:
            	cambiarDisponibilidad(propiedades, s, cantidad);
            	break;
            case 5:
            	eliminarPropiedad(propiedades, s, cantidad);
            	break;
            case 6:
            	listarPropiedades(propiedades, cantidad);
            	break;
            case 7:
            	crearReserva(propiedades, s, cantidad);
            	break;
            case 8:
            	buscarPropiedadesPorUbicacion(propiedades, s, cantidad);
            	break;
            case 9: 
            	buscarPropiedadesPorTipo(propiedades, s, cantidad);
            	break;
            case 10:
            	calcularEstadisticas(propiedades, cantidad);
            	break;
        }
    }

    public void ingresarPropiedad(String[][] propiedades, Scanner s, int i) {
        System.out.println("ID entre 500 y 2000: ");
        int id;
        do {
            id = ingresarEntero(s, 500, 2000);
        } while (validarID(propiedades, id, i));
        propiedades[i][0] = Integer.toString(id);
        System.out.println("Nombre:");
        propiedades[i][1] = s.nextLine();
        System.out.println("Propietario:");
        propiedades[i][2] = s.nextLine();
        System.out.println("Ubicacion:");
        propiedades[i][3] = s.nextLine();
        System.out.println("Tipo (1:Casa, 2:Depto, 3:Cabana, 4:Hotel, 5:Hostel):");
        propiedades[i][4] = Integer.toString(ingresarEntero(s, 1, 5));
        System.out.println("Capacidad:");
        propiedades[i][5] = Integer.toString(ingresarEntero(s, 1, 20));
        System.out.println("Precio por noche:");
        propiedades[i][6] = Integer.toString(ingresarEntero(s, 1, 999999));
        propiedades[i][7] = "1";
        System.out.println("Propiedad registrada.");
    }

    public boolean validarID(String[][] propiedades, int id, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            if (Integer.parseInt(propiedades[i][0]) == id) {
            	return true;
            }
        }
        return false;
    }

    public int buscarPropiedad(String[][] propiedades, Scanner s, int cantidad) {
        System.out.println("Por que quiere buscar?:\n1)ID\n2)Nombre\nSeleccione:");
        int op = ingresarEntero(s, 1, 2);
        if (op == 1) {
            System.out.println("Ingrese ID:");
            int id = ingresarEntero(s, 500, 2000);
            for (int i = 0; i < cantidad; i++) {
                if (Integer.parseInt(propiedades[i][0]) == id) {
                	return i;
                }
            }
        } else {
            System.out.println("Ingrese nombre:");
            String nombre = s.nextLine();
            for (int i = 0; i < cantidad; i++) {
                if (propiedades[i][1].equalsIgnoreCase(nombre)) {
                	return i;
                }
            }
        }
        return -1;
    }

    public void consultarPropiedad(String[][] propiedades, Scanner s, int cantidad) {
        int pos = buscarPropiedad(propiedades, s, cantidad);
        if (pos != -1) { 
        	mostrarPropiedad(propiedades[pos]);
        }else 
        	System.out.println("Propiedad no encontrada.");
    }

    public void mostrarPropiedad(String[] prop) {
        String[] tipos = {"Casa", "Depto", "Cabana", "Hotel", "Hostel"};
        String tipo = tipos[Integer.parseInt(prop[4]) - 1];
        String disp = (prop[7].equals("1")) ? "Disponible" : "No disponible";
        System.out.println("ID: " + prop[0]);
        System.out.println("Nombre: " + prop[1]);
        System.out.println("Propietario: " + prop[2]);
        System.out.println("Ubicacion: " + prop[3]);
        System.out.println("Tipo: " + tipo);
        System.out.println("Capacidad: " + prop[5]);
        System.out.println("Precio: $" + prop[6]);
        System.out.println("Disponibilidad: " + disp);
        System.out.println();
    }

    public void modificarPropiedad(String[][] propiedades, Scanner s, int cantidad) {
        int pos = buscarPropiedad(propiedades, s, cantidad);
        if (pos == -1) {
            System.out.println("Propiedad no encontrada.");
            return;
        }
        ingresarPropiedad(propiedades, s, pos);
        System.out.println("Se modifico correctamente.");
    }

    public void cambiarDisponibilidad(String[][] propiedades, Scanner s, int cantidad) {
        int pos = buscarPropiedad(propiedades, s, cantidad);
        if (pos != -1) {
            propiedades[pos][7] = propiedades[pos][7].equals("1") ? "2" : "1";
            System.out.println("Se actualizo correctamente.");
        } else 
        	System.out.println("Propiedad no encontrada.");
    }

    public void eliminarPropiedad(String[][] propiedades, Scanner s, int cantidad) {
        int pos = buscarPropiedad(propiedades, s, cantidad);
        if (pos != -1) {
            for (int i = pos; i < cantidad - 1; i++) propiedades[i] = propiedades[i + 1];
            propiedades[cantidad - 1] = new String[8];
            System.out.println("Se elimino la propiedad.");
        } else 
        	System.out.println("Propiedad no encontrada.");
    }

    public void listarPropiedades(String[][] propiedades, int cantidad) {
        for (int i = 0; i < cantidad; i++) mostrarPropiedad(propiedades[i]);
    }

    public void crearReserva(String[][] propiedades, Scanner s, int cantidad) {
        int pos = buscarPropiedad(propiedades, s, cantidad);
        if (pos != -1 && propiedades[pos][7].equals("1")) {
            System.out.println("Noches:");
            int noches = ingresarEntero(s, 1, 365);
            System.out.println("Huespedes:");
            int huespedes = ingresarEntero(s, 1, 1000);
            	if (huespedes > Integer.parseInt(propiedades[pos][5])) {
            		System.out.println("ERROR: La cantidad de huespedes es mayor a la capacidad maxima.");
            		return;
            	}
            int total = calcularPrecioTotal(noches, Integer.parseInt(propiedades[pos][6]));
            System.out.println("Total: $" + total);
        } else 
        	System.out.println("No disponible.");
    }

    public void buscarPropiedadesPorUbicacion(String[][] propiedades, Scanner s, int cantidad) {
        System.out.println("Ubicacion:");
        String ubic = s.nextLine();
        for (int i = 0; i < cantidad; i++) {
            if (propiedades[i][3].equalsIgnoreCase(ubic)) {
            	mostrarPropiedad(propiedades[i]);
            }
        }
    }

    public void buscarPropiedadesPorTipo(String[][] propiedades, Scanner s, int cantidad) {
        System.out.println("Tipo (1-5):");
        int tipo = ingresarEntero(s, 1, 5);
        for (int i = 0; i < cantidad; i++) {
            if (Integer.parseInt(propiedades[i][4]) == tipo) {
            	mostrarPropiedad(propiedades[i]);
            }
        }
    }

    public void calcularEstadisticas(String[][] propiedades, int cantidad) {
        int[] tipos = new int[5];
        int disponibles = 0;
        int[] precios = new int[5];
        int[] caps = new int[5];
        int[] conteo = new int[5];
        String[] ciudades = new String[cantidad];
        int[] repeticiones = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            int tipo = Integer.parseInt(propiedades[i][4]) - 1;
            tipos[tipo]++;
            precios[tipo] += Integer.parseInt(propiedades[i][6]);
            caps[tipo] += Integer.parseInt(propiedades[i][5]);
            conteo[tipo]++;
            if (propiedades[i][7].equals("1")) disponibles++;
            String ciudad = propiedades[i][3];
            for (int j = 0; j <= i; j++) {
                if (ciudades[j] == null || ciudades[j].equals(ciudad)) {
                    ciudades[j] = ciudad;
                    repeticiones[j]++;
                    break;
                }
            }
        }
        String[] names = {"Casa", "Depto", "Cabana", "Hotel", "Hostel"};
        for (int i = 0; i < 5; i++) {
            System.out.println(names[i] + ": " + tipos[i] * 100 / cantidad + "%");
            System.out.println("Prom. precio: " + (conteo[i] > 0 ? precios[i] / conteo[i] : 0));
            System.out.println("Prom. capacidad: " + (conteo[i] > 0 ? caps[i] / conteo[i] : 0));
            System.out.println("");
        }
        System.out.println("Disponibles:" + disponibles * 100 / cantidad + "%");
        System.out.println("No disponibles:" + (cantidad - disponibles) * 100 / cantidad + "%");
        int max = 0;
        String top = "";
        for (int i = 0; i < cantidad; i++) {
            if (repeticiones[i] > max) {
                max = repeticiones[i];
                top = ciudades[i];
            }
        }
        System.out.println("Ubicacion con mas propiedades:" + top);
    }

    public int ingresarEntero(Scanner s, int min, int max) {
        int n;
        do {
            while (!s.hasNextInt()) {
                System.out.println("Ingrese numero valido:");
                s.next();
            }
            n = s.nextInt();
            s.nextLine();
        } while (n < min || n > max);
        return n;
    }

    public int calcularPrecioTotal(int noches, int precio) {
        return noches * precio;
    }

    public void filtrarPropiedadesPorCapacidad(String[][] propiedades, Scanner s, int cantidad) {
        System.out.println("Ingrese capacidad minima:");
        int cap = ingresarEntero(s, 1, 20);
        for (int i = 0; i < cantidad; i++) {
            if (Integer.parseInt(propiedades[i][5]) >= cap) {
            	mostrarPropiedad(propiedades[i]);
            }
            }
        }
    }
