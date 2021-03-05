package solution;

import problem.Problem;

/**
 * Class Solution, which inherits class Problem
 * Only works with total supply equal to total demand
 */

public class Solution extends Problem {
    private int[][] x; //x[i][j] - how many units Si supplies to Dj
    private int costTotal;
    private Problem pb;
    private int[] rowDifference;
    private int[] columnDifference;

    /**
     * Constructor with one parameter
     *
     * @param pb instance of Problem given
     */

    public Solution(Problem pb) {
        this.x = new int[100][100];
        this.costTotal = 0;
        this.pb = new Problem(pb);
    }

    /**
     * Method to find out the solution to the problem with minimum total cost
     */

    public void solveProblem() {
        int maxDifferenceRow, maxDifferenceColumn, row, column, minim;

        //while there are more units to be transported
        while (continueSolution() == true) {
            //compute the differences for every row and column
            computeRowDifference();
            computeColumnDifference();

            //compute the maximum difference between all rows and all columns
            maxDifferenceRow = maxRowDifference();
            maxDifferenceColumn = maxColumnDifference();

            //if the maximum difference is found in a row
            if (maxDifferenceRow > maxDifferenceColumn) {
                row = indexMaxRow(maxDifferenceRow);
                column = indexMinCostRow(row);
            } else //if the maximum difference is found in a column
            {
                column = indexMaxColumn(maxDifferenceColumn);
                row = indexMinCostColumn(column);
            }

            //min between supply and demand
            minim = min(pb.supply[row], pb.demand[column]);
            x[row][column] = minim;

            //update supply and demand
            pb.supply[row] = pb.supply[row] - minim;
            pb.demand[column] = pb.demand[column] - minim;

            computeCost(pb.cost[row][column], minim);
            if (pb.supply[row] == 0) {
                updateRow(row);
            } else {
                updateColumn(column);
            }
        }
    }

    /**
     * Method to calculate the minimum between two numbers
     * @param x first number
     * @param y second number
     * @return the lowest number between x and y
     */

    public int min(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    /**
     * Method for updating the total cost
     *
     * @param c cost from source si to destination dj
     * @param m the number of units transferred
     */

    public void computeCost(int c, int m) {
        this.costTotal = this.costTotal + c * m;
    }

    /**
     * Method to compute differences for every row
     */

    public void computeRowDifference() {
        int min1, min2;

        this.rowDifference = new int[pb.sources.length];

        for (int i = 0; i < pb.sources.length; i++) {
            min1 = 1000000;
            min2 = 1000000;
            for (int j = 0; j < pb.destinations.length; j++) {
                if (cost[i][j] < min1) {
                    min2 = min1;
                    min1 = cost[i][j];
                } else {
                    if (cost[i][j] < min2) {
                        min2 = cost[i][j];
                    }
                }
            }
            rowDifference[i] = min2 - min1;
        }
    }

    /**
     * Method to compute differences for every column
     */

    public void computeColumnDifference() {
        int min1, min2;

        this.columnDifference = new int[pb.destinations.length];

        for (int i = 0; i < pb.destinations.length; i++) {
            min1 = 1000000;
            min2 = 1000000;
            for (int j = 0; j < pb.sources.length; j++) {
                if (cost[j][i] < min1) {
                    min2 = min1;
                    min1 = cost[j][i];
                } else {
                    if (cost[j][i] < min2) {
                        min2 = cost[j][i];
                    }
                }
            }
            columnDifference[i] = min2 - min1;
        }
    }

    /**
     * Method to update row in cost matrix to a very big number so it can never be minimum
     * @param row to be updated
     */

    public void updateRow(int row) {
        for (int i = 0; i < pb.destinations.length; i++) {
            cost[row][i] = 1000000;
        }
    }

    /**
     * Method to update column in cost matrix to a very big number so it can never be minimum
     * @param column
     */

    public void updateColumn(int column) {
        for (int i = 0; i < pb.sources.length; i++) {
            cost[i][column] = 1000000;
        }
    }

    /**
     * Method to determine if the solution is finished or not
     * @return true if solution should be continued, false otherwise
     */

    public boolean continueSolution() {
        for (int i = 0; i < pb.sources.length; i++) {
            for (int j = 0; j < pb.destinations.length; j++) {
                if (cost[i][j] != 1000000) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to compute the maximum difference from all rows
     * @return max value
     */

    public int maxRowDifference() {
        int max = rowDifference[0];

        for (int i = 1; i < rowDifference.length; i++) {
            if (rowDifference[i] > max) {
                max = rowDifference[i];
            }
        }

        return max;
    }

    /**
     * Method to compute the maximum difference from all columns
     * @return max value
     */

    public int maxColumnDifference() {
        int max = columnDifference[0];

        for (int i = 1; i < columnDifference.length; i++) {
            if (columnDifference[i] > max) {
                max = columnDifference[i];
            }
        }

        return max;
    }

    /**
     * Method to determine the row whose difference is max
     * @param value max value
     * @return row
     */

    public int indexMaxRow(int value) {
        for (int i = 0; i < rowDifference.length; i++) {
            if (rowDifference[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Method to determine the column whose difference is max
     * @param value max value
     * @return column
     */

    public int indexMaxColumn(int value) {
        for (int i = 0; i < columnDifference.length; i++) {
            if (columnDifference[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Method to find the position of the minimum cost in a certain row
     * @param row to look in
     * @return position of min cost
     */

    public int indexMinCostRow(int row) {
        int min = cost[row][0];
        int position = 0;

        for (int i = 1; i < pb.destinations.length; i++) {
            if (cost[row][i] < min) {
                min = cost[row][i];
                position = i;
            }
        }

        return position;
    }

    /**
     * Method to find the position of the minimum cost in a certain column
     * @param column to look in
     * @return position of min cost
     */

    public int indexMinCostColumn(int column) {
        int min = cost[0][column];
        int position = 0;

        for (int i = 1; i < pb.sources.length; i++) {
            if (cost[i][column] < min) {
                min = cost[i][column];
                position = i;
            }
        }

        return position;
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