package source;

/**
 * Class Warehouse, which inherits class Source (it's a type of source)
 */

public class Warehouse extends Source {
    /**
     * Constructor with no parameters
     */
    public Warehouse() {
        this.name = "S1";
        this.type = "Warehouse";
    }

    /**
     * Constructor with one parameter
     * @param name represents the name of the source
     */

    public Warehouse(String name) {
        this.name = name;
        this.type = "Warehouse";
    }
}
