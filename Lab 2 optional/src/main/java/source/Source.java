package source;

import java.util.Objects;

/**
 * Class Source
 */

public abstract class Source {
    protected String name;
    protected String type;

    /**
     * Getter for name
     *
     * @return the name of the source
     */

    public String getName() {
        return this.name;
    }

    /**
     * Setter for name
     *
     * @param name represents the name to be set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overridden function toString
     *
     * @return all information about the source
     */

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Source)) {
            return false;
        }
        Source other = (Source) obj;
        return name.equals(other.name);
    }
}