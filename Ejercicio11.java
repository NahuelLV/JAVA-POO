import java.util.Scanner;


public class POO {
	  public static void main(String[] args) {
		  Scanner leer = new Scanner(System.in);
		  System.out.println("Ingrese 1 numero: ");
		  int num1 = leer.nextInt();
		  
		  if(num1 % 2 == 0){
		       System.out.println("El numero es divisible por 2");
		  }else if(num1%2 != 0){
		       System.out.println("El numero no es divisible por 2");
		  }else if(num1 == 0){
		       System.out.println("El numero es 0");
		  }
	        
	    }
}
