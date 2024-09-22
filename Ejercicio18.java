import java.util.Scanner;
public class VentasApp {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el numero de ventas: ");
        int numVentas=sc.nextInt();
 

        int sumaVentas=0;
        for (int i=0;i<numVentas;i++){
            System.out.print("Introduce el precio de la venta "+ (i+1) +": ");
            int venta=sc.nextInt();
            sumaVentas=sumaVentas+venta;
        }
 
        System.out.println("Su ganancias totales son: " + sumaVentas);
    }
}
