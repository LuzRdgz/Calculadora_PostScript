package calculadora_ps;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimuladorPostScript {

    private static final String CLASS_NAME = SimuladorPostScript.class.getName();
    private final static Logger LOG = Logger.getLogger(CLASS_NAME);
    public static void main(String[] args) throws IOException {

        System.out.println(CLASS_NAME);
        FileHandler loggingFileXML = new FileHandler("bitacora.xml");
        FileHandler loggingFileTXT = new FileHandler("bitacora.txt");

        SimpleFormatter plainText = new SimpleFormatter();
        loggingFileTXT.setFormatter(plainText);

        LOG.setLevel( Level.ALL );
        LOG.addHandler(loggingFileXML);
        LOG.addHandler(loggingFileTXT);

        LOG.fine("FINE");
        LOG.info("INICIO");
        LOG.warning("Advertencia.");
        LOG.severe("Error.");

        Scanner scanner = new Scanner(System.in);
        Stack<Double> pila = new Stack<>();

        while (true) {
            System.out.print("Ingrese una expresión PostScript (o 'quit' para salir): ");
            String expresion = scanner.nextLine();

            if (expresion.equalsIgnoreCase("quit")) {
                break;
            }

            String[] tokens = expresion.split("\\s+");

            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    // Si es un número, lo apilamos.
                    pila.push(Double.parseDouble(token));
                } else if (esOperacionValida(token)) {
                    // Si es una operación válida, la realizamos.
                    if (token.equals("add") && pila.size() >= 2) {
                        double num2 = pila.pop();
                        double num1 = pila.pop();
                        pila.push(num1 + num2);
                    } else if (token.equals("mul") && pila.size() >= 2) {
                        double num2 = pila.pop();
                        double num1 = pila.pop();
                        pila.push(num1 * num2);
                    } else if (token.equals("div") && pila.size() >= 2) {
                            double num2 = pila.pop();
                            double num1 = pila.pop();
                            pila.push(num1 / num2);
                    } else if (token.equals("dup") && pila.size() >= 2) {
                        double num1 = pila.pop();
                        pila.push(num1 * num1);
                    } else if (token.equals("sub") && pila.size() >= 2) {
                        double num2 = pila.pop();
                        double num1 = pila.pop();
                        pila.push(num1 - num2);
                    } else if (token.equals("eq") && pila.size() >= 2) {
                        double num2 = pila.pop();
                        double num1 = pila.pop();
                        if (num1 == num2) {
                            System.out.println("Ambos valores son iguales");
                        } if (num1 != num2) {
                            System.out.println("Los valores no son iguales");
                        }
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
        LOG.info("FIN");
    }

    private static boolean esOperacionValida(String token) {
        return token.equals("add") || token.equals("mul") || 
                token.equals("dup") || token.equals("exch") || token.equals("sub") 
                || token.equals("eq")|| token.equals("div");
    }
}


