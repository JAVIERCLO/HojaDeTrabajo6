public class Profiler {

    private long startTime;
    private long endTime;

    public void startTime(){
        startTime = System.nanoTime();
    }

    public void stopTime(){
        endTime = System.nanoTime();
    }

    public double getTime(){
        return (endTime - startTime);
    }

    public double measureTime() {
        startTime();
        
        stopTime();
        return getTime();
    }
}
