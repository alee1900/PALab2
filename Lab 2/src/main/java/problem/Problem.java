package problem;

import destination.Destination;
import source.Source;

import java.util.Arrays;

/**
 * Class Problem that has Sources and their supply constraints, Destinations and their demands, and costs
 */

public class Problem {

    private Source[] sources;
    private Destination[] destinations;
    private int[] supply;
    private int[] demand;
    private int[][] cost;

    /**
     * Constructor with no parameters
     */

    public Problem() {
        this.sources = new Source[1];
        this.sources[0] = new Source();
        this.destinations = new Destination[1];
        this.destinations[0] = new Destination();
        this.supply = new int[1];
        this.supply[0] = 0;
        this.demand = new int[1];
        this.demand[0] = 0;
        this.cost = new int[1][1];
        this.cost[0][0] = 0;
    }

    /**
     * Constructor with parameters
     *
     * @param sources      represents the array of sources available
     * @param destinations represents the array of destinations available
     * @param supply       represents the array of supply constraints for all sources
     * @param demand       represents the array of demands for all destinations
     * @param cost         represents the matrix of costs for all sources and destinations
     */

    public Problem(Source[] sources, Destination[] destinations, int[] supply, int[] demand, int[][] cost) {
        this.sources = new Source[sources.length];
        this.destinations = new Destination[destinations.length];
        this.supply = new int[supply.length];
        this.demand = new int[demand.length];
        this.cost = new int[sources.length][destinations.length];

        for (int i = 0; i < sources.length; i++) {
            this.sources[i] = sources[i];
            this.supply[i] = supply[i];
        }

        for (int i = 0; i < destinations.length; i++) {
            this.destinations[i] = destinations[i];
            this.demand[i] = demand[i];
        }

        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < destinations.length; j++) {
                this.cost[i][j] = cost[i][j];
            }
        }
    }

    /**
     * Getter for sources
     * Prints the names of all sources
     */

    public void getSources() {
        System.out.println("These are all the sources:");
        for (Source i : sources) {
            System.out.println(i.getName());
        }
    }

    /**
     * Getter for destinations
     * Prints the names of all destinations
     */

    public void getDestinations() {
        System.out.println("These are all the destinations:");
        for (Destination i : destinations) {
            System.out.println(i.getName());
        }
    }

    /**
     * Getter for supply constraints
     * Prints the supply constraints for all sources
     */

    public void getSupply() {
        System.out.println("These are all supply constraints:");
        for (int i = 0; i < supply.length; i++) {
            System.out.println("Source " + sources[i].getName() + " has supply of " + supply[i]);
        }
    }

    /**
     * Getter for demands
     * Prints the demands of all destinations
     */

    public void getDemand() {
        System.out.println("These are all the demand constraints:");
        for (int i = 0; i < demand.length; i++) {
            System.out.println("Destination " + destinations[i].getName() + " has demand of " + demand[i]);
        }
    }

    /**
     * Getter for costs
     * Prints the costs for all sources and destinations
     */

    public void getCost() {
        System.out.println("These are all the costs:");
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < destinations.length; j++) {
                System.out.println("Source " + sources[i].getName() + " has cost of " + cost[i][j] + " for destination " + destinations[j]);
            }
        }
    }

    /**
     * Setter for sources
     * @param sources represents the array of sources to be set
     */

    public void setSources(Source[] sources) {
        System.arraycopy(this.sources, 0, sources, 0, sources.length);
    }

    /**
     * Setter for destinations
     * @param destinations represents the array of destinations to be set
     */

    public void setDestinations(Destination[] destinations) {
        System.arraycopy(this.destinations, 0, destinations, 0, destinations.length);
    }

    /**
     * Setter for supply constraints
     * @param supply represents the array of supply constraints to be set
     */

    public void setSupply(int[] supply) {
        System.arraycopy(this.supply, 0, supply, 0, supply.length);
    }

    /**
     * Setter for demands
     * @param demand represents the array of demands to be set
     */

    public void setDemand(int[] demand) {
        System.arraycopy(this.demand, 0, demand, 0, demand.length);
    }

    /**
     * Setter for costs
     * @param cost represents the matrix of costs to be set
     */

    public void setCost(int[][] cost) {
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < destinations.length; j++) {
                this.cost[i][j] = cost[i][j];
            }
        }
    }

    /**
     * Function to print the instance of the problem as a table
     */

    public void printInstance() {
        System.out.println("This is the problem given:");
        System.out.print("       ");

        for (Destination i : destinations) {
            System.out.print(i.getName() + " ");
        }

        System.out.println("Supply");

        for (int i = 0; i < sources.length; i++) {
            System.out.print(sources[i].getName() + "     ");
            for (int j = 0; j < destinations.length; j++) {
                System.out.print(cost[i][j] + "  ");
            }
            System.out.println(supply[i]);
        }

        System.out.print("Demand ");

        for (int i = 0; i < destinations.length; i++) {
            System.out.print(demand[i] + " ");
        }

        System.out.println();
    }

    /**
     * Overridden function toString
     * @return all information about the problem
     */

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                ", cost=" + Arrays.toString(cost) +
                '}';
    }
}
