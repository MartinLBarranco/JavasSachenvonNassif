public class Main {
    /*
    EJERCICIO 1:
    Dados dos strings, dar el primer indice en el que no son iguales

    EJERCICIO 2:
    Dados a, b decir si a es multiplo de b usando solo la resta.
     */
    public static int max(int a, int b){
        if (a <= b){
            return a;
        } else {
            return b;
        }
    }

    public static int primerIndice(String str1, String str2){
        int long_max = max(str1.length(), str2.length());
        for (int i = 0; i < long_max; i++){
            if (str1.charAt(i) != str2.charAt(i)){
                return i;
            }
        }
        return long_max;
    }

    public static boolean esMultiploADeB(int a, int b){
        if (a == b){
            return true;
        } else if (a < b){
            return false;
        }else{
            return esMultiploADeB(a-b, b);
        }
    }
/*
    for(int i = 0; i< lista.length; ++i){
        if (sublista[i] != lista[i]){
            return _acumulador;
        }
    }
*/

    public static boolean esSubLista(int[] sublista, int[] lista, boolean _acumulador){
        if (sublista == null){                         // si la sublista esta vacia, siempre es contenida, devuelve true
            return !_acumulador;
        }else if (lista == null){                      //si la lista es vacia, nada esta contenido, da false
            return _acumulador;
        }else if (sublista.length >= lista.length){    //Si la sublista es menor o igaul, se comprueba y se checkea por lo menos el cacho que sea posible
            for(int i = 0; i< lista.length; ++i){
                if (lista[i] != sublista[i]){
                    return _acumulador;
                }
            }
            return !_acumulador;
        } else {                                        //Si sublista es menor que lista
            int[] nueva_lista = new int[lista.length - 1];
            for(int i = 1; i < lista.length; ++i){
                nueva_lista[i-1] = lista[i];
            }
            while(!_acumulador){
                for(int i = 0; i < sublista.length; ++i){
                    if (sublista[i] != lista[i]){
                        return esSubLista(sublista, nueva_lista, _acumulador);
                    }
                }
            }
            return !_acumulador;
        }
    }

    public static void main(String[] args){
        String var1 = "pgnp";
        String var2 = "pgna";

        int num1 = 50;
        int num2 = 21;

        int[] lista = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[] sublista = new int[]{4,5,6};

        System.out.println(primerIndice(var1, var2)); // returns 3
        System.out.println(esMultiploADeB(num1, num2)); // returns false
        System.out.println(esSubLista(sublista, lista, false));  //returns true
    }
}
