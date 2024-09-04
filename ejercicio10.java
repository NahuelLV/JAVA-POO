import java.util.Scanner;


public class POO {
	  public static void main(String[] args) {
		  Scanner leer = new Scanner(System.in);
		  System.out.println("Ingrese el radio del circulo: ");
		  Double radio = leer.nextDouble();
		  
		  	double area=Math.PI*Math.pow(radio, 2);
		  
	        System.out.println("El area del circulo es "+area);
		  
		  }
	        
	 }

