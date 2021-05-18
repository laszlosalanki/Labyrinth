package labyrinthgame;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameClass {

    private final int x_pos;
    private final int y_pos;
    GridPane gameGridPane;

    public GameClass(int x, int y, GridPane gameGridPane) {

        x_pos = x;
        y_pos = y;
        this.gameGridPane = gameGridPane;

    }

    public boolean canGoTo(int x, int y) {

        if (x < 0 || y < 0) {
            return false;
        } else if (x > 6 || y > 6) {
            return false;
        } else {

            ObservableList<Node> childrens = gameGridPane.getChildren();
            for (Node node : childrens) {
                if (node instanceof StackPane && GridPane.getRowIndex(node) == x_pos && GridPane.getColumnIndex(node) == y_pos) {
                    if (x_pos < x) {
                        if (node.getStyleClass().contains("border-bottom") ||
                            node.getStyleClass().contains("border-toprightbottom") ||
                            node.getStyleClass().contains("border-rightbottomleft") ||
                            node.getStyleClass().contains("border-rightbottom") ||
                            node.getStyleClass().contains("border-bottomleft"))
                            return false;
                    }
                    else if (x_pos > x) {
                        if (node.getStyleClass().contains("border-top") ||
                            node.getStyleClass().contains("border-toprightleft") ||
                            node.getStyleClass().contains("border-topbottom") ||
                            node.getStyleClass().contains("border-topright") ||
                            node.getStyleClass().contains("border-toprightbottom") ||
                            node.getStyleClass().contains("border-topleft"))
                            return false;
                    }
                    else if (y_pos < y) {
                        if (node.getStyleClass().contains("border-right") ||
                            node.getStyleClass().contains("border-toprightleft") ||
                            node.getStyleClass().contains("border-topright") ||
                            node.getStyleClass().contains("border-toprightbottom") ||
                            node.getStyleClass().contains("border-rightbottomleft") ||
                            node.getStyleClass().contains("border-rightbottom") ||
                            node.getStyleClass().contains("border-rightleft"))
                            return false;
                    }
                    else if (y_pos > y) {
                        if (node.getStyleClass().contains("border-left") ||
                            node.getStyleClass().contains("border-toprightleft") ||
                            node.getStyleClass().contains("border-rightbottomleft") ||
                            node.getStyleClass().contains("border-topleft") ||
                            node.getStyleClass().contains("border-bottomleft") ||
                            node.getStyleClass().contains("border-rightleft"))
                            return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

}
