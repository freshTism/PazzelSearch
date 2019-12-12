package searchStrategies.uninformedSearch;

import problem.Action;
import problem.Node;
import problem.Problem;

import java.util.*;

public class UCS {
    public static ArrayList<int[][]> ucs(Problem problem) {
        Node node = new Node(problem);

        Comparator<Node> nodePathCostComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getPathCost() - o2.getPathCost();
            }
        };

        PriorityQueue<Node> frontier = new PriorityQueue<Node>(nodePathCostComparator);
        frontier.add(node);

        Set<int[][]> explored = new HashSet<int[][]>();

        while (true) {
            if (frontier.isEmpty()) return null;

            node = frontier.poll();
            if (problem.goalTest(node.getState()))  return problem.solution(node);
            explored.add(node.getState());

            for (Action action: problem.actions(node.getState())) {
                Node child = new Node(problem, node, action);

                if (!(frontier.contains(child) || explored.contains(child)))
                    frontier.add(child);
            }
        }
    }
}
