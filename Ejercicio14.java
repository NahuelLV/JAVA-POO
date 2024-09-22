import java.util.Scanner;


public class POO {
	  public static void main(String[] args) {
		  Scanner leer = new Scanner(System.in);
		  System.out.println("Ingrese 1 numero: ");
		  float num1 = leer.nextInt();
		  
		  float IVA = (num1 / 100) * 21;
		  
		  float total = IVA + num1;
		  
		  System.out.println("Su total es de: "+ total);
	    }
}
