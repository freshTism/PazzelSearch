package main;

public class Utility {

    //Searches in a 2D array for a target int and returns its index
    public static int[] searchArray(int[][] array, int target) {

        int[] targetIndex = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    targetIndex[0] = i;
                    targetIndex[1] = j;
                    return targetIndex;     //We found it!!!
                }
            }
        }

        //Did not find the target :(
        targetIndex[0] = -1;
        targetIndex[1] = -1;
        return targetIndex;
    }

}
