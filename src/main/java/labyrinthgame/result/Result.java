package labyrinthgame.result;


public class Result {

    private String username;
    private String time_s;
    private int steps;

    public Result( String username, String time_s, int steps) {
        this.username = username;
        this.time_s = time_s;
        this.steps = steps;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime_s() {
        return time_s;
    }

    public void setTime_s(String time_s) {
        this.time_s = time_s;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Result{" +
                "username='" + username + '\'' +
                ", time_s='" + time_s + '\'' +
                ", steps=" + steps +
                '}';
    }
}
