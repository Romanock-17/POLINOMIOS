public class Polinomio {
    public static void main(String[] args) {
        String s = "", Cadena = "-15x^2+3x^4+x";
        int j = 0, i = 0;
        char VC[] = Cadena.toCharArray();
        String VS[] = new String[VC.length];

        for(i = 0; i < VC.length; i++) {
            if(VC[i] == '-' && VC[i+1] == 'x'){
                s = "-1";
                VS[j] = s;
                j++;
                i++;
            }else if(VC[i] == '-' || Character.isDigit(VC[i])){
                s = s + VC[i];
            }
            if (VC[i] == '+'){
                if (VC[i + 1] == 'x') {
                    s = "1";
                }else {
                    s = s + VC[i + 1];
                    i += 1;
                }
            }

            if(VC[i] == '+' && VC[i+1] == 'x'){
                s = "1";
                VS[j] = s;
                j++;
            }
            System.out.println("!"+i);
            System.out.println("--"+ s);
        }

        for(i=0; i<VC.length;i++){
            System.out.println(VS[i]);
        }

















    }

}



