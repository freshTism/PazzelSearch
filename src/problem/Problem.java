package problem;

import main.Utility;

import java.awt.*;
import java.util.ArrayList;
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

    //When using this first check if it's null !!!
    public int[][] result(int[][] state, Action action) {
        int[][] result;

        //Finds the empty block
        int[] zeroIndex = Utility.searchArray(state, 0).clone();

        if (zeroIndex == null)      //Something went wrong
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

    //When using this first check if it's null !!!
    public Action[] actions(int[][] state) {
        Action[] actions;

        //Finds the empty block
        int[] zeroIndex = Utility.searchArray(state, 0).clone();

        if (zeroIndex == null)
            return null;
        else {
            //Corners
            if (zeroIndex[0] == 0 && zeroIndex[1] == 0)     //Up left corner
                actions = new Action[]{Action.DOWN, Action.RIGHT};
            else if (zeroIndex[0] == 0 && zeroIndex[1] == PROBLEM_SIZE - 1)     //Up right corner
                actions = new Action[] {Action.DOWN, Action.LEFT};
            else if (zeroIndex[0] == PROBLEM_SIZE - 1 && zeroIndex[1] == 0)     //Down left corner
                actions = new Action[] {Action.UP, Action.RIGHT};
            else if (zeroIndex[0] == PROBLEM_SIZE - 1 && zeroIndex[1] == PROBLEM_SIZE - 1)      //Down right corner
                actions = new Action[] {Action.UP, Action.LEFT};
            //Sides
            else if (zeroIndex[0] == 0)     //Up side
                actions = new Action[] {Action.DOWN, Action.RIGHT, Action.LEFT};
            else if (zeroIndex[0] == PROBLEM_SIZE - 1)      //Down side
                actions = new Action[] {Action.UP, Action.RIGHT, Action.LEFT};
            else if (zeroIndex[1] == 0)     //Left side
                actions = new Action[] {Action.RIGHT, Action.UP, Action.DOWN};
            else if (zeroIndex[1] == PROBLEM_SIZE - 1)      //Right side
                actions = new Action[] {Action.LEFT, Action.UP, Action.DOWN};

            else    //Middle
                actions = new Action[] {Action.UP, Action.DOWN, Action.LEFT, Action.RIGHT};

        }

        return actions;
    }

    public boolean goalTest(int[][] state) {
        if (Arrays.equals(state, goalState))
            return true;
        else
            return false;
    }
}