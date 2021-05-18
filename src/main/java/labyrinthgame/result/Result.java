package labyrinthgame.result;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="result")
public class Result {

    private String username;
    private Long time_s;
    private int steps;

    public Result(){

    }

    public Result( String username, Long time_s, int steps) {
        super();
        this.username = username;
        this.time_s = time_s;
        this.steps = steps;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public Long getTime_s() {
        return time_s;
    }

    public void setTime_s(Long time_s) {
        this.time_s = time_s;
    }

    @XmlElement
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
