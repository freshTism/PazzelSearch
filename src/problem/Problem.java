package problem;

public class Problem {

    private int[] state;
    private int[] initialState;
    public final int STEP_COST = 1;

    public Problem(int[] initialState) {
        this.initialState = initialState;
    }

    public int[] result(int[] state, Action action) {

    }

    public boolean goalTest(int[] state) {

    }

    public void setState(int[] state) { this.state = state; }
    public int[] getState() {return state;}
}
