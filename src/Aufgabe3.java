/*
    Aufgabe 3) Zweidimensionale Arrays
*/

import java.util.Random;

public class Aufgabe3 {

    private static boolean[][] genAnimalCompound(int compoundSize, float probability) {

        Random myRand = new Random(5); // Diese Zeile nicht verändern!

        boolean[][] compound = new boolean[compoundSize][compoundSize];

        for (int i = 0; i < compoundSize; i++) {
            for (int j = 0; j < compoundSize; j++) {
                compound[i][j] = myRand.nextFloat() <= probability;
            }
        }
        return compound; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] calcAnimalDensity(boolean[][] animalCompound) {

        int[][] density = new int[animalCompound.length][animalCompound[0].length];

        for (int i = 0; i < animalCompound.length; i++) {
            for (int j = 0; j < animalCompound[0].length; j++) {
                int densityCount = 0;
                if(animalCompound[i][j]){
                    densityCount++;
                }
                if(i > 0 && animalCompound[i - 1][j]){
                    densityCount++;
                }
                if(i < animalCompound.length - 1 && animalCompound[i + 1][j]){
                    densityCount++;
                }
                if(j < animalCompound.length - 1 && animalCompound[i][j + 1]){
                    densityCount++;
                }
                if(j > 0 && animalCompound[i][j - 1]){
                    densityCount++;
                }
                if(j > 0 && i < animalCompound.length - 1 && animalCompound[i + 1][j - 1]){
                    densityCount++;
                }
                if(i < animalCompound.length - 1 && j < animalCompound.length -  1 && animalCompound[i + 1][j + 1]){
                    densityCount++;
                }
                if(i > 0 && j > 0 && animalCompound[i - 1][j - 1]){
                    densityCount++;
                }
                if(j < animalCompound.length - 1 && i > 0 && animalCompound[i - 1][j + 1]){
                    densityCount++;
                }
                density[i][j] = densityCount;
            }
        }
        return density; //Zeile kann geändert oder entfernt werden.
    }

    // helping method for printing the animal compound
    private static void printCompound(boolean[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                if (animalCompound[y][x]) {
                    System.out.print("* ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    // helping method for printing the number of animals
    private static void printDensity(int[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                System.out.print(animalCompound[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // variables
        int compoundSize = 8;
        float probability = 0.8f;
        boolean[][] animalCompound = genAnimalCompound(compoundSize, probability);
        printCompound(animalCompound);
        System.out.println();
        int[][] animalDensity = calcAnimalDensity(animalCompound);
        printDensity(animalDensity);
    }
}
