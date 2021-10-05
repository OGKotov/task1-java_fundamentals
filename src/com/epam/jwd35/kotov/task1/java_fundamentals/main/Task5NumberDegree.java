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
 * Даны три действительных числа. Вовзвести в квадрат те из ник, знкчения которых
 * не отрицательны, и в четвертую степениь - отрицательные.
 */
public class Task5NumberDegree {
    final static String NUMBER_NAME_1 = "number1";
    final static String NUMBER_NAME_2 = "number2";
    final static String NUMBER_NAME_3 = "number3";

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

    private static double calculateRezult(double number) {
        int possitiveDegree = 3;
        int negatieveDegree = 4;
        double rezult;

        if (number >= 0) {
            rezult = Math.pow(number, possitiveDegree);
        } else {
            rezult = Math.pow(number, negatieveDegree);
        }
        return rezult;
    }

    private static int calculateDegree(double number) {
        int possitiveDegree = 3;
        int negatieveDegree = 4;
        int degree;
        if (number >= 0) {
            degree = possitiveDegree;
        } else {
            degree = negatieveDegree;
        }
        return degree;
    }

    private static void manageProgram() {
        double number1;
        double number2;
        double number3;
        double rezult;
        int degree;

        number1 = readDoubleNumber(NUMBER_NAME_1);
        number2 = readDoubleNumber(NUMBER_NAME_2);
        number3 = readDoubleNumber(NUMBER_NAME_3);

        rezult = calculateRezult(number1);
        degree = calculateDegree(number1);
        printMessageForWriting(NUMBER_NAME_1, degree, rezult);

        rezult = calculateRezult(number2);
        degree = calculateDegree(number2);
        printMessageForWriting(NUMBER_NAME_2, degree, rezult);

        rezult = calculateRezult(number3);
        degree = calculateDegree(number3);
        printMessageForWriting(NUMBER_NAME_1, degree, rezult);
    }

    private static void printMessageForReading(String numberName) {
        System.out.println("Enter a double " + numberName + ":");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(String numberName, int degreeValue,
                                               double rezult) {
        System.out.println(numberName + " raised to the degree of " + degreeValue
                + ": " + rezult);
    }
}