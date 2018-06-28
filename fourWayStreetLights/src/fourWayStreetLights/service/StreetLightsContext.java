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
        NORTH, SOUTH, EAST, WEST, ALL
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

    private int numVehicalsNorth;
    private int numVehicalsSouth;
    private int numVehicalsEast;
    private int numVehicalsWest;

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

    public int getNumVehicalsNorth() {
        return numVehicalsNorth;
    }

    public void setNumVehicalsNorth(int numVehicalsNorth) {
        this.numVehicalsNorth = numVehicalsNorth;
    }

    public int getNumVehicalsSouth() {
        return numVehicalsSouth;
    }

    public void setNumVehicalsSouth(int numVehicalsSouth) {
        this.numVehicalsSouth = numVehicalsSouth;
    }

    public int getNumVehicalsEast() {
        return numVehicalsEast;
    }

    public void setNumVehicalsEast(int numVehicalsEast) {
        this.numVehicalsEast = numVehicalsEast;
    }

    public int getNumVehicalsWest() {
        return numVehicalsWest;
    }

    public void setNumVehicalsWest(int numVehicalsWest) {
        this.numVehicalsWest = numVehicalsWest;
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

    public void addVehicals(Directions direction, int numVehicals) {
        boolean isPassVehical = false;
        switch (direction) {
            case NORTH:
                isPassVehical = streetLightsI.addVehicalsToNorth(numVehicals);
                break;
            case SOUTH:
                isPassVehical = streetLightsI.addVehicalsToSouth(numVehicals);
                break;
            case EAST:
                isPassVehical = streetLightsI.addVehicalsToEast(numVehicals);
                break;
            case WEST:
                isPassVehical = streetLightsI.addVehicalsToWest(numVehicals);
                break;
        }
        if (isPassVehical) {
            streetLightsI.passVehicals();
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

            case ALL:
                streetLightsI.turnAllRed();
                break;
        }
    }

}
