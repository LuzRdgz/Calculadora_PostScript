package calculadora_ps;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class calcPost {

    private static final String CLASS_NAME = calcPost.class.getName();
    private final static Logger LOG = Logger.getLogger(CLASS_NAME);
    public static void main(String[] args)  {
        System.out.println(CLASS_NAME);
        FileHandler loggingFileXML = null;
        FileHandler loggingFileTXT = null;
        try {
            loggingFileXML = new FileHandler("bitacora.xml");
            loggingFileTXT = new FileHandler("bitacora.txt");

            SimpleFormatter plainText = new SimpleFormatter();
            loggingFileTXT.setFormatter(plainText);

            LOG.setLevel( Level.ALL );
            LOG.addHandler(loggingFileXML);
            LOG.addHandler(loggingFileTXT);

            LOG.fine("FINE");
            LOG.info("INICIO");
            LOG.warning("Advertencia.");
            LOG.severe("Error.");

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

            LOG.info("FIN");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
