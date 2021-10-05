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
 * В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые
 * кратные данному K.
 */
public class Task8MultipleSum {
    static int[] intNumbersArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 44, 21};

    public static void main(String[] args) {
        manageProgram();
    }

    private static int readIntegerNumber() {
        int number;
        boolean trueData;
        @SuppressWarnings("resource")
        Scanner inputData = new Scanner(System.in);

        number = 0;
        trueData = false;

        printMessageForReading();
        while (!isPositiveInteger(number)) {
            if (trueData) {
                printErrorMessageForReading();
                printMessageForReading();
            }
            while (!inputData.hasNextInt()) {
                inputData.nextLine();
                printErrorMessageForReading();
                printMessageForReading();
            }
            number = inputData.nextInt();
            trueData = true;
        }
        return number;
    }

    private static boolean isPositiveInteger(int number) {
        return ((number > 0) ? true : false);
    }

    private static int calculateSumMultipe(int multiple) {
        int sum;

        sum = 0;
        for (int intNum : intNumbersArr) {
            if (intNum % multiple == 0) {
                sum += intNum;
            }
        }
        return sum;
    }

    private static void manageProgram() {
        int sum;
        int multiple;

        printMessageForWritingArr();
        printArrayNumber(intNumbersArr);

        multiple = readIntegerNumber();
        sum = calculateSumMultipe(multiple);
        printMessageForWritingRezult(multiple, sum);
    }

    private static void printMessageForReading() {
        System.out.println("Enter a integer positive multiple :");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWritingArr() {
        System.out.println("Here is Array: ");
    }

    private static void printMessageForWritingRezult(int multiple, int sum) {
        System.out.println("Sum of array numbers that are multiples " + multiple + ": " + sum);
    }

    static void printArrayNumber(int[] Arr) {
        for (int realNum : Arr) {
            System.out.print(realNum + "  ");
        }
        System.out.println();
    }
}