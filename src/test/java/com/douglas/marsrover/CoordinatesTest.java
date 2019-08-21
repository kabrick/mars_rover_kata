package com.douglas.marsrover;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinatesTest {
    private Coordinates coordinates;
    private Position x;
    private Position y;
    private final Direction direction = Direction.NORTH;

    @Before
    public void beforeCoordinatesTest() {
        x = new Position(1, 99);
        y = new Position(2, 99);
        coordinates = new Coordinates(x, y, direction);
    }

    @Test
    public void testXAndYAssignment() {
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(x);
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(y);
    }

    @Test
    public void testDirectionAssignment() {
        assertThat(coordinates.getDirection()).isEqualTo(direction);
    }

    @Test
    public void testMoveForwardWhenDirectionIsNorth() {
        Position expected = new Position(y.getPosition() + 1, y.getMaximumPosition());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveForwardWhenDirectionIsEast() {
        Position expected = new Position(x.getPosition() + 1, x.getMaximumPosition());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveForwardWhenDirectionIsSouth() {
        Position expected = new Position(y.getPosition() - 1, y.getMaximumPosition());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveForwardWhenDirectionIsWest() {
        Position expected = new Position(x.getPosition() - 1, x.getMaximumPosition());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveBackwardWhenDirectionIsNorth() {
        Position expected = new Position(y.getPosition() - 1, y.getMaximumPosition());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveBackwardWhenDirectionIsEast() {
        Position expected = new Position(x.getPosition() - 1, x.getMaximumPosition());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveBackwardWhenDirectionIsSouth() {
        Position expected = new Position(y.getPosition() + 1, y.getMaximumPosition());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void testMoveBackwardWhenDirectionIsWest() {
        Position expected = new Position(x.getPosition() + 1, x.getMaximumPosition());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void toStringShouldReturnXAndY() {
        String expected = x.getPosition() + " X " + y.getPosition() + " " + direction.getShortName();
        assertThat(coordinates.toString()).isEqualTo(expected);
    }
}
