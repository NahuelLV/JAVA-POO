import java.util.Scanner;


public class POO {
	  public static void main(String[] args) {
	      
	      for(int i = 0; i <= 100; i++){
	          if(i == 0){
	          System.out.println("El numero es 0");
	      }else if(i % 2 == 0 && i % 3 == 0){
	          System.out.println("El numero es divisible por 2 y por 3: "+ i);
	      }else if(i % 2 == 0){
	          System.out.println("El numero es divisible por 2: "+ i);
	      }else if(i % 3 == 0){
	          System.out.println("El numero es divisible por 3: "+ i);
	      }
		 
	    }
}
}
