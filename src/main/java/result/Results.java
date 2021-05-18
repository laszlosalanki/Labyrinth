package result;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="results")
public class Results {

    private List<Result> results;

    @XmlElement(name="result")
    public List<Result> getResults() {
        return results;
    }


    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return results.toString();
    }

}
