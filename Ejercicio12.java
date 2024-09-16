import java.util.Scanner;

public class CodigoASCIIApp {
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
		 System.out.println("Ingrese el numero segun la tabla ASCII: ");
		 int codigo = leer.nextInt();
		  
		char caracter=(char)codigo;
		System.out.println("Su caracter seria:" +" "+ caracter);
	}
}
