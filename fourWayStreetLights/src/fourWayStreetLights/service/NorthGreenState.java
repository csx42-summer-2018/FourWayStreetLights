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
public class NorthGreenState implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;
    private int vehicalsPassed = 0;

    public NorthGreenState(StreetLightsContext streetLightsContextParam, Results resultsParam) {
        this.streetLightsContext = streetLightsContextParam;
        this.results = resultsParam;
    }

    @Override
    public boolean addVehicalsToNorth(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToNorth() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult(numVehicals + " vehical(s) added on north.");
        numVehicals += streetLightsContext.getNumVehicalsNorth();
        streetLightsContext.setNumVehicalsNorth(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToNorth() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        return true;
    }

    @Override
    public boolean addVehicalsToSouth(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToSouth() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult(numVehicals + " vehical(s) added on south.");
        numVehicals += streetLightsContext.getNumVehicalsSouth();
        streetLightsContext.setNumVehicalsSouth(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToSouth() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        return false;
    }

    @Override
    public boolean addVehicalsToEast(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToEast() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult(numVehicals + " vehical(s) added on east.");
        numVehicals += streetLightsContext.getNumVehicalsEast();
        streetLightsContext.setNumVehicalsEast(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToEast() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        return false;
    }

    @Override
    public boolean addVehicalsToWest(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToWest() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult(numVehicals + " vehical(s) added on west.");
        numVehicals += streetLightsContext.getNumVehicalsWest();
        streetLightsContext.setNumVehicalsWest(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToWest() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        return false;
    }

    @Override
    public void passVehicals() {
        Logger.writeMessage("Entering a passVehicals() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        int numVehicals = streetLightsContext.getNumVehicalsNorth();
        if (numVehicals > 0) {
            int vehicalPassedThisCall = 0;
            for (int i = 1; i <= numVehicals; i++) {
                vehicalPassedThisCall += 1;
                vehicalsPassed += 1;
                if (vehicalsPassed == streetLightsContext.getMaxVehicalPass()) {
                    break;
                }
            }
            numVehicals = numVehicals - vehicalPassedThisCall;
            streetLightsContext.setNumVehicalsNorth(numVehicals);
            results.storeNewResult(vehicalPassedThisCall + " vehical(s) passed from north.");

        } else {
            results.storeNewResult("There is no vehical to be pass from north.");
        }

        if (vehicalsPassed == streetLightsContext.getMaxVehicalPass()) {
            vehicalsPassed = 0;
            results.storeNewResult("North is truned to red and East is turned to green.");
            streetLightsContext.SetState(streetLightsContext.getEastGreenState());

        }
        Logger.writeMessage("Leaving a passVehicals() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

    }

    @Override
    public void turnNorthRed() {
        Logger.writeMessage("Entering a turnNorthRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("North is turned to red and East is turned to green.");
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());

        Logger.writeMessage("Leaving a turnNorthRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnNorthGreen() {
        Logger.writeMessage("Entering a turnNorthGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("North is already green.");

        Logger.writeMessage("Leaving a turnNorthGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnSouthRed() {
        Logger.writeMessage("Entering a turnSouthRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("South is already red.");

        Logger.writeMessage("Leaving a turnSouthRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnSouthGreen() {
        Logger.writeMessage("Entering a turnSouthGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("South is turned to green and East is turned to red.");
        streetLightsContext.SetState(streetLightsContext.getSouthGreenState());

        Logger.writeMessage("Leaving a turnSouthGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnEastRed() {
        Logger.writeMessage("Entering a turnEastRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("East is already red.");

        Logger.writeMessage("Leaving a turnEastRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnEastGreen() {
        Logger.writeMessage("Entering a turnEastGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("East is turned to green and North is turned to red.");
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());

        Logger.writeMessage("Leaving a turnEastGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnWestRed() {
        Logger.writeMessage("Entering a turnWestRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("West is already red.");

        Logger.writeMessage("Leaving a turnWestRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnWestGreen() {
        Logger.writeMessage("Entering a turnWestGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("West is turned to green and North is turned to red.");
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());

        Logger.writeMessage("Leaving a turnWestGreen() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public void turnAllRed() {
        Logger.writeMessage("Entering a turnAllRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);

        results.storeNewResult("All lights turned red.");
        streetLightsContext.SetState(streetLightsContext.getStartStateImpl());

        Logger.writeMessage("Leaving a turnAllRed() method of NorthGreenState Class", Logger.DebugLevel.NORTH_GREEN_STATE);
    }

    @Override
    public String toString() {
        return "North Green State";
    }
}
