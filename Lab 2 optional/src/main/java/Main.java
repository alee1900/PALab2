import destination.Destination;
import problem.Problem;
import solution.Solution;
import source.Factory;
import source.Source;
import source.Warehouse;

public class Main {

    public static void main(String[] args) {
        Source s1 = new Factory("S1");
        Source s2 = new Warehouse("S2");
        Source s3 = new Warehouse("S3");

        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");

        Problem pb = new Problem(new Source[]{s1, s2, s3}, new Destination[]{d1, d2, d3}, new int[]{10, 35, 25}, new int[]{20, 25, 25}, new int[][]{{2, 3, 1}, {5, 4, 8}, {5, 6, 8}});
        pb.printInstance();

        Solution sol=new Solution(pb);
        sol.solveProblem();
        sol.printSolution();
    }
}
