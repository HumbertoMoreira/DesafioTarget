package org.example;

import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string para ser invertida:");
        String string = scanner.nextLine();

        // converter string em um array de caracteres
        char[] caracteres = string.toCharArray();

        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char aux = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = aux;

            inicio++;
            fim--;
        }

        //converte o array de volta em string
        String stringInvertida = new String(caracteres);

        System.out.println("String invertida: " + stringInvertida);
    }
}
