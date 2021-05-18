package result;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Class for representing a result of the game.
 */
@XmlRootElement(name="result")
public class Result {

    /**
     * The name of the user, who solved the level.
     */
    private String username;
    /**
     * The time the user took to solve the level.
     */
    private Long time_s;
    /**
     * Necessary steps to solve the level.
     */
    private int steps;

    /**
     * Empty constructor for the XML exportation.
     */
    public Result(){

    }

    /**
     * Constructor for the class.
     * @param username is the name of the user.
     * @param time_s is the time in seconds the user took to solve the level.
     * @param steps is the steps the user took to solve the level.
     */
    public Result( String username, Long time_s, int steps) {
        super();
        this.username = username;
        this.time_s = time_s;
        this.steps = steps;
    }

    /**
     * Returns the username of the user.
     * @return the username of the user.
     */
    @XmlElement
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user for the given object.
     * @param username the username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the time the user took to solve the level.
     * @return the time the user took to solve the level.
     */
    @XmlElement
    public Long getTime_s() {
        return time_s;
    }

    /**
     * Sets the time the user took to solve the level.
     * @param time_s is the time the user took to solve the level.
     */
    public void setTime_s(Long time_s) {
        this.time_s = time_s;
    }

    /**
     * Returns the steps the user took to solve the level.
     * @return the steps the user took to solve the level.
     */
    @XmlElement
    public int getSteps() {
        return steps;
    }

    /**
     * Sets the steps the user took to solve the level.
     * @param steps is the steps the user took to solve the level.
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Overrides the default toString function.
     * @return is a text representation of a result.
     */
    @Override
    public String toString() {
        return "Result{" +
                "username='" + username + '\'' +
                ", time_s='" + time_s + '\'' +
                ", steps=" + steps +
                '}';
    }
}
