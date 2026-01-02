package br.com.jrpbjr;

import java.util.Scanner;

public class RepeticaoEx01Tabuada {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var entrada = "";

        while (!entrada.equalsIgnoreCase("exit")) {

            System.out.print("Digite um número para a tabuada ou 'exit' para sair: ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("exit")) {
                System.out.println("Programa finalizado.");
                break;
            }

            try {
                var numero = Integer.parseInt(entrada);

                for (var i = 1; i <= 10; i++) {
                    System.out.printf("%d x %d = %d%n", numero, i, numero * i);
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número ou 'exit'.");
            }

            System.out.println(); // linha em branco
        }

        scanner.close();
    }
}
