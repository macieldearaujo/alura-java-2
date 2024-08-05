package br.com.alura.screenmatch.exercises.principal;

import br.com.alura.screenmatch.exercises.exceptions.SenhaInvalidaException;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma senha:");
        var password = sc.nextLine();

        try {
            validPassword(password);
        } catch(SenhaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validPassword(String password) {
        if(password.length() < 8) {
            throw new SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres");
        }
    }
}
