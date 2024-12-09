/*
    Aufgabe 1) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        int shortest = workArray[0].length;
        int shortestIndex = 0;
        //kleinstes Array und index herausfinden
        for(int i = 0; i < workArray.length; i++) {
            if(workArray[i].length < shortest) {
                shortest = workArray[i].length;
                shortestIndex = i;
            }
        }

        //falls alle arrays gleich lang sind
        boolean equals = true;
        for(int i = 0; i < workArray.length - 1; i++) {
            if(workArray[i].length != workArray[i + 1].length) {
                equals = false;
                break;
            }

        }

        //wenn alle arrays gleich lang sind verschieben
        if(equals) {
            int[] tempArray = workArray[0];
            for(int i = 0; i < workArray.length - 1; i++) {
                workArray[i] = workArray[i + 1];
            }
            workArray[workArray.length - 1] = tempArray;
            return;
        }

        //verschieben des kürzesten arrays
        int[] tempArray = workArray[0];
        workArray[0] = workArray[shortestIndex];
        workArray[shortestIndex] = tempArray;
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j
                     = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test shiftLines:");
        System.out.println("-----");
        int[][] array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 2, 4, 1}, {7, 3, 6}, {4}, {5, 6, 2, 4}, {9, 1}, {3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4}, {7, 3, 6}, {3, 2, 4, 1}, {5, 6, 2, 4}, {9, 1}, {3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 4, 1}, {6, 2, 5}, {9, 7, 8}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{6, 2, 5}, {9, 7, 8}, {3, 4, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");
    }
}

