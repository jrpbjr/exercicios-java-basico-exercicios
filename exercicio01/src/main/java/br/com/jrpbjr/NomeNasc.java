package br.com.jrpbjr;

import java.time.Year;
import java.util.Scanner;

public class NomeNasc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        int anoAtual = Year.now().getValue();
        int idade = anoAtual - anoNascimento;

        System.out.println("Olá " + nome + " você tem " + idade + " anos");

        scanner.close();
    }
}
