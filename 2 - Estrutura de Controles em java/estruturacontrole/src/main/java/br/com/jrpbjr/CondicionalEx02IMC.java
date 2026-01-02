package br.com.jrpbjr;

import java.util.Scanner;

public class CondicionalEx02IMC {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Digite o nome da pessoa ou 'exit' para sair: ");
            var nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("exit")) {
                System.out.println("Programa finalizado.");
                break;
            }

            try {
                System.out.printf("%s, digite sua altura (ex: 1.75): ", nome);
                var altura = Double.parseDouble(scanner.nextLine());

                System.out.print("Digite seu peso: ");
                var peso = Double.parseDouble(scanner.nextLine());

                var imc = peso / (altura * altura);

                System.out.printf("IMC de %s: %.2f%n", nome, imc);

                if (imc <= 18.5) {
                    System.out.println("Abaixo do peso");
                } else if (imc <= 24.9) {
                    System.out.println("Peso ideal");
                } else if (imc <= 29.9) {
                    System.out.println("Levemente acima do peso");
                } else if (imc <= 34.9) {
                    System.out.println("Obesidade Grau I");
                } else if (imc <= 39.9) {
                    System.out.println("Obesidade Grau II (Severa)");
                } else {
                    System.out.println("Obesidade Grau III (Mórbida)");
                }

                System.out.println(); // separador visual

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite valores numéricos.\n");
            }
        }

        scanner.close();
    }
}