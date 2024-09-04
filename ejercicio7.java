import java.util.Scanner;


public class POO {
	  public static void main(String[] args) {
		  Scanner leer = new Scanner(System.in);
		  System.out.println("Ingrese 2 numeros: ");
		  int num1 = leer.nextInt();
		  int num2 = leer.nextInt();
		  
		  if(num1 < num2) {
			  System.out.println("El segundo numero es el mayor("+ num2 + ")");
		  }if(num1 > num2) {
			  System.out.println("El primer numero es el mayor("+ num1 + ")");
		  }if(num1 == num2) {
			  System.out.println("Los 2 numeros son iguales("+ num2 + ")");
		  }
	        
	    }
}
