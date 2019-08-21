package com.douglas.marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.awt.*;

public class PositionTest {
    Position position;

    private final int location = 8;
    private final int maxLocation = 12;

    @Before
    public void beforePointTest() {
        position = new Position(location, maxLocation);
    }

    @Test
    public void testPositionAssignment() {
        assertThat(position.getPosition()).isEqualTo(location);
        assertThat(position.getMaximumPosition()).isEqualTo(maxLocation);
    }

    @Test
    public void testIncreasePositionByOne() {
        int expected = position.getPosition() + 1;
        assertThat(position.getForwardPosition()).isEqualTo(expected);
    }

    @Test
    public void testDecreasePositionByOne() {
        int expected = position.getPosition() - 1;
        assertThat(position.getBackwardPosition()).isEqualTo(expected);
    }
}
