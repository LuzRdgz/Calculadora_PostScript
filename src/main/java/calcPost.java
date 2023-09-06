import java.util.Scanner;
import java.util.Stack;

public class calcPost {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useDelimiter("\\s");
        Stack pila = new Stack<>();
        String op;

        System.out.println("=======================================");
        System.out.println("OPERACION EN POSTSCRIPT:");
        System.out.println("=======================================");
        System.out.println("Ingresa la operacion:");
        while (scan.hasNext()){
            System.out.println("-" + scan.next());
            //op = scan.next();
            //pila.push(op);
        }
        /*while (!pila.empty()){
            System.out.println(pila.pop());
        }*/

    }

}
