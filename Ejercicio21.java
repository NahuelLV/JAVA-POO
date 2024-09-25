import java.util.Scanner;
public class app {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un dia de la semana: ");
        String dia = sc.next();
        
        switch(dia){
            case "lunes":
            case "martes":
            case "miercoles":
            case "jueves":
            case "viernes":
                System.out.println("Es un dia laboral");
                break;
            case "sabado":
            case "domingo":
                System.out.println("Es fin de semana");
            default:
                System.out.print("Introduce un dia de la semana: ");
        }
    }
}
