import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomSalesmanBehaviour implements SalesmanBehaviour {

    private Random random;

    RandomSalesmanBehaviour() {
        random = new Random();
    }

    @Override
    public Position nextPosition(City city, Position position) {
        List<Position> positions = getValidPositions(city, position);
        int index = random.nextInt(positions.size());
        return positions.get(index);
    }

    private List<Position> getValidPositions(City city, Position position) {
        List<Position> positions = new ArrayList<>();
        positions.add(position.getPositionAbove());
        positions.add(position.getPositionBelow());
        positions.add(position.getPositionLeft());
        positions.add(position.getPositionRight());
        return positions.stream().filter(city::isInbounds).collect(Collectors.toList());
    }
}
