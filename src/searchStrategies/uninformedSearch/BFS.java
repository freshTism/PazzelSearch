package searchStrategies.uninformedSearch;

import problem.Action;
import problem.Node;
import problem.Problem;

import java.util.*;

public class BFS {
    public static ArrayList<int[][]> bfs(Problem problem) {

        Node node = new Node(problem);

        if (problem.goalTest(node.getState())) return problem.solution(node);

        Queue<Node> frontier = new LinkedList<Node>();
        frontier.add(node);

        Set<int[][]> explored = new HashSet<int[][]>();

        while (true) {
            if (frontier.isEmpty()) return null;

            node = frontier.poll();
            explored.add(node.getState());

            for (Action action : problem.actions(node.getState())) {
                Node child = new Node(problem, node, action);

                if (!(frontier.contains(child) || explored.contains(child))) {
                    if (problem.goalTest(child.getState())) return problem.solution(child);
                    frontier.add(child);
                }
            }
        }
    }
}
