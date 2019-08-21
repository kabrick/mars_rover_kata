package com.douglas.marsrover;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {
    private MarsRover mars_rover;
    private Coordinates mars_rover_coordinates;
    private final Direction direction = Direction.NORTH;
    private Position x;
    private Position y;

    @Before
    public void beforeRoverTest() {
        x = new Position(1, 9);
        y = new Position(2, 9);
        mars_rover_coordinates = new Coordinates(x, y, direction);
        mars_rover = new MarsRover(mars_rover_coordinates);
    }

    @Test
    public void newInstanceShouldSetRoverCoordinatesAndDirection() {
        assertThat(mars_rover.getCoordinates()).isEqualToComparingFieldByField(mars_rover_coordinates);
    }

    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsF() throws Exception {
        int expected = y.getPosition() + 1;
        mars_rover.receiveSingleCommand('F');
        assertThat(mars_rover.getCoordinates().getY().getPosition()).isEqualTo(expected);
    }

    @Test
    public void receiveSingleCommandShouldMoveBackwardWhenCommandIsB() throws Exception {
        int expected = y.getPosition() - 1;
        mars_rover.receiveSingleCommand('B');
        assertThat(mars_rover.getCoordinates().getY().getPosition()).isEqualTo(expected);
    }

    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        mars_rover.receiveSingleCommand('L');
        assertThat(mars_rover.getCoordinates().getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        mars_rover.receiveSingleCommand('R');
        assertThat(mars_rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }
}
