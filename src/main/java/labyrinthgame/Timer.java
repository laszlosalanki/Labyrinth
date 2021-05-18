package labyrinthgame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;
import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * Class for the timer in the left corner of the ui.
 */
public class Timer {

    /**
     * Elapsed time in seconds.
     */
    private LongProperty seconds = new SimpleLongProperty();
    /**
     * Elapsed time in hh:mm:ss format.
     */
    private StringProperty hhmmss = new SimpleStringProperty();

    /**
     * This timeline represents the stopwatch.
     */
    private Timeline timeline;

    /**
     * This public constructor sets the keyframe and the format for the timer.
     */
    public Timer() {

        timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            seconds.set(seconds.get() + 1);
        }), new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        hhmmss.bind(Bindings.createStringBinding(() -> DurationFormatUtils.formatDuration(seconds.get() * 1000, "HH:mm:ss"), seconds));

    }

    /**
     * Returns the elapsed time in seconds.
     * @return elapsed time in seconds.
     */
    public LongProperty secondsProperty() {
        return seconds;
    }

    /**
     * Returns the elapsed time in hh:mm:ss format.
     * @return elapsed time in hh:mm:ss format.
     */
    public StringProperty hhmmssProperty() {
        return hhmmss;
    }

    /**
     * Method to start the timeline.
     */
    public void start() {
        timeline.play();
    }

    /**
     * Method to pause the timeline.
     */
    public void stop() {
        timeline.pause();
    }

    /**
     * Method to reset the timeline.
     */
    public void reset() {

        if (timeline.getStatus() != Animation.Status.PAUSED) {
            throw new IllegalStateException();
        }
        seconds.set(0);

    }

    /**
     * Returns the status of the timeline, 'RUNNING' for example.
     * @return status of the timeline in Animation.Status type.
     */
    public Animation.Status getStatus() {
        return timeline.getStatus();
    }

}
