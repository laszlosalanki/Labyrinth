package result;

/**
 * Builder class for @class
 */
public class ResultBuilder {

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
    public ResultBuilder() {

    }

    /**
     * Constructor for the class.
     * @param username is the name of the user.
     * @param time_s is the time in seconds the user took to solve the level.
     * @param steps is the steps the user took to solve the level.
     */
    public ResultBuilder(String username, Long time_s, int steps) {
        this.username = username;
        this.time_s = time_s;
        this.steps = steps;
    }

    /**
     * Sets the username of the user and returns the actual state of the class.
     * @param username is the user who solved the level.
     * @return is the actual state of the class.
     */
    public ResultBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Sets the time the user took to solve the level and returns the actual state of the class.
     * @param time_s the time the user took to solve the level.
     * @return is the actual state of the class.
     */
    public ResultBuilder setTime_s(Long time_s) {
        this.time_s = time_s;
        return this;
    }

    /**
     * Sets the steps the user took to solve the level and returns the actual state of the class.
     * @param steps the steps the user took to solve the level.
     * @return is the actual state of the class.
     */
    public ResultBuilder setSteps(int steps) {
        this.steps = steps;
        return this;
    }

    /**
     * Completes the build process by returning the built class.
     * @return is the built class.
     */
    public Result buid() {
        return new Result(username, time_s, steps);
    }
}
