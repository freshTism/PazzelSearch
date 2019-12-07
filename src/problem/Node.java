package problem;

import problem.Problem;

public class Node {

    private int[] state;
    private Node parent;
    private int pathCost;
    private Action action;

    public Node(Problem problem, Node parent, Action action) {
        this.state = problem.result(parent.state, action);
        this.parent = parent;
        this.action = action;
        this.pathCost = parent.pathCost + problem.STEP_COST;
    }

}
