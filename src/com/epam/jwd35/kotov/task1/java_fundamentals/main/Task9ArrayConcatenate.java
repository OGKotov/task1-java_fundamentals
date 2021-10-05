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
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объеденить их в одном массиве, включив второй массив между k-м и (k+1) - м элеметом
 * первого.
 */
public class Task9ArrayConcatenate {
    final static String ARRAY_NUMBER_NAME1 = "ONE";
    final static String ARRAY_NUMBER_NAME2 = "ONE";
    static int[] oneArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 44, 21};
    static int[] twoArr = {10, 15, 56, 17, 34, 56, 87};

    public static void main(String[] args) {
        manageProgram();
    }

    private static int readIntegerNumber(int oneArrLenght) {
        int number;
        boolean trueData;
        @SuppressWarnings("resource")
        Scanner inputData = new Scanner(System.in);

        number = -1;
        trueData = false;

        printMessageForReading(oneArrLenght);
        while (!isIndexFirstArr(number, oneArrLenght)) {
            if (trueData) {
                printErrorMessageForReading();
                printMessageForReading(oneArrLenght);
            }
            while (!inputData.hasNextInt()) {
                inputData.nextLine();
                printErrorMessageForReading();
                printMessageForReading(oneArrLenght);
            }
            number = inputData.nextInt();
            trueData = true;
        }
        return number;
    }

    private static boolean isIndexFirstArr(int number, int arrLength) {
        return ((number >= 0 && number < arrLength) ? true : false);
    }

    private static int[] joinArrays(int firstArrIndex) {
        int oneIndex;
        int twoIndex;
        int[] joinArr = new int[oneArr.length + twoArr.length];

        oneIndex = 0;
        twoIndex = 0;
        for (int index = 0; index < joinArr.length; index++) {
            if (index > firstArrIndex && twoIndex < twoArr.length) {
                joinArr[index] = twoArr[twoIndex++];
            } else {
                joinArr[index] = oneArr[oneIndex++];
            }
        }
        return joinArr;
    }

    private static void manageProgram() {
        int firstArrIndex;
        int[] joinArr;

        printMessageForWritingArr(ARRAY_NUMBER_NAME1);
        printArrayNumber(oneArr);
        printMessageForWritingArr(ARRAY_NUMBER_NAME2);
        printArrayNumber(twoArr);

        firstArrIndex = readIntegerNumber(oneArr.length);

        joinArr = joinArrays(firstArrIndex);

        printMessageForWritingRezult();
        printArrayNumber(joinArr);
    }

    private static void printMessageForReading(int arrLength) {
        System.out.println("Enter index first Array after that to insert second Array. " +
                "Indext must be from 0 to  " + arrLength + " :");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWritingArr(String arrayNumberName) {
        System.out.println("Here is Array " + arrayNumberName + ": ");
    }

    private static void printMessageForWritingRezult() {
        System.out.println("Join array: ");
    }

    static void printArrayNumber(int[] Arr) {
        for (int realNum : Arr) {
            System.out.print(realNum + "  ");
        }
        System.out.println();
    }
}