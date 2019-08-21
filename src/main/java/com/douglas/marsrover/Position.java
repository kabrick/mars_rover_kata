package com.douglas.marsrover;

public class Position {
    private int position;
    private int maximum_position;

    public Position(int position, int maximum_position) {
        this.position = position;
        this.maximum_position = maximum_position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMaximum_position() {
        return maximum_position;
    }

    public void setMaximum_position(int maximum_position) {
        this.maximum_position = maximum_position;
    }
}
