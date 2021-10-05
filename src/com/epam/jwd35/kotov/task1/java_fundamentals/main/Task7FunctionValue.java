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
 * Составить программу для вычисления значений функции F(x) на отрезку [a, b] с шагом
 * h. Результат представить в виде таблицы, первый столбец которой значение аргумента,
 * второй - соответствующее значение функции:
 * F(x) = sin^2(x) - cos(2x).
 */
public class Task7FunctionValue {
    final static String START_MESSAGE = "Start point";
    final static String FINISH_MESSAGE = "Finish point";
    final static String STEP_MESSAGE = "Step";

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

    private static double[] calculateFunction(double startPoint, double endPoint,
                                              double step) {
        double argument;
        double funcValue;
        double[] argumentAndFuncValue;
        int argumetnAdnFuncValueNumber;

        argumetnAdnFuncValueNumber = ((int) ((endPoint - startPoint) / step) + 1) * 2;
        argumentAndFuncValue = new double[argumetnAdnFuncValueNumber];

        int i = 0;
        for (double point = startPoint; (i < argumentAndFuncValue.length)
                && (point <= endPoint); point += step) {
            argument = point;
            funcValue = Math.pow(Math.sin(argument), 2) - Math.cos((2 * argument));
            argumentAndFuncValue[i++] = argument;
            argumentAndFuncValue[i++] = funcValue;
        }
        return argumentAndFuncValue;
    }

    private static boolean isStartMoreFinish(double startPoint, double finishePoint) {
        return ((startPoint >= finishePoint) ? true : false);
    }

    private static boolean isStepMoreSegment(double startPoint, double finishePoint,
                                             double step) {
        double segment;

        segment = finishePoint - startPoint;
        return ((step > segment) ? true : false);
    }

    private static void manageProgram() {
        double startPoint;
        double endPoint;
        double step;
        double argument;
        double funcValue;
        double[] rezultArr;

        startPoint = readDoubleNumber(START_MESSAGE);
        endPoint = readDoubleNumber(FINISH_MESSAGE);
        step = readDoubleNumber(STEP_MESSAGE);

        if (isStartMoreFinish(startPoint, endPoint)) {
            printMessageForWritingIfStartMoreFinish();
            System.exit(0);
        }

        if (isStepMoreSegment(startPoint, endPoint, step)) {
            printMessageForWritingIfStepMoreSegment();
            System.exit(0);
        }

        rezultArr = calculateFunction(startPoint, endPoint, step);
        printMessageForWriting(startPoint, endPoint, step);
        for (int i = 0; i < rezultArr.length; i += 2) {
            argument = rezultArr[i];
            funcValue = rezultArr[i + 1];
            printMessageForWritingForFunction(argument, funcValue);
        }
    }

    private static void printMessageForReading(String message) {
        System.out.println("Enter a double " + message + ":");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(double startPioint, double finishPoint,
                                               double step) {
        System.out.println("Function value from " + startPioint + " to " + finishPoint
                + " with step " + step + ":");
    }

    private static void printMessageForWritingForFunction(double argument,
                                                          double functionValue) {
        System.out.printf("Argument %8.3f      Function %8.3f \n", argument, functionValue);
    }

    private static void printMessageForWritingIfStartMoreFinish() {
        System.out.println("Incorrect data entered. " + START_MESSAGE + " more or equals than "
                + FINISH_MESSAGE + ".");
    }

    private static void printMessageForWritingIfStepMoreSegment() {
        System.out.println("Incorrect data entered. " + STEP_MESSAGE + " more than segment.");
    }
}