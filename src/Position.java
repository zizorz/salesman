class Position {

    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    Position getPositionAbove() {
        return new Position(x, y - 1);
    }

    Position getPositionBelow() {
        return new Position(x, y + 1);
    }

    Position getPositionRight() {
        return new Position(x + 1, y);
    }

    Position getPositionLeft() {
        return new Position(x - 1, y);
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
