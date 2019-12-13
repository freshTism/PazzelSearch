package searchStrategies.uninformedSearch;

import problem.Action;
import problem.Node;
import problem.Problem;

import java.util.*;

public class DFS {

    private static Set<int[][]> explored = new HashSet<int[][]>();

    public static ArrayList<int[][]> dfs(Problem problem) {
        Node root = new Node(problem);
        return recursiveDFS(root, problem);
    }

    private static ArrayList<int[][]> recursiveDFS(Node node, Problem problem) {
        if (problem.goalTest(node.getState())) {
            return problem.solution(node);
        }
        else {
            for (Action action : problem.actions(node.getState())) {
                Node child = new Node(problem, node, action);
                if (!explored.contains(child.getState())) {
                    recursiveDFS(child, problem);
                }
            }   
            explored.add(node.getState());
        }
    }
}
