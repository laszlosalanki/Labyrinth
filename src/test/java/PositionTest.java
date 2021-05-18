import javafx.scene.layout.StackPane;
import labyrinthgame.PositionStatic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    StackPane sp;

    @BeforeEach
    void setUp() {
        sp = new StackPane();
        sp.getStyleClass().add("border-rightbottomleft");
    }

    @Test
    void canGoUp() {
        assertEquals(true, PositionStatic.canGoToStatic(3, 3, 2, 3, sp));
    }

    @Test
    void canGoLeft() {
        assertEquals(false, PositionStatic.canGoToStatic(3, 3, 3, 2, sp));
    }

    @Test
    void canGoRight() {
        assertEquals(false, PositionStatic.canGoToStatic(3, 3, 3, 4, sp));
    }

    @Test
    void canGoDown() {
        assertEquals(false, PositionStatic.canGoToStatic(3, 3, 4, 3, sp));
    }

    @Test
    void canGoOutOfLevelLeft() {
        assertEquals(false, PositionStatic.canGoToStatic(3, 3, 3, -2, sp));
    }

}
