package com.douglas.marsrover;

public class MarsRover {
    private Coordinates coordinates;
    public void setCoordinates(Coordinates value) {
        coordinates = value;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public MarsRover(Coordinates coordinatesValue) {
        setCoordinates(coordinatesValue);
    }

    public void receiveCommands(String commands) throws Exception {
        for (char command : commands.toCharArray()) {
            if (!receiveSingleCommand(command)) {
                break;
            }
        }
    }

    public boolean receiveSingleCommand(char command) throws Exception {
        switch(Character.toUpperCase(command)) {
            case 'F':
                getCoordinates().moveForward();
                return true;
            case 'B':
                getCoordinates().moveBackward();
                return true;
            case 'L':
                getCoordinates().changeDirectionLeft();
                return true;
            case 'R':
                getCoordinates().changeDirectionRight();
                return true;
            default:
                throw new Exception("Please input a valid command to move the rover");
        }
    }

    public String getPosition() {
        return getCoordinates().toString();
    }
}
