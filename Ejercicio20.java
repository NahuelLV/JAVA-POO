import java.util.Scanner;
public class app {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        String contraseña="eureka";
 
        final int INTENTOS = 3;
        
        boolean acierto=false;
 
        String password;
        for (int i=0;i<INTENTOS && !acierto;i++){
            System.out.println("Introduce una contraseña");
            password = sc.next();
            if (password.equals(contraseña)){
                System.out.println("Enhorabuena, acertaste");
                acierto=true;
            }
        }
    }
}
