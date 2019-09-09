public class Main {

    public static void main(String[] args) {
        SalesmanBehaviour behaviour = new RandomSalesmanBehaviour();
        City city = new City(10);
        SalesmanAlgorithm algorithm = new SalesmanAlgorithm(city, behaviour, new Position(0, 0));
        TimedAlgorithmRunner runner = new TimedAlgorithmRunner(algorithm, 100);
        runner.runAlgorithm();
        System.out.println(runner.getMeanRunningTime());
    }

}
