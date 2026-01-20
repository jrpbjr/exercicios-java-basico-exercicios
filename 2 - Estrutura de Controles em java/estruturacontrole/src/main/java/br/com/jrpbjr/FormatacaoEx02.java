package br.com.jrpbjr;

import java.util.Scanner;

public class FormatacaoEx02 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o telefone (com ou sem formatação): ");
        var entrada = scanner.nextLine();

        var somenteDigitos = entrada.replaceAll("\\D", ""); // remove tudo que não é número

        var resultado = formatar(somenteDigitos);

        if (resultado == null) {
            System.out.println("Entrada inválida: não corresponde a telefone fixo ou celular.");
        } else {
            System.out.println(resultado);
        }

        scanner.close();
    }

    private static String formatar(String digitos) {
        return switch (digitos.length()) {
            case 8 -> "Telefone fixo (sem DDD): " + formatFixoSemDDD(digitos);
            case 9 -> "Celular (sem DDD): " + formatCelularSemDDD(digitos);
            case 10 -> "Telefone fixo (com DDD): " + formatFixoComDDD(digitos);
            case 11 -> "Celular (com DDD): " + formatCelularComDDD(digitos);
            default -> null;
        };
    }

    private static String formatFixoSemDDD(String d) {
        // xxxx-xxxx
        return d.substring(0, 4) + "-" + d.substring(4);
    }

    private static String formatCelularSemDDD(String d) {
        // xxxxx-xxxx
        return d.substring(0, 5) + "-" + d.substring(5);
    }

    private static String formatFixoComDDD(String d) {
        // (xx)xxxx-xxxx
        return "(" + d.substring(0, 2) + ")" + d.substring(2, 6) + "-" + d.substring(6);
    }

    private static String formatCelularComDDD(String d) {
        // (xx)xxxxx-xxxx
        return "(" + d.substring(0, 2) + ")" + d.substring(2, 7) + "-" + d.substring(7);
    }
}