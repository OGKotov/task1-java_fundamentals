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
 * Составить линейную программу, печатающую значение true, если указанное
 * выссказывание является истинным, и false - в противном случае: сумма
 * двух первых цифр заданного четырехзначного числа равна сумме двух его
 * последних цифр.
 */
public class Task1TrueOrFalse {

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
        while (!isFourDigitInteger(number)) {
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

    private static boolean isFourDigitInteger(double number) {
        return (((number > 999) && (number < 10000)) ? true : false);
    }

    private static int[] breakNumber(int number) {
        int base;
        int numberArr[] = new int[4];

        base = 10;

        for (int i = 0; (i < numberArr.length) && (number != 0); i++) {
            numberArr[i] = number % base;
            number = number / base;
        }
        return numberArr;
    }

    private static boolean isSumEquals(int[] numberArr) {
        int sum1;
        int sum2;

        sum1 = numberArr[0] + numberArr[1];
        sum2 = numberArr[2] + numberArr[3];

        return ((sum1 == sum2) ? true : false);
    }

    private static void manageProgram() {
        int number;
        int[] digitsArr;

        number = readIntegerNumber();
        digitsArr = breakNumber(number);

        if (isSumEquals(digitsArr)) {
            printMessageForWriting(Boolean.TRUE);
        } else {
            printMessageForWriting(Boolean.FALSE);
        }
    }

    private static void printMessageForReading() {
        System.out.println("Enter a four-digit integer number:");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(boolean booleanValue) {
        System.out.println("The sum of the first two digits is equal to the sum " +
                "of the last two digits: " + booleanValue);
    }
}