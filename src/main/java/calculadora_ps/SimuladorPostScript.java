package calculadora_ps;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class SimuladorPostScript {
    private static final String CLASS_NAME = calcPost.class.getName();
    private final static Logger LOG = Logger.getLogger(CLASS_NAME);
    public static void main(String[] args) throws IOException {

       // System.out.println(CLASS_NAME);
       // FileHandler loggingFileXML = new FileHandler("bitacora.xml");
        //FileHandler loggingFileTXT = new FileHandler("bitacora.txt");

        Scanner scanner = new Scanner(System.in);
        Stack<Double> pila = new Stack<>();

        while (true) {
            System.out.print("Ingrese una expresion PostScript (o 'quit' para salir): ");
            String expresion = scanner.nextLine();

            if (expresion.equalsIgnoreCase("quit")) {
                break;
            }

            String[] tokens = expresion.split("\\s+");

            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    // Si es un número, lo apilamos.
                    pila.push(Double.parseDouble(token));
                } else {
                    // Si es una operación, la realizamos.
                    
                    if (token.equals("add") && pila.size() >= 2) {
                        double num2 = pila.pop();
                        double num1 = pila.pop();
                        pila.push(num1 + num2);
                    } 
                   
                     else {
                        System.out.println("Operación no reconocida o no hay suficientes operandos.");
                        break;
                    }
                }
            }

            if (!pila.isEmpty()) {
                System.out.println("Resultado: " + pila.peek());
                pila.clear(); // Se limpia la pila después de mostrar el resultado.
            }
        }

        System.out.println("El programa ha finalizado.");
    }
}
