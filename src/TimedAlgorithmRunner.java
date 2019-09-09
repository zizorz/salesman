import java.util.Arrays;

class TimedAlgorithmRunner {

    private RunnableTimedAlgorithm algorithm;
    private double[] results;
    private int times;

    TimedAlgorithmRunner(RunnableTimedAlgorithm algorithm, int times) {
        this.algorithm = algorithm;
        results = new double[times];
        this.times = times;
    }

    void runAlgorithm() {
        for(int i = 0; i < times; i++) {
            double result = algorithm.run();
            results[i] = result;
            algorithm.reset();
        }
    }

    double getMeanRunningTime() {
        double total = Arrays.stream(results).sum();
        return total / times;
    }
}
