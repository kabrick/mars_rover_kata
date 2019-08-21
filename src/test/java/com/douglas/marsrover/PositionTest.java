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
}
