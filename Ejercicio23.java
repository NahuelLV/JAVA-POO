import java.util.Scanner;

public class ContadorCifras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        
        while (numero <= 0) {
            System.out.print("Introduce un numero  positivo: ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero <= 0) {
                    System.out.println("Por favor, introduce un numero mayor que 0.");
                }
            } else {
                System.out.println("Entrada no valida. Por favor, introduce un numero entero.");
                scanner.next(); 
            }
        }

        int cifraCount = String.valueOf(numero).length();

        System.out.println("El numero " + numero + " tiene " + cifraCount + " cifra" + (cifraCount > 1 ? "s." : "."));

        scanner.close();
    }
}
