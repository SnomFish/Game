package github.snomfish;

public enum Direction {
    NORTH(Math.toRadians(0)),
    EAST(Math.toRadians(90)),
    SOUTH(Math.toRadians(180)),
    WEST(Math.toRadians(270));

    private final double rad;

    Direction(double rad) {
        this.rad = rad;
    }

    
    public double rad() {return rad;}
}
