package destination;

/**
 * Class Destination
 */

public class Destination {

    private String name;

    /**
     * Constructor with no parameters
     */

    public Destination() {
        this.name = "D1";
    }

    /**
     * Constructor with one parameter
     * @param name represents the name of the destination
     */

    public Destination(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     * @return the name of the destination
     */

    public String getName() {
        return this.name;
    }

    /**
     * Setter for name
     * @param name represents the name to be set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overridden function toString
     * @return all information about the destination
     */

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
