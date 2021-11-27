package team.emergence._15puzzle.util.animation;

import javafx.scene.Node;
import javafx.scene.shape.MoveTo;

public class MoveToAbs extends MoveTo {
    public MoveToAbs(Node node, double x, double y) {
        super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2,
                y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
    }

}