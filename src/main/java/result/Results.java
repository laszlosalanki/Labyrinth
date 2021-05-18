package result;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * This is a class to include results, it's purpose is to help XML exportation.
 */
@XmlRootElement(name="results")
public class Results {

    /**
     * A list to store the resuls.
     */
    private List<Result> results;

    /**
     * Returns the results.
     * @return is a list of results.
     */
    @XmlElement(name="result")
    public List<Result> getResults() {
        return results;
    }

    /**
     * Sets the results list.
     * @param results is a list of results.
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * Overrides the default toString method.
     * @return is a representation of results.
     */
    @Override
    public String toString() {
        return results.toString();
    }

}
