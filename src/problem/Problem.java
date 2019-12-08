package problem;

import main.Utility;

import java.util.Arrays;

public class Problem {

    private final int PROBLEM_SIZE = 4;
    public final int STEP_COST = 1;

    private int[][] initialState;
    private int[][] goalState;

    public Problem(int[][] initialState, int[][] goalState) {
        this.initialState = initialState.clone();
        this.goalState = goalState.clone();
    }

    public int[][] result(int[][] state, Action action) {
        int[][] result;

        //Finds the empty block
        int[] zeroIndex = Utility.searchArray(state, 0).clone();

        if (zeroIndex == null)
            result = null;
        else {
            result = state.clone();

            switch (action) {
                case UP:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0] + 1][zeroIndex[1]];
                    result[zeroIndex[0] + 1][zeroIndex[1]] = 0;
                    break;

                case DOWN:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0] - 1][zeroIndex[1]];
                    result[zeroIndex[0] - 1][zeroIndex[1]] = 0;
                    break;

                case LEFT:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0]][zeroIndex[1] + 1];
                    result[zeroIndex[0]][zeroIndex[1] + 1] = 0;
                    break;

                case RIGHT:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0]][zeroIndex[1] - 1];
                    result[zeroIndex[0]][zeroIndex[1] - 1] = 0;
                    break;
            }
        }

        return result;
    }

    public boolean goalTest(int[][] state) {
        if (Arrays.equals(state, goalState))
            return true;
        else
            return false;
    }
}