package calculadora_ps;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class calcPost {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Stack <String> pila = new Stack<>();
        String op;

        System.out.println("=======================================");
        System.out.println("OPERACION EN POSTSCRIPT:");
        System.out.println("=======================================");
        System.out.println("Ingresa la operacion:");
        while (true){
            op = scan.next();
            StringTokenizer token = new StringTokenizer(op, "\\s" );
            pila.push(token.nextToken());

            if (op.equals("quit") || op.equals("QUIT")) {
                break;
            }

            while (!pila.isEmpty()){
                switch (pila.pop()){
                    case "add":
                        double suma = 0;
                        for (int i = 0; i< pila.size(); i++){
                            suma = suma + Double.parseDouble(pila.pop());
                        }
                        pila.push(String.valueOf(suma));
                        System.out.println("La suma es igual a " + pila);
                        break;
                    case "mult":
                        break;
                }
            }

        }

    }




}
