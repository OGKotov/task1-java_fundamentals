/*
 * Epam
 * JWD 35
 * Oleg Kotov
 * Task1
 * Java fundamentals
 * 28-09-2021
 */
package com.epam.jwd35.kotov.task1.java_fundamentals.main;

import java.util.Scanner;

/*
 * Вычислите значение выражения по формуле(все переменные принимают действительные значения).
 */
public class Task2ExpressionValue {
    final static String VARIBALE_NAME_A = "a";
    final static String VARIBALE_NAME_B = "b";
    final static String VARIBALE_NAME_C = "c";

    public static void main(String[] args) {
        manageProgram();
    }

    private static double readDoubleNumber(String numberName) {
        double number;
        boolean trueData;
        @SuppressWarnings("resource")
        Scanner inputData = new Scanner(System.in);

        printMessageForReading(numberName);
        while (!inputData.hasNextDouble()) {
                inputData.nextLine();
                printErrorMessageForReading();
                printMessageForReading(numberName);
        }
        number = inputData.nextDouble();
        return number;
    }

   private static double calculateExpression(double a, double b, double c) {
       double rezult;

       rezult = ((b + Math.sqrt(Math.pow(b, 2) + 4.0 * a * c)) / (2.0 * a)) - Math.pow(a, 3)
               * c + Math.pow(b, -2);

        return rezult;
   }

    private static void manageProgram() {
        double a;
        double b;
        double c;
        double rezult;

        a = readDoubleNumber(VARIBALE_NAME_A);
        b = readDoubleNumber(VARIBALE_NAME_B);
        c = readDoubleNumber(VARIBALE_NAME_C);

        rezult = calculateExpression(a, b, c);

        if(!Double.isNaN(rezult)) {
            printMessageForWriting(rezult);
        } else {
            printMessageForWritingIfNan();
        }

    }

    private static void printMessageForReading(String variableName) {
        System.out.println("Enter a double " + variableName + ":");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(double experssionValue) {
        System.out.println("The rezult of the expression: " + experssionValue);
    }

    private static void printMessageForWritingIfNan() {
        System.out.println("We can't find rezult because we can't calculate the "
                           + "square root of a negative number.");
    }
}