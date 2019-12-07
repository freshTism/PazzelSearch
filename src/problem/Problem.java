package problem;

import java.util.Arrays;

public class Problem {

    private final int PROBLEM_ISZE = 4;
    public final int STEP_COST = 1;

    private int[][] state = new int[PROBLEM_ISZE][PROBLEM_ISZE];
    private int[][] initialState;
    private int[][] goalState;

    public Problem(int[][] initialState, int[][] goalState) {
        this.initialState = initialState.clone();
        this.goalState = goalState.clone();
    }

    public int[][] result(int[][] state, Action action) {
        int[][] result = new int[PROBLEM_ISZE][PROBLEM_ISZE];

        switch (action) {
            case UP:

                break;
            case DOWN:

                break;
            case LEFT:

                break;
            case RIGHT:

                break;
        }
    }

    public boolean goalTest(int[][] state) {
        if (Arrays.equals(state, goalState))
            return true;
        else
            return false;
    }

    public void setState(int[][] state) { this.state = state; }
    public int[][] getState() {return state;}
}