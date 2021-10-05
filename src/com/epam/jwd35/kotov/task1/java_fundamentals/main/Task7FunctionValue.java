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

public class Task7FunctionValue {
    final static String START_MESSAGE = "start point";
    final static String FINISH_MESSAGE = "finish point";
    final static String STEP_MESSAGE = "step";

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

    private static double[] calculateFunction(double startPoint, double endPoint, double step) {
        double argument;
        double funcValue;
        double [] argumentAndFuncValue;
        int argumetnAdnFuncValueNumber;

        argumetnAdnFuncValueNumber = (int)((endPoint - startPoint) / step);
        argumentAndFuncValue = new double[argumetnAdnFuncValueNumber * 2];

        int i = 0;
        for (double point = startPoint; (i < argumentAndFuncValue.length) && (point <= endPoint);
                point += step) {
            argument = point;
            funcValue = Math.pow(Math.sin(argument), 2) - Math.cos((2 * argument));
            argumentAndFuncValue[i++] = argument;
            argumentAndFuncValue[i++] = funcValue;
        }
        return argumentAndFuncValue;
    }

    private static void manageProgram() {
        double startPoint;
        double endPoint;
        double step;
        double argument;
        double funcValue;
        double [] rezultArr;

        argument = 0;
        funcValue = 0;
        startPoint = readDoubleNumber(START_MESSAGE);
        endPoint = readDoubleNumber(FINISH_MESSAGE);
        step = readDoubleNumber(STEP_MESSAGE);
        rezultArr = calculateFunction(startPoint, endPoint, step);

        printMessageForWriting(startPoint, endPoint, step);
        for(int i = 0; i < rezultArr.length; i +=2) {
            rezultArr[i] = argument;
            rezultArr[i+1] = funcValue;
            printMessageForWritingForFunction(argument, funcValue);
        }
    }

    private static void printMessageForReading(String message) {
        System.out.println("Enter a double" + message + ":");
    }

    private static void printErrorMessageForReading() {
        System.out.println("Incorrect data entered.");
    }

    private static void printMessageForWriting(double startPioint, double finishPoint,
                                               double step) {
        System.out.println("Function value from " + startPioint + " to " + finishPoint
                            + " with step " + step + ":");
    }

    private static void printMessageForWritingForFunction(Double argument, double functionValue) {
        System.out.printf("Argument %-10.3f Function %-10.3f \n", argument, functionValue);
    }
}