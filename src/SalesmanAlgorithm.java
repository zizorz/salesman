import java.util.ArrayList;
import java.util.List;

public class SalesmanAlgorithm implements RunnableTimedAlgorithm {

    private City city;
    private SalesmanBehaviour salesmanBehaviour;
    private List<Position> salesmenPositions = new ArrayList<>();
    private double minutes;
    private Position startPosition;

    SalesmanAlgorithm(City city, SalesmanBehaviour salesmanBehaviour, Position startPosition) {
        this.city = city;
        this.salesmanBehaviour = salesmanBehaviour;
        this.startPosition = startPosition;
        reset();
    }

    @Override
    public double run() {
        while(!city.isAllConverted()) {
            int nrOfSalesmen = salesmenPositions.size();
            for (int i = 0; i < nrOfSalesmen; i++) {
                Position position = salesmenPositions.get(i);
                boolean converted = convertInhabitant(position);
                if (converted) {
                    salesmenPositions.add(newSalesman(position));
                }
                moveSalesman(position);
            }
            minutes++;
        }
        return minutes;
    }

    @Override
    public void reset() {
        this.city.reset();
        this.minutes = 0;
        this.salesmenPositions.clear();
        this.salesmenPositions.add(startPosition);
    }

    private boolean convertInhabitant(Position position) {
        if (!city.isConverted(position)) {
            city.convert(position);
            return true;
        }
        return false;
    }

    private void moveSalesman(Position position) {
        Position nextPosition = salesmanBehaviour.nextPosition(city, position);
        position.setX(nextPosition.getX());
        position.setY(nextPosition.getY());
    }

    private Position newSalesman(Position position) {
        return salesmanBehaviour.nextPosition(city, position);
    }

}
