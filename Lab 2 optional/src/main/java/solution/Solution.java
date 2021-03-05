package solution;

import problem.Problem;

/**
 * Class Solution, which inherits class Problem
 */

public class Solution extends Problem {
    private int[][] x; //x[i][j] - how many units Si supplies to Dj
    private int costTotal;
    private Problem pb;

    /**
     * Constructor with one parameter
     * @param pb instance of Problem given
     */

    public Solution(Problem pb) {
        this.x = new int[100][100];
        this.costTotal = 0;
        this.pb = new Problem(pb);
    }

    /**
     * Method to calculate the minimum between supply and demand
     * @param x supply
     * @param y demand
     * @return minimum between the two parameters
     */

    public int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    /**
     * Algorithm for creating a feasible solution to the problem
     */

    public void solveProblem() {
        int j = 0;

        for (int i = 0; i < pb.supply.length; i++) {
            while (pb.supply[i] != 0) {
                int minim = min(pb.supply[i], pb.demand[j]);
                x[i][j] = minim;
                pb.supply[i] = pb.supply[i] - minim;
                pb.demand[j] = pb.demand[j] - minim;
                computeCost(pb.cost[i][j], minim);
                if (pb.demand[j] == 0) {
                    j++;
                }
            }
        }
    }

    /**
     * Method for updating the total cost
     * @param c cost from source si to destination dj
     * @param m the number of units transferred
     */

    public void computeCost(int c, int m) {
        this.costTotal = this.costTotal + c * m;
    }

    /**
     * Method for printing the total cost and the solution
     */

    public void printSolution() {
        System.out.println("The total cost for this solution is: " + this.costTotal);

        for (int i = 0; i < pb.sources.length; i++) {
            for (int j = 0; j < pb.destinations.length; j++) {
                if (x[i][j] != 0) {
                    System.out.println("Source " + pb.sources[i].getName() + " supplies destination " + pb.destinations[j].getName() + " with " + x[i][j] + " units.");
                }
            }
        }
    }
}
