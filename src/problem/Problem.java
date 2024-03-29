package problem;

import main.Utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem {

    public final int PROBLEM_SIZE = 4;
    public final int STEP_COST = 1;

    private int[][] initialState;
    private int[][] goalState;

    public Problem(int[][] initialState, int[][] goalState) {
        this.initialState = initialState.clone();
        this.goalState = goalState.clone();
    }

    //When using this first check if it's null !!!
    public int[][] result(int[][] state, Action action) {
        int[][] result = new int[state.length][];

        //Finds the empty block
        int[] zeroIndex = Utility.searchArray(state, 0).clone();

        if (zeroIndex == null)      //Something went wrong
            result = null;
        else {
            //Copy state array to result
            for (int i = 0; i < state.length; i++)
                result[i] = state[i].clone();

            //Actions based on zero
            switch (action) {
                case UP:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0] - 1][zeroIndex[1]];
                    result[zeroIndex[0] - 1][zeroIndex[1]] = 0;
                    break;

                case DOWN:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0] + 1][zeroIndex[1]];
                    result[zeroIndex[0] + 1][zeroIndex[1]] = 0;
                    break;

                case LEFT:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0]][zeroIndex[1] - 1];
                    result[zeroIndex[0]][zeroIndex[1] - 1] = 0;
                    break;

                case RIGHT:
                    result[zeroIndex[0]][zeroIndex[1]] = result[zeroIndex[0]][zeroIndex[1] + 1];
                    result[zeroIndex[0]][zeroIndex[1] + 1] = 0;
                    break;
            }
        }

        return result;
    }

    //When using this first check if it's null !!!
    //Actions based on zero
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

    public ArrayList<int[][]> solution(Node goalState) {
        ArrayList<int[][]> solution = new ArrayList<int[][]>();

        Node currentNode = goalState;

        while (currentNode != null) {
            solution.add(currentNode.getState());
            currentNode = currentNode.getParent();
        }

        Collections.reverse(solution);

        return solution;
    }

    public String solutionToString(ArrayList<int[][]> solution) {
        String result = "";

        for (int[][] step: solution) {
            //All lines of one step except the last line
            for (int i = 0; i < PROBLEM_SIZE - 1; i++) {
                for (int j = 0; j < PROBLEM_SIZE; j++) {
                    result += step[i][j] + ", ";
                }
            }
            //Last line of the step
            for (int j = 0; j < PROBLEM_SIZE - 1; j++)
                result += step[PROBLEM_SIZE - 1][j] + ", ";

            result += step[PROBLEM_SIZE - 1][PROBLEM_SIZE - 1] + "\n";
        }

        return result;
    }

    public boolean goalTest(int[][] state) {
        if (Arrays.deepEquals(state, goalState))
            return true;
        else
            return false;
    }


    public int manhattanDistance(Node node) {
        int manhattanDistance = 0;

        int[] targetIndex;
        int[][] nodeState = new int[PROBLEM_SIZE][];

        for (int i = 0; i < PROBLEM_SIZE; i++)
            nodeState[i] = node.getState()[i].clone();

        for (int i = 0; i < PROBLEM_SIZE; i++) {
            for (int j = 0; j < PROBLEM_SIZE; j++) {
                if (nodeState[i][j] != 0 && nodeState[i][j] != goalState[i][j]) {
                    targetIndex = Utility.searchArray(goalState, nodeState[i][j]).clone();
                    manhattanDistance += (Math.abs(i - targetIndex[0]) + Math.abs(j - targetIndex[1]));
                }
            }
        }

        return manhattanDistance;
    }

    public int heuristic(Node node) {
        return manhattanDistance(node) + node.getPathCost();
    }

    public int[][] getInitialState() { return this.initialState; }
}