package team.emergence._15puzzle.model;

public class GameConfig {
    private final int difficulty;
    private final String filePath;
    private double tileSize;

    public GameConfig(int difficulty, String filePath) {
        this.difficulty = difficulty;
        this.filePath = filePath;
        this.tileSize = 600.0 / difficulty;
    }

    public GameConfig(int difficulty, String filePath, double tileSize) {
        this.difficulty = difficulty;
        this.filePath = filePath;
        this.tileSize = tileSize;
        this.tileSize = 600.0 / difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getFilePath() {
        return filePath;
    }

    public double getTileSize() {
        return tileSize;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "difficulty=" + difficulty +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}

