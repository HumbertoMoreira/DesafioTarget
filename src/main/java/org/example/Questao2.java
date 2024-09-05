package org.example;

import java.util.Scanner;

public class Questao2 {

    // Função para verificar se um número pertence à sequência de Fibonacci
    public static boolean eFibonacci(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int a = 0, b = 1;
        int next = a + b;

        while(next <= num){
            if (next == num){
                return true;
            }
            a = b;
            b = next;
            next = a + b;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um número:");
        int numero = sc.nextInt();

        // Verifica se o número faz parte da sequência de Fibonacci
        if (eFibonacci(numero)) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        }else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
    }
}
