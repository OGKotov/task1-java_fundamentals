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
 * Для данный областей составить линейную программу, которая печатает true, если
 * точка с координатмаи (x, y) принадлежит закрашенной области, и false - в
 * противном случае.
 */
public class Task4PointOwn {
    final static String COORDINATE_NAME_X = "x";
    final static String COORDINATE_NAME_Y= "y";

    public static void main(String[] args) {
        manageProgram();
    }

    private static int readIntegerCoordinate(String coordinateName) {
        int coordinate;
        @SuppressWarnings("resource")
        Scanner inputData = new Scanner(System.in);

        printMessageForReading(coordinateName);
        while (!inputData.hasNextInt()) {
            inputData.nextLine();
            printErrorMessageForReading();
            printMessageForReading(coordinateName);
        }
        coordinate = inputData.nextInt();
        return coordinate;
    }

    private static boolean isIntoArea(int x, int y) {
        boolean booleanOwn;

        booleanOwn=((x >= -2 & x <= 2) && (y >= 0 & y <= 4))
                    || ((x >= -4 & x <= 4) && (y >= -3 & y <= 0));
        return  booleanOwn;
    }

    private static void manageProgram() {
        int x;
        int y;

        x = readIntegerCoordinate(COORDINATE_NAME_X);
        y = readIntegerCoordinate(COORDINATE_NAME_Y);

        if (isIntoArea(x, y)) {
            printMessageForWriting(Boolean.TRUE);
        } else {
            printMessageForWriting(Boolean.FALSE);
        }
    }

    private static void printMessageForReading(String coordintaeName) {
        System.out.println("Enter a integer coordinate of the point " + coordintaeName + ":");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(boolean boleanOwn) {
        System.out.println("The point belongs to the shaded area: " + boleanOwn);
    }
}