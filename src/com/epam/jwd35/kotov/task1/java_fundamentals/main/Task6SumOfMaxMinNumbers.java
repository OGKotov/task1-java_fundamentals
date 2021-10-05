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
 * Написать программу нахождения суммы большего и меньшего из трех чисел.
 */
public class Task6SumOfMaxMinNumbers {
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

    private static double findMinNumber(double number1, double number2, double number3) {
        double minNumber;

        if (number1 < number2) {
            minNumber = number1;
        } else {
            minNumber = number2;
        }
        if (number3 < minNumber) {
            minNumber = number3;
        }

        return minNumber;
    }

    private static double findMaxNumber(double number1, double number2, double number3) {
        double maxNumber;

        if (number1 > number2) {
            maxNumber = number1;
        } else {
            maxNumber = number2;
        }
        if (number3 > maxNumber) {
            maxNumber = number3;
        }

        return maxNumber;
    }

    private static double calculateSumMaxMin(double number1, double number2, double number3) {
        double sum;
        double minNumber;
        double maxNumber;

        minNumber = findMinNumber(number1, number2, number3);
        maxNumber = findMaxNumber(number1, number2, number3);
        sum = minNumber + maxNumber;

        return sum;
    }

    private static void manageProgram() {
        double number1;
        double number2;
        double number3;
        double sum;

        number1 = readDoubleNumber(NUMBER_NAME_1);
        number2 = readDoubleNumber(NUMBER_NAME_2);
        number3 = readDoubleNumber(NUMBER_NAME_3);
        sum = calculateSumMaxMin(number1, number2, number3);

        printMessageForWriting(sum);
    }

    private static void printMessageForReading(String numberName) {
        System.out.println("Enter a double " + numberName + ":");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(double sum) {
        System.out.println("The sum of MIN and MAX number is: " + sum);
    }
}