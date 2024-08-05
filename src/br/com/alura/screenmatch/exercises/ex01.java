package br.com.alura.screenmatch.exercises;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro numero");
        Integer firstNumber = sc.nextInt();

        System.out.println("Digite o segundo numero");
        Integer secondNumber = sc.nextInt();

        try {
            Integer division = firstNumber / secondNumber;
            System.out.println(division);
        } catch (ArithmeticException e) {
            System.out.println("Não é possível dividir por 0");
        }
    }
}
