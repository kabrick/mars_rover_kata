package com.douglas.marsrover;

public class Coordinates {
    private Position x;
    private Position y;
    private Direction direction;

    public void setX(Position value) { x = value; }

    public Position getX() { return x; }

    public void setY(Position value) { y = value; }

    public Position getY() { return y; }

    public void setDirection(Direction value) {
        direction = value;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinates(Position x, Position y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    protected void move(Direction directionValue) {
        int x_position = x.getPosition();
        int y_location = y.getPosition();
        switch (directionValue) {
            case NORTH:
                y_location = y.getForwardPosition();
                break;
            case EAST:
                x_position = x.getForwardPosition();
                break;
            case SOUTH:
                y_location = y.getBackwardPosition();
                break;
            case WEST:
                x_position = x.getBackwardPosition();
                break;
        }

        x.setPosition(x_position);
        y.setPosition(y_location);
    }

    public void moveForward() {
        move(direction);
    }

    public void moveBackward() {
        move(direction.getBackwardDirection());
    }

    private void changeDirection(Direction directionValue, int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + directionValue.getValue() + directionStep) % directions;
        direction = Direction.values()[index];
    }

    public void changeDirectionLeft() {
        changeDirection(direction, -1);
    }

    public void changeDirectionRight() {
        changeDirection(direction, 1);
    }

    @Override
    public String toString() {
        return getX().getPosition() + " X " + getY().getPosition() + " " + getDirection().getShortName();
    }
}
