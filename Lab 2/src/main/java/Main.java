import source.Source;
import destination.Destination;
import problem.Problem;

public class Main {

    public static void main(String[] args) {
        Source s1 = new Source();

        s1.setName("S1");
        s1.setType(Source.SourceType.FACTORY);

        Source s2 = new Source("S2", Source.SourceType.WAREHOUSE);
        Source s3 = new Source("S3", Source.SourceType.WAREHOUSE);

        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");

        Problem pb = new Problem(new Source[]{s1, s2, s3}, new Destination[]{d1, d2, d3}, new int[]{10, 35, 25}, new int[]{20, 25, 25}, new int[][]{{2, 3, 1}, {5, 4, 8}, {5, 6, 8}});

        pb.printInstance();
    }
}
