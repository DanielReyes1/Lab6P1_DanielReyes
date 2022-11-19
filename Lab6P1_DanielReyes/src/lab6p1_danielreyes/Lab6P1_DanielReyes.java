
package lab6p1_danielreyes;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_DanielReyes {

 static Scanner leer = new Scanner(System.in);
 static Random aleatorio = new Random();
 
    public static void main(String[] args) {
        
        int resp;
        do{
            System.out.println();
            System.out.println("--------Menu--------");
            System.out.println("1- Turing");
            System.out.println("2- Constante de Kaprekar");
            System.out.println("3- Salir del sistema");
            System.out.print("Ingrese una opcion: ");
            resp = leer.nextInt();
            
            switch (resp){
                case 1:  
                    System.out.print("Ingrese el tamaño del arreglo: ");
                    int size = leer.nextInt();
                    int [] arreglo = lecturarandom(size);
                    System.out.print("Arreglo generado: ");
                    imprimir(arreglo);
                    System.out.print("Ingrese la cadena de instrucciones: ");
                    String comando = leer.next().toUpperCase();
                    int acum = 0;
                    for (int i = 0; i < comando.length(); i++){
                        char a = comando.charAt(i);
                        switch (a){
                            case 'R':
                            case 'L':
                            case 'X':
                                acum++;
                                break;
                        }
                    }// for para validar que sean "r" "x" "l"
                    if ( acum == comando.length() ){
                    System.out.print("Cadena generada: "+ resultado(comando, arreglo));
                    }
                    else{
                        System.out.println("Las instrucciones incluyen letras que no son R, X, L");
                    }
                    break;
                        
                case 2:
                    System.out.print("Ingrese un numero entero de 4 dígitos: ");
                    int numeros = leer.nextInt();
                    String numbers = Integer.toString(numeros);
                    if(numbers.length()== 4){
                        int b =  numbers.charAt(0);
                        int cont = 0;
                        for (int i = 1; i < 4; i++){
                            char a = numbers.charAt(i);
                            if (a == b){
                                cont++;
                            }
                        }// for
                        if (cont == 3){
                            System.out.println("Su numero no puede ser el mismo digito");
                        }// son 4 digitos IGUALES
                        else {
                            int [] original = lectura(numeros);
                            int [] menor = menormayor(original);
                            int [] mayor = mayormenor(original);
                            int mayorint = numeroint(mayor);
                            int menorint = numeroint(menor);
                            System.out.println(numeroint(mayor)+ " - "+ numeroint(menor)+ " = " + resta(mayorint, menorint));
                            int a = resta(mayorint,menorint);
                            //salida
                            while (a != 6174){
                                
                                int subtotal = resta(mayorint, menorint);
                                int [] suboriginal = lectura(subtotal);
                                int [] submenor = menormayor(suboriginal);
                                int [] submayor = mayormenor(suboriginal);
                                mayorint = numeroint(submayor);
                                menorint = numeroint(submenor);
                                System.out.println(numeroint(submayor)+ " - "+ numeroint(submenor)+ " = " + resta(mayorint, menorint));
                                a = resta(mayorint,menorint); 
                            }
                        }// son 4 digitos DIFERENTES
                        
                    }// if que demuestar que son 4 digitos
                    else {
                        System.out.println("Su numero debe ser de 4 digitos");
                    }// else si el numero no tiene 4
                    
                    break;
                }
            
        }while (resp != 3);
        System.out.println("Ha salido del sistema");
    }// main
    
    public static int [] lecturarandom(int numero){
        int [] temporal = new int [numero];
        for (int i = 0; i < temporal.length; i++){
            temporal [i] = 1 + aleatorio.nextInt(9);
        }
        return temporal;
    }
    public static void imprimir( int [] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
            
        }
        System.out.println();
    }
    public static String resultado(String instrucciones, int [] array){
        String temporal = "";
        int apuntador = 0;
        for (int i = 0; i < array.length; i++){
            if (apuntador > array.length){
                
                break;
            }// if 
            else{
                char a = instrucciones.charAt(i);
                switch (a){
                    case 'R' :
                         
                        apuntador++;
                        break;
                    case 'L' :
                        
                        apuntador--;
                        break;
                    case 'X':
                        temporal += Integer.toString(array[apuntador]);
                        break;
                }// switch
            }
        }// for
        return temporal;
    }
    
    public static int [] lectura (int numero){
        int [] temporal = new int [4];
        int num1, num2, num3, num4;
        num1 = numero / 1000;
        numero = numero - (num1 * 1000);
        num2 = numero / 100;
        numero = numero - (num2 * 100);
        num3 = numero / 10;
        numero = numero - (num3 * 10);
        num4 = numero;
        temporal[0] = num1;
        temporal[1] = num2;
        temporal[2] = num3;
        temporal[3] = num4;
        return temporal;
    }
    public static int numeroint(int [] array){
        int temporal = 0;
        temporal += array[3];
        temporal +=  10*array[2];
        temporal += 100*array[1];
        temporal += 1000*array[0];
        return temporal;
    }
    public static int [] menormayor (int [] array){
        int [] temporal = new int [4];
        int contador = 0;
        for (int i = 0; i <= 9; i++){    
            for (int k = 0; k < 4; k++){
                int a = array[k];
                if (a == i){
                    temporal[contador] = a;
                    contador++;
                }
            }
        }
        return temporal;
    }
    public static int [] mayormenor (int [] array){
        int [] temporal = new int [4];
        int contador = 0;
        for (int i = 9; i >= 0; i--){    
            for (int k = 0; k < 4; k++){
                int a = array[k];
                if (a == i){
                    temporal[contador] = a;
                    contador++;
                }
            }
        }
        return temporal;
    }
    public static int resta (int num1, int num2){
        int temporal = 0;
        temporal = num1-num2;
        return temporal;
    }
    
}// public class
