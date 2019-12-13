package main;

import problem.Problem;
import searchStrategies.uninformedSearch.BFS;
import searchStrategies.uninformedSearch.DFS;
import searchStrategies.uninformedSearch.UCS;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] initialState = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 9, 15, 6},
                {10, 8, 0, 7}
                                };

        int[][] goalState = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 0, 15, 6},
                {10, 9, 8, 7}
                            };

        ArrayList<int[][]> solution;

        Problem problem = new Problem(initialState, goalState);

//        solution = BFS.bfs(problem);
//        solution = UCS.ucs(problem);
        solution = DFS.dfs(problem);

        if (solution == null)
            System.out.println("Failed to solve!");
        else
            System.out.println(problem.solutionToString(solution));
    }
}
