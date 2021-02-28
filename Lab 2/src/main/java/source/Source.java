package source;

/**
 * Class Source
 */

public class Source {

    private String name;
    private SourceType type;

    /**
     * Constructor with no parameters
     */

    public Source() {
        this.name = "S1";
        this.type = SourceType.FACTORY;
    }

    /**
     * Constructor with parameters
     * @param name represents the name of the source
     * @param type represents the type of the source
     */

    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Possible types of sources: Warehouse or Factory
     */

    public enum SourceType {
        WAREHOUSE, FACTORY;
    }

    /**
     * Getter for name
     * @return the name of the source
     */

    public String getName() {
        return this.name;
    }

    /**
     * Getter for type
     * @return the type of the source
     */

    public SourceType getType() {
        return this.type;
    }

    /**
     * Setter for name
     * @param name represents the name to be set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for type
     * @param type represents the type to be set
     */

    public void setType(SourceType type) {
        this.type = type;
    }

    /**
     * Overridden function toString
     * @return all information about the source
     */

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
