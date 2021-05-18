package labyrinthgame.result;

public class ResultBuilder {

    private String username;
    private Long time_s;
    private int steps;

    public ResultBuilder() {

    }

    public ResultBuilder(String username, Long time_s, int steps) {
        this.username = username;
        this.time_s = time_s;
        this.steps = steps;
    }

    public ResultBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public ResultBuilder setTime_s(Long time_s) {
        this.time_s = time_s;
        return this;
    }

    public ResultBuilder setSteps(int steps) {
        this.steps = steps;
        return this;
    }

    public Result buid() {
        return new Result(username, time_s, steps);
    }
}
