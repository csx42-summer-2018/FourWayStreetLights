/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.service;

import fourWayStreetLights.util.Results;

/**
 *
 * @author amitk
 */
public class StreetLightsContext {

    public static enum Directions {
        NORTH, SOUTH, EAST, WEST
    };

    public static enum TrafficLightColors {
        RED, GREEN
    };

    StreetLightsStateI startStateImpl;

    StreetLightsStateI northGreenState;
    StreetLightsStateI southGreenState;
    StreetLightsStateI eastGreenState;
    StreetLightsStateI westGreenState;

    StreetLightsStateI streetLightsI;

    private int numCarsNorth;
    private int numCarsSouth;
    private int numCarsEast;
    private int numCarsWest;

    private Results results;

    public StreetLightsContext(Results resultsParam) {
        results = resultsParam;
        startStateImpl = new StartStateImpl(this, results);
        northGreenState = new NorthGreenState(this, results);
        southGreenState = new SouthGreenState(this, results);
        eastGreenState = new EastGreenState(this, results);
        westGreenState = new WestGreenState(this, results);

        streetLightsI = startStateImpl;
    }

    public int getNumCarsNorth() {
        return numCarsNorth;
    }

    public void setNumCarsNorth(int numCarsNorth) {
        this.numCarsNorth = numCarsNorth;
    }

    public int getNumCarsSouth() {
        return numCarsSouth;
    }

    public void setNumCarsSouth(int numCarsSouth) {
        this.numCarsSouth = numCarsSouth;
    }

    public int getNumCarsEast() {
        return numCarsEast;
    }

    public void setNumCarsEast(int numCarsEast) {
        this.numCarsEast = numCarsEast;
    }

    public int getNumCarsWest() {
        return numCarsWest;
    }

    public void setNumCarsWest(int numCarsWest) {
        this.numCarsWest = numCarsWest;
    }

    public StreetLightsStateI getStartStateImpl() {
        return startStateImpl;
    }

    public StreetLightsStateI getNorthGreenState() {
        return northGreenState;
    }

    public StreetLightsStateI getSouthGreenState() {
        return southGreenState;
    }

    public StreetLightsStateI getEastGreenState() {
        return eastGreenState;
    }

    public StreetLightsStateI getWestGreenState() {
        return westGreenState;
    }

    public void SetState(StreetLightsStateI streetLightsIParam) {
        streetLightsI = streetLightsIParam;
    }

    public void addCars(int numCars, Directions direction) {
        boolean isPassCar = false;
        switch (direction) {
            case NORTH:
                isPassCar = streetLightsI.addCarsToNorth(numCars);
                break;
            case SOUTH:
                isPassCar = streetLightsI.addCarsToSouth(numCars);
                break;
            case EAST:
                isPassCar = streetLightsI.addCarsToEast(numCars);
                break;
            case WEST:
                isPassCar = streetLightsI.addCarsToWest(numCars);
                break;
        }
        if (isPassCar) {
            streetLightsI.passCars();
        }
    }

    public void turnLight(Directions direction, TrafficLightColors tfColor) {
        switch (direction) {
            case NORTH:
                switch (tfColor) {
                    case GREEN:
                        streetLightsI.turnNorthGreen();
                        break;
                    case RED:
                        streetLightsI.turnNorthRed();
                        break;
                }
                break;
            case SOUTH:
                switch (tfColor) {
                    case GREEN:
                        streetLightsI.turnSouthGreen();
                        break;
                    case RED:
                        streetLightsI.turnSouthRed();
                        break;
                }
                break;
            case EAST:
                switch (tfColor) {
                    case GREEN:
                        streetLightsI.turnEastGreen();
                        break;
                    case RED:
                        streetLightsI.turnEastRed();
                        break;
                }
                break;
            case WEST:
                switch (tfColor) {
                    case GREEN:
                        streetLightsI.turnWestGreen();
                        break;
                    case RED:
                        streetLightsI.turnWestRed();
                        break;
                }
                break;

            default:
                streetLightsI.turnAllRed();
                break;
        }
    }

}
