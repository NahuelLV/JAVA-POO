import java.util.Scanner;
public class app {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        String contrasena="1234";
 
        final int INTENTOS = 3;
        
        boolean correcta=false;
 
        String password;
        for (int i=0;i<INTENTOS && !correcta;i++){
            System.out.print("Introduce una contrasena: ");
            password = sc.next();
 
            if (password.equals(contrasena)){
                System.out.println("Bien ahi, le pegaste");
                correcta=true;
            }
        }
    }
}
