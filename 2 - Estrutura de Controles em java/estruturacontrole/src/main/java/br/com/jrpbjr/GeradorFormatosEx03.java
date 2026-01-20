package br.com.jrpbjr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeradorFormatosEx03 {
    record Campo(String nome, Object valor) {}

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var campos = new ArrayList<Campo>();

        System.out.println("Informe os campos no formato NOME;VALOR;TIPO");
        System.out.println("Tipos: texto, inteiro, decimal, boolean, data, datahora");
        System.out.println("Digite 'exit' para finalizar\n");

        while (true) {
            System.out.print("> ");
            var linha = scanner.nextLine();

            if (linha.equalsIgnoreCase("exit")) {
                break;
            }

            var partes = linha.split(";");
            if (partes.length != 3) {
                System.out.println("Entrada inválida.");
                continue;
            }

            var nome = partes[0];
            var valorTexto = partes[1];
            var tipo = partes[2].toLowerCase();

            try {
                Object valor = parseValor(valorTexto, tipo);
                campos.add(new Campo(nome, valor));
            } catch (Exception e) {
                System.out.println("Erro ao processar valor.");
            }
        }

        System.out.println("\n=== JSON ===");
        System.out.println(gerarJson(campos));

        System.out.println("\n=== XML ===");
        System.out.println(gerarXml(campos));

        System.out.println("\n=== YAML ===");
        System.out.println(gerarYaml(campos));

        scanner.close();
    }

    private static Object parseValor(String valor, String tipo) {
        return switch (tipo) {
            case "texto" -> valor;
            case "inteiro" -> Integer.parseInt(valor);
            case "decimal" -> Double.parseDouble(valor);
            case "boolean" -> Boolean.parseBoolean(valor);
            case "data", "datahora" -> valor; // mantido como string (ISO)
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }

    // ---------- JSON ----------
    private static String gerarJson(List<Campo> campos) {
        var sb = new StringBuilder("{\n");

        for (int i = 0; i < campos.size(); i++) {
            var c = campos.get(i);
            sb.append("  \"").append(c.nome()).append("\": ");
            sb.append(formatJsonValor(c.valor()));

            if (i < campos.size() - 1) sb.append(",");
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    private static String formatJsonValor(Object v) {
        if (v instanceof String) {
            return "\"" + v + "\"";
        }
        return v.toString();
    }

    // ---------- XML ----------
    private static String gerarXml(List<Campo> campos) {
        var sb = new StringBuilder("<root>\n");

        for (var c : campos) {
            sb.append("  <").append(c.nome()).append(">");
            sb.append(c.valor());
            sb.append("</").append(c.nome()).append(">\n");
        }

        sb.append("</root>");
        return sb.toString();
    }

    // ---------- YAML ----------
    private static String gerarYaml(List<Campo> campos) {
        var sb = new StringBuilder();

        for (var c : campos) {
            sb.append(c.nome()).append(": ").append(c.valor()).append("\n");
        }

        return sb.toString();
    }
}