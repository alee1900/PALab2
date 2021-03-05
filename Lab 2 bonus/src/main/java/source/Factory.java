package source;

/**
 * Class Factory, which inherits class Source (it's a type of source)
 */

public class Factory extends Source {
    /**
     * Constructor with no parameters
     */
    public Factory() {
        this.name = "S1";
        this.type = "Factory";
    }

    /**
     * Constructor with one parameter
     * @param name represents the name of the source
     */

    public Factory(String name) {
        this.name = name;
        this.type = "Factory";
    }
}