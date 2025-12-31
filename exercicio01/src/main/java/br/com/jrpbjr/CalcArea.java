package br.com.jrpbjr;

import java.util.Scanner;

public class CalcArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do lado do quadrado: ");
        double lado = scanner.nextDouble();

        double area = lado * lado;

        System.out.println("A área do quadrado é: " + area);

        scanner.close();
    }
}
