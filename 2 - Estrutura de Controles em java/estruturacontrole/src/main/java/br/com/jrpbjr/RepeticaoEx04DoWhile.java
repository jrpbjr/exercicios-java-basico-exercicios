package br.com.jrpbjr;

import java.util.Scanner;

public class RepeticaoEx04DoWhile {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o número inicial: ");
        var divisor = scanner.nextInt();

        int numero;

        do {
            System.out.print("Digite um número: ");
            numero = scanner.nextInt();

            if (numero < divisor) {
                continue;
            }

            System.out.println("Resto da divisão: " + (numero % divisor));

        } while (numero % divisor == 0);

        System.out.println("Execução finalizada.");

        scanner.close();
    }
}
