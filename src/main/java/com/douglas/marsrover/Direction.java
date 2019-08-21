package com.douglas.marsrover;

public enum Direction {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private int value;
    private char short_name;

    private Direction(int new_value, char short_name_value) {
        value = new_value;
        short_name = short_name_value;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getValue() + 2) % 4];
    }

    public int getValue() {
        return value;
    }

    public char getShortName() { return short_name; }
}
