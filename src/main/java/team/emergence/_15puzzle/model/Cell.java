package team.emergence._15puzzle.model;

import team.emergence._15puzzle.util.Constants;

public class Cell implements Cloneable {
    private final int x;
    private final int y;
    private final double offsetX;
    private final double offsetY;
    private final double tileSize;

    private final int initialValue;
    private int value;

    public Cell(int x, int y, int initialValue, int tileCount, double tileSize) {
        this.x = x;
        this.y = y;
        this.initialValue = initialValue;
        this.value = initialValue;
        this.tileSize = tileSize;
        this.offsetX = (Constants.SCENE_WIDTH - tileCount * tileSize) / 2;
        this.offsetY = (Constants.SCENE_HEIGHT - tileCount * tileSize) / 2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getLayoutX() {
        return x * tileSize + offsetX;
    }

    public double getLayoutY() {
        return y * tileSize + offsetY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSolved() {
        return this.value == this.initialValue;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d] with value=%d -> offsetX=%f; offsetY=%f; initialValue=%d\n", x, y, value, offsetX, offsetY, initialValue);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}