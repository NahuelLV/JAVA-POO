import java.util.Scanner;
 
public class CaracterASCIIApp {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un caracter:");
        char caracter = sc.next().charAt(0);

        int codigo = (int) caracter;
 
        System.out.println("Su caracter seria el numero:"+" "+codigo);
    }
}
