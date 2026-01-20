package br.com.jrpbjr;

import java.util.Scanner;

public class CalculadoraEX01 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite a operação (soma ou subtracao): ");
        var operacao = scanner.nextLine().toLowerCase();

        System.out.print("Digite os números separados por vírgula: ");
        var entrada = scanner.nextLine();

        // Quebra a string pelos separadores ","
        var numerosTexto = entrada.split(",");

        var resultado = 0.0;

        try {
            if (operacao.equals("soma")) {
                for (var numero : numerosTexto) {
                    resultado += Double.parseDouble(numero.trim());
                }
                System.out.println("Resultado da soma: " + resultado);

            } else if (operacao.equals("subtracao")) {
                // Começa com o primeiro número
                resultado = Double.parseDouble(numerosTexto[0].trim());

                for (int i = 1; i < numerosTexto.length; i++) {
                    resultado -= Double.parseDouble(numerosTexto[i].trim());
                }
                System.out.println("Resultado da subtração: " + resultado);

            } else {
                System.out.println("Operação inválida.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: informe apenas números válidos separados por vírgula.");
        }

        scanner.close();
    }
}