/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;
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

    private int numvehiclesNorth;
    private int numvehiclesSouth;
    private int numvehiclesEast;
    private int numvehiclesWest;

    private final int maxvehiclePass = 2;

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

    /**
     * change/set state of streetLight
     *
     * @return void
     *
     * @param streetLightsIParam
     */
    public void SetState(StreetLightsStateI streetLightsIParam) {
        Logger.writeMessage("Entering a SetState() method of StreetLightsContext Class", Logger.DebugLevel.STREET_LIGHTS_CONTEXT);

        streetLightsI = streetLightsIParam;
        streetLightsI.passvehicles();
        Logger.writeMessage("Leaving a SetState() method of StreetLightsContext Class", Logger.DebugLevel.STREET_LIGHTS_CONTEXT);
    }

    /**
     * add new vehicle to specific direction
     *
     * @return void
     *
     * @param (direction, numvehicles)
     */
    public void addvehicles(Directions direction, int numvehicles) {
        Logger.writeMessage("Entering a addvehicles() method of StreetLightsContext Class", Logger.DebugLevel.STREET_LIGHTS_CONTEXT);

        boolean isPassvehicle = false;
        switch (direction) {
            case NORTH:
                isPassvehicle = streetLightsI.addvehiclesToNorth(numvehicles);
                break;
            case SOUTH:
                isPassvehicle = streetLightsI.addvehiclesToSouth(numvehicles);
                break;
            case EAST:
                isPassvehicle = streetLightsI.addvehiclesToEast(numvehicles);
                break;
            case WEST:
                isPassvehicle = streetLightsI.addvehiclesToWest(numvehicles);
                break;
        }
        if (isPassvehicle) {
            streetLightsI.passvehicles();
        }
        Logger.writeMessage("Leaving a addvehicles() method of StreetLightsContext Class", Logger.DebugLevel.STREET_LIGHTS_CONTEXT);
    }

     /**
     * turn the lights red/green as specified in the param
     *
     * @return void
     *
     * @param (direction, tfColor)
     */
    public void turnLight(Directions direction, TrafficLightColors tfColor) {
        Logger.writeMessage("Entering a turnLight() method of StreetLightsContext Class", Logger.DebugLevel.STREET_LIGHTS_CONTEXT);
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
        Logger.writeMessage("Leaving a turnLight() method of StreetLightsContext Class", Logger.DebugLevel.STREET_LIGHTS_CONTEXT);
    }

     /**
     * getter for vehicle on north
     *
     * @return int
     *
     */
    public int getNumvehiclesNorth() {
        return numvehiclesNorth;
    }

     /**
     * setter for vehicle on north
     *
     * @return void
     *
     */
    public void setNumvehiclesNorth(int numvehiclesNorth) {
        this.numvehiclesNorth = numvehiclesNorth;
    }

    /**
     * getter for vehicle on south
     *
     * @return int
     *
     */
    public int getNumvehiclesSouth() {
        return numvehiclesSouth;
    }

     /**
     * setter for vehicle on south
     *
     * @return void
     *
     */
    public void setNumvehiclesSouth(int numvehiclesSouth) {
        this.numvehiclesSouth = numvehiclesSouth;
    }

     /**
     * getter for vehicle on east
     *
     * @return int
     *
     */
    public int getNumvehiclesEast() {
        return numvehiclesEast;
    }

     /**
     * setter for vehicle on east
     *
     * @return void
     *
     */
    public void setNumvehiclesEast(int numvehiclesEast) {
        this.numvehiclesEast = numvehiclesEast;
    }

     /**
     * getter for vehicle on west
     *
     * @return int
     *
     */
    public int getNumvehiclesWest() {
        return numvehiclesWest;
    }

     /**
     * setter for vehicle on west
     *
     * @return void
     *
     */
    public void setNumvehiclesWest(int numvehiclesWest) {
        this.numvehiclesWest = numvehiclesWest;
    }

     /**
     * getter for StartStateimpl object 
     *
     * @return StreetLightsStateI
     *
     */
    public StreetLightsStateI getStartStateImpl() {
        return startStateImpl;
    }

     /**
     * getter for NorthGreenState object 
     *
     * @return StreetLightsStateI
     *
     */
    public StreetLightsStateI getNorthGreenState() {
        return northGreenState;
    }

     /**
     * getter for SouthGreenState object 
     *
     * @return StreetLightsStateI
     *
     */
    public StreetLightsStateI getSouthGreenState() {
        return southGreenState;
    }

     /**
     * getter for EastGreenState object 
     *
     * @return StreetLightsStateI
     *
     */
    public StreetLightsStateI getEastGreenState() {
        return eastGreenState;
    }

     /**
     * getter for WestGreenState object 
     *
     * @return StreetLightsStateI
     *
     */
    public StreetLightsStateI getWestGreenState() {
        return westGreenState;
    }

     /**
     * getter for max number vehicles can passed 
     *
     * @return int
     *
     */
    public int getMaxvehiclePass() {
        return maxvehiclePass;
    }

    /**
     * override toString to return current state of streetlight
     *
     * @return String
     *
     */
    @Override
    public String toString() {
        return "The current state of the StreetLight is" + streetLightsI.toString();
    }
}
