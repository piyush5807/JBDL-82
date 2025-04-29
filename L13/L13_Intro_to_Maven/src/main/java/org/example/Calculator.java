package org.example;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playNext = true;

        do {
            System.out.println("Enter 2 numbers...");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println("Enter the operator you want to perform");
            String op = scanner.next();
            switch (op) {
                case "+":
                    System.out.println(Calci.add(a, b));
                    break;

                case "-":
                    System.out.println(Calci.subtract(a, b));
                    break;

                case "*":
                    System.out.println(Calci.multiply(a, b));
                    break;

                case "/":
                    System.out.println(Calci.divide(a, b));
                    break;

                default: {
                    System.out.println("Invalid op");
                    playNext = false;
                }
            }
        }while(playNext);
    }
}
