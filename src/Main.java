import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        Scanner scanner = new Scanner(System.in);


        logger.info("Ingrese el polinomio: ");
        String polinomio = scanner.nextLine();

        //"15x^2+8x^3-3-2x";

        String data = "";
        int j = 0;  //Contador para el vector de Strings
        int i = 0; //Contador para el vector de caracteres
        int grado = 0;
        int posicion = 0, datosUtiles = 0;
        char vectorA[] = polinomio.toCharArray();
        String vectorB[] = new String[vectorA.length];
        while (i < vectorA.length) {
            //SI(VC[i] ='+' || VC='-') &&(s!="" || s!= "-")
            if (vectorA[i] == '-') {
                if (vectorA[i + 1] == 'x') {
                    data = "-1";
                    i += 1;
                } else {
                    data = data + vectorA[i];
                    i += 1;
                }
            }
            if (Character.isDigit(vectorA[i])) {
                data = data + vectorA[i];

            }
            if (vectorA[i] == '+') {
                if (vectorA[i + 1] == 'x') {
                    data = "1";
                } else {
                    data = data + vectorA[i + 1];
                    i += 1;
                }
            }
            if (vectorA[i] == '^') {
                data = data + vectorA[i + 1];
                vectorB[j] = data;
                data = "";
                i += 1;
                j += 1;
            }
            if (vectorA[i] == 'x') {
                vectorB[j] = data;
                data = "";
                j += 1;
                if (i == vectorA.length - 1)
                {
                    vectorB[j] = "1";
                    j +=1;
                }
            }

            // if (i == vectorA.length - 1) {
            //     vectorB[j] = data;
            //     j += 1;
            //     vectorB[j] = "0";
     //   }
            if (i == vectorA.length-1) vectorB[j]= data;
            if ((data != "") && ((vectorA[i + 1] == '+' || vectorA[i + 1] == '-')))
            {
                vectorB[j] = data;
                vectorB[j + 1] = "0";
                data = "";
                j += 2;
            }
        i++;

    }
        for (i = 0; i < vectorB.length; i++) {
            if (vectorB[i] != null)
                System.out.println(vectorB[i]);
        }
        for (i = 1; vectorB[i] != null; i += 2) {
            if (Integer.parseInt(vectorB[i]) > grado) {
                grado = Integer.parseInt(vectorB[i]);
            }
        }
        System.out.println("El grado es: " + grado);
        datosUtiles = grado + 1;


        String vectorC[] = new String[datosUtiles+1];
        vectorC[0] = String.valueOf(grado);
        j = 0;
        for (i = 1; vectorB[i] != null; i += 2) {
            posicion = datosUtiles - Integer.parseInt(vectorB[i]);
            vectorC[posicion] = vectorB[j];
            j += 2;
        }
        for (i = 0; i< vectorC.length; i++){
            if( vectorC[i] == null){
                vectorC[i]="0";
            }
        }


        for (i = 0; i < vectorC.length; i++) {
            System.out.println(vectorC[i]);
        }

    }
}