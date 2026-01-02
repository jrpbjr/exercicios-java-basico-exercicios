package br.com.jrpbjr;

import java.util.Scanner;

public class RepeticaoEx03ParImpar {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        var inicio = scanner.nextInt();

        System.out.print("Digite o segundo número (maior que o primeiro): ");
        var fim = scanner.nextInt();

        System.out.print("Escolha (p) par ou (i) ímpar: ");
        var opcao = scanner.next().equalsIgnoreCase("p");

        for (var i = fim; i >= inicio; i--) {
            if (opcao && i % 2 == 0) {
                System.out.print(i + " ");
            } else if (!opcao && i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}