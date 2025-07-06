package ordenamiento.main;


import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    SecureRandom randomE = new SecureRandom();
    public static int[] Peso = new int[35];
    public static int[] Edad = new int[52];
    public static int[] Nss = new int[100];
    public static int[] Altura = new int[35];
    public static String[] nombres = new String[]{"Laura", "Adrian", "Angel", "Eduardo", "Alejandra", "Lesly", "Mauricio", "Claudio", "Jessica", "Karina", "Miguel", "Gregorio", "Juan",
            "Jenifer", "Oralia", "Gabriela", "Jose", "Hector", "Christofer", "Angel", "Maricruz", "Alondra", "Fernanda",
            "Andres", "Melani", "Beatriz", "Abigail", "Guillermo", "Raul", "Naomi", "Sandra", "Vivian", "Daniela", "Marco", "Paola", "Alan", "Araceli", "Angeles",
            "Betsabeth", "Rosario", "Mayra", "Diego", "Dulce", "Gerardo", "Ileana", "Jorge", "Jose", "Karla", "Marlen", "Nicolas", "Adolfo","Sarahi","Adriana","Aide","Aldo","Alexis","Alicia"};
    public static SecureRandom randomNom = new SecureRandom();
    public static SecureRandom randomPeso = new SecureRandom();
    public static SecureRandom randomNSS = new SecureRandom();
    public static SecureRandom randomAltu = new SecureRandom();
    public static SecureRandom randomEdad = new SecureRandom();

    public static void Ramdom() {
        for (int i = 0; i < 52; i++) {
            Edad[i] = i + 18;
        }
        for (int i = 0; i < 35; i++) {
            Altura[i] = (i * 2) + 140;
        }
        for (int i = 45; i < 80; i++) {
            Peso[i-45] = i;
        }
        for (int i = 0; i < 100; i++) {
            Nss[i] = 2001 + i;
        }
    }

    public static void main(String[] args) {
        String option;
        Scanner op = new Scanner(System.in);
        Gente[] gente = new Gente[100];
        Double numeroDenisse = 8.0; 
        Ramdom();
        System.out.println("-------------------------------Datos----------------------------------------");
        for (int i = 0; i < 100; i++) {
        	//Para imprimir de manera ordenanda a la gente
            gente[i] = new Gente();
            gente[i].setNombre(nombres[randomNom.nextInt(57)]);
            gente[i].setAltura(Altura[randomAltu.nextInt(35)]);
            gente[i].setEdad(Edad[randomEdad.nextInt(52)]);
            gente[i].setNss(Nss[randomNSS.nextInt(100)]);
            gente[i].setPeso(Peso[randomPeso.nextInt(35)]);
            System.out.println("Nombre: " + gente[i].getNombre() + " Altura: " + gente[i].getAltura() + "cm  Edad: " + gente[i].getEdad() + " NSS:" + gente[i].getNss() + " Peso: " + gente[i].getPeso() + "kg");
        }
        System.out.println();
        System.out.println();
        System.out.println("---------------------------Datos ordenados(Peso) con insertion sort----------------------------------");
        for (int i = 1; i < gente.length; i++) {
            Gente auxI = gente[i];
            int j = i - 1;
            while (j >= 0 && gente[j].getPeso() > auxI.getPeso()) {
                gente[j + 1] = gente[j];
                j--;
            }
            gente[j + 1] = auxI;
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Nombre: " + gente[i].getNombre() + " Altura: " + gente[i].getAltura() + "cm  Edad: " + gente[i].getEdad() + " NSS:" + gente[i].getNss() + " Peso: " + gente[i].getPeso() + "kg");
        }
        System.out.println();
        System.out.println();
        System.out.println("---------------------------Datos ordenados(Altura) con Quick sort----------------------------------");
        quick(gente, 0, gente.length - 1);
        for (int i = 0; i < 100; i++) {
            System.out.println("Nombre: " + gente[i].getNombre() + " Altura: " + gente[i].getAltura() + "cm  Edad: " + gente[i].getEdad() + " NSS:" + gente[i].getNss() + " Peso: " + gente[i].getPeso() + "kg");
        }

        System.out.println();
        System.out.println();
        System.out.println("---------------------------Datos ordenados(Edad) con Merge sort----------------------------------");
        gente=Merge(gente);
        for (int i = 0; i < 100; i++) {
            System.out.println("Nombre: " + gente[i].getNombre() + " Altura: " + gente[i].getAltura() + "cm  Edad: " + gente[i].getEdad() + " NSS:" + gente[i].getNss() + " Peso: " + gente[i].getPeso() + "kg");
        }
        System.out.println();
        System.out.println();
        System.out.println("---------------------------Datos ordenados(NSS) con funcion  sort de java----------------------------------");
        Arrays.sort(gente);
        for (int i = 0; i < 100; i++) {
            System.out.println("Nombre: " + gente[i].getNombre() + " Altura: " + gente[i].getAltura() + "cm  Edad: " + gente[i].getEdad() + " NSS:" + gente[i].getNss() + " Peso: " + gente[i].getPeso() + "kg");
        }

    }

    public static void quick(Gente[] arreglo, int primero, int ultimo) {
        int i = primero, j = ultimo;
        Gente aux;
        Gente pivote = arreglo[(primero + ultimo) / 2];
        do {
            while (arreglo[i].getAltura() < pivote.getAltura()) {
                i++;
            }
            while (arreglo[j].getAltura() > pivote.getAltura()) {
                j--;
            }
            if (i <= j) {
                aux = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quick(arreglo, primero, j);
        }
        if (i < ultimo) {
            quick(arreglo, i, ultimo);
        }
    }

    public static Gente[] Merge(Gente[] arreglo) {
        int i=0, j=0, k=0;
        if (arreglo.length > 1) {
            int nIzq = arreglo.length / 2;
            int nDer = arreglo.length - nIzq;
            Gente[] izq = new Gente[nIzq];
            Gente[] der = new Gente[nDer];
            for (i = 0; i < nIzq; i++) {
                izq[i] = arreglo[i];
            }
            for (i = nIzq; i < nIzq + nDer; i++) {
                der[i - nIzq] = arreglo[i];
            }
            izq = Merge(izq);
            der = Merge(der);
            i = 0;
            j = 0;
            k = 0;
            while (izq.length != j && der.length != k) {
                if (izq[j].getEdad() < der[k].getEdad()) {
                    arreglo[i] = izq[j];
                    i++;
                    j++;
                }
                else{
                    arreglo[i]=der[k];
                    i++;
                    k++;
                 }
            }

            while (izq.length!=j){
                arreglo[i]=izq[j];
                i++;
                j++;
            }

            while (der.length!=k){
                arreglo[i]=der[k];
                i++;
                k++;
            }

        }
        return arreglo;
    }
}