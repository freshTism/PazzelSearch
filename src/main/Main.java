package main;

import problem.Problem;
import searchStrategies.uninformedSearch.BFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] initialState = {
                {1, 0, 2, 4},
                {3, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
                                };

        int[][] goalState = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 0, 15, 6},
                {10, 9, 8, 7}
                            };

        ArrayList<int[][]> solution;

        Problem problem = new Problem(initialState, goalState);

       solution = BFS.bfs(problem);

       System.out.println(problem.solutionToString(solution));
    }
}
