package team.emergence._15puzzle.core;

import java.util.concurrent.TimeUnit;

public class Stopwatch {
    private long startTime = 0;
    private long pausedTime = 0;
    private long resumedTime = 0;
    private long lastElapsedTime = 0;
    private boolean isPaused = false;
    private boolean isPausedOnce = false;


    public void start() {
        this.startTime = System.nanoTime();
    }

    public void pause() {
        this.pausedTime = System.nanoTime();
        if (!isPausedOnce) {
            this.lastElapsedTime = lastElapsedTime + (pausedTime - startTime);
        } else {
            this.lastElapsedTime = lastElapsedTime + (pausedTime - resumedTime);
        }
        this.isPaused = true;
    }

    public void resume() {
        this.resumedTime = System.nanoTime();
        isPausedOnce = true;
        this.isPaused = false;
    }

    private long getElapsedMilliseconds() {
        long elapsedTime;

        if (isPaused) {
            if (!isPausedOnce) {
                elapsedTime = pausedTime - startTime;
            } else {
                elapsedTime = lastElapsedTime;
            }
        } else {
            if (!isPausedOnce) {
                elapsedTime = (pausedTime - startTime) + (System.nanoTime() - resumedTime);
            } else {
                elapsedTime = lastElapsedTime + (System.nanoTime() - resumedTime);
            }
        }

        long nanoSecondsPerMillisecond = 1000000;
        return elapsedTime / nanoSecondsPerMillisecond;
    }

    @Override
    public String toString() {
        long millis = this.getElapsedMilliseconds();
        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
    }
}
