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
 * Сформировать кваадратную матрицу порядка n по заданному образцо (n - четное).
 */
public class Task10SquareArray {

    public static void main(String[] args) {
        manageProgram();
    }

    private static int readIntegerNumber() {
        int number;
        boolean trueData;
        @SuppressWarnings("resource")
        Scanner inputData = new Scanner(System.in);

        number = -1;
        trueData = false;

        printMessageForReading();
        while (!isOrderPositiveAndEven(number)) {
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

    private static boolean isOrderPositiveAndEven(int number) {
        return ((number > 0) && ((number % 2) == 0) ? true : false);
    }

    private static int[][] makeMatrix(int order) {
        int[][] goalArr = new int[order][order];

        for (int i = 0; i < order; i++) {
            int k = order;
            for (int j = 0; j < order; j++) {
                if ((i + 1) % 2 != 0) {
                    goalArr[i][j] = (j + 1);
                } else {
                    goalArr[i][j] = k--;
                }
            }
        }
        return goalArr;
    }

    private static void manageProgram() {
        int matrixOrder;
        int[][] goalArr;

        matrixOrder = readIntegerNumber();

        goalArr = makeMatrix(matrixOrder);

        printMessageForWritingRezult();
        printArrayNumber(goalArr);
    }

    private static void printMessageForReading() {
        System.out.println("Enter the even positive order of the matrix n, "
                + "which needs to be made: ");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWritingRezult() {
        System.out.println("Here is made Array: ");
    }

    private static void printArrayNumber(int[][] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < inputArr[i].length; j++) {
                System.out.print(" " + inputArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}