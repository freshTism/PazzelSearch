package searchStrategies.uninformedSearch;

import problem.Action;
import problem.Node;
import problem.Problem;

import java.util.*;

public class DFS {
    public static ArrayList<int[][]> dfs(Problem problem) {
        Node node = new Node(problem);

        if (problem.goalTest(node.getState()))  return problem.solution(node);

        Stack<Node> frontier = new Stack<Node>();
        frontier.push(node);

        Set<int[][]> explored = new HashSet<int[][]>();

        while (true) {
            if (frontier.empty())   return null;

            node = frontier.pop();
            explored.add(node.getState());

            for (Action action : problem.actions(node.getState())) {
                Node child = new Node(problem, node, action);

                if (!(frontier.contains(child) || explored.contains(child))) {
                    if (problem.goalTest(child.getState())) return problem.solution(child);
                    frontier.push(child);
                }
            }
        }
    }
}
