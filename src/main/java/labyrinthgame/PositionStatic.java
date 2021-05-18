package labyrinthgame;

import javafx.scene.layout.StackPane;

public class PositionStatic {

    public static boolean canGoToStatic(int x_from, int y_from, int x, int y, StackPane gameStackPane) {

        if (x < 0 || y < 0) {
            return false;
        } else if (x > 6 || y > 6) {
            return false;
        } else {

            if (x_from < x) {
                if (gameStackPane.getStyleClass().contains("border-bottom") ||
                        gameStackPane.getStyleClass().contains("border-toprightbottom") ||
                        gameStackPane.getStyleClass().contains("border-rightbottomleft") ||
                        gameStackPane.getStyleClass().contains("border-rightbottom") ||
                        gameStackPane.getStyleClass().contains("border-bottomleft"))
                    return false;
            }
            else if (x_from > x) {
                if (gameStackPane.getStyleClass().contains("border-top") ||
                        gameStackPane.getStyleClass().contains("border-toprightleft") ||
                        gameStackPane.getStyleClass().contains("border-topbottom") ||
                        gameStackPane.getStyleClass().contains("border-topright") ||
                        gameStackPane.getStyleClass().contains("border-toprightbottom") ||
                        gameStackPane.getStyleClass().contains("border-topleft"))
                    return false;
            }
            else if (y_from < y) {
                if (gameStackPane.getStyleClass().contains("border-right") ||
                        gameStackPane.getStyleClass().contains("border-toprightleft") ||
                        gameStackPane.getStyleClass().contains("border-topright") ||
                        gameStackPane.getStyleClass().contains("border-toprightbottom") ||
                        gameStackPane.getStyleClass().contains("border-rightbottomleft") ||
                        gameStackPane.getStyleClass().contains("border-rightbottom") ||
                        gameStackPane.getStyleClass().contains("border-rightleft"))
                    return false;
            }
            else if (y_from > y) {
                if (gameStackPane.getStyleClass().contains("border-left") ||
                        gameStackPane.getStyleClass().contains("border-toprightleft") ||
                        gameStackPane.getStyleClass().contains("border-rightbottomleft") ||
                        gameStackPane.getStyleClass().contains("border-topleft") ||
                        gameStackPane.getStyleClass().contains("border-bottomleft") ||
                        gameStackPane.getStyleClass().contains("border-rightleft"))
                    return false;
            }
        }

        return true;
    }

}
