public class Profiler {
    private long startTime;
    private long endTime;

    public void startTime() {
        startTime = System.nanoTime();
    }

    public void stopTime() {
        endTime = System.nanoTime();
    }

    public double getTime() {
        return (endTime - startTime) / 1000000.0;
    }

    public double measureTime(Runnable task) {
        startTime();
        task.run();
        stopTime();
        return getTime();
    }
}
