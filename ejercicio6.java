import java.util.Scanner;


public class POO {
	  public static void main(String[] args) {
		  Scanner leer = new Scanner(System.in);
		  System.out.println("Ingrese 2 numeros: ");
		  int num1 = leer.nextInt();
		  int num2 = leer.nextInt();
		  
	        System.out.println("La suma de los 2 numeros es:" + (num1+num2));
	        System.out.println("La suma de los 2 numeros es:" + (num1-num2));
	        System.out.println("La suma de los 2 numeros es:" + (num1*num2));
	        System.out.println("La suma de los 2 numeros es:" + (num1/num2));
	        System.out.println("La suma de los 2 numeros es:" + (num1%num2));
	        
	    }
}
