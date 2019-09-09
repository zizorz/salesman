class City {

    private int size;
    private int totalResidents;
    private boolean[][] converted;
    private int nrOfConverted;

    City(int size) {
        this.size = size;
        totalResidents = size*size;
        converted = new boolean[size][size];
        nrOfConverted = 0;
    }

    boolean isConverted(Position position) {
        return converted[position.getY()][position.getX()];
    }

    boolean isAllConverted() {
        return nrOfConverted == totalResidents;
    }

    void convert(Position position) {
        converted[position.getY()][position.getX()] = true;
        nrOfConverted++;
    }

    boolean isInbounds(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    void reset() {
        converted = new boolean[size][size];
        nrOfConverted = 0;
    }

    @Override
    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append("[").append(converted[i][j] ? "X" : " ").append("]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
