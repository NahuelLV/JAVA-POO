import java.util.Scanner;
public class GeneraNumApp {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primero numero: ");
        int num1=sc.nextInt();
 
        System.out.print("Introduce el segundo numero: ");
        int num2=sc.nextInt();
 
        for (int i=0;i<10;i++){
            int numAleatorio=(int)Math.floor(Math.random()*(num1-num2)+num2);
            System.out.println(numAleatorio);
        }
    }
}
