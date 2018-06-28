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
public class StartStateImpl implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;

    public StartStateImpl(StreetLightsContext streetLightsContextParam, Results resultsParam) {
        this.streetLightsContext = streetLightsContextParam;
        this.results = resultsParam;
    }

    @Override
    public boolean addVehicalsToNorth(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToNorth() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult(numVehicals + " vehical(s) added on north.");
        numVehicals += streetLightsContext.getNumVehicalsNorth();
        streetLightsContext.setNumVehicalsNorth(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToNorth() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        return false;
    }

    @Override
    public boolean addVehicalsToSouth(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToSouth() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult(numVehicals + " vehical(s) added on south.");
        numVehicals += streetLightsContext.getNumVehicalsSouth();
        streetLightsContext.setNumVehicalsSouth(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToSouth() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        return false;
    }

    @Override
    public boolean addVehicalsToEast(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToEast() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult(numVehicals + " vehical(s) added on east.");
        numVehicals += streetLightsContext.getNumVehicalsEast();
        streetLightsContext.setNumVehicalsEast(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToEast() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        return false;
    }

    @Override
    public boolean addVehicalsToWest(int numVehicals) {
        Logger.writeMessage("Entering a addVehicalsToWest() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult(numVehicals + " vehical(s) added on west.");
        numVehicals += streetLightsContext.getNumVehicalsWest();
        streetLightsContext.setNumVehicalsWest(numVehicals);
        Logger.writeMessage("Leaving a addVehicalsToWest() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        return false;
    }

    @Override
    public void passVehicals() {
        Logger.writeMessage("Entering a passVehicals() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("No vehical pass as all lights are red");

        Logger.writeMessage("Leaving a passVehicals() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnNorthRed() {
        Logger.writeMessage("Entering a turnNorthRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("North is already red.");

        Logger.writeMessage("Leaving a turnNorthRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnNorthGreen() {
        Logger.writeMessage("Entering a turnNorthGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("North is turned to green.");
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
        Logger.writeMessage("Leaving a turnNorthGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

    }

    @Override
    public void turnSouthRed() {
        Logger.writeMessage("Entering a turnSouthRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("South is already red.");

        Logger.writeMessage("Leaving a turnSouthRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnSouthGreen() {
        Logger.writeMessage("Entering a turnSouthGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("South is turned to green.");
        streetLightsContext.SetState(streetLightsContext.getSouthGreenState());

        Logger.writeMessage("Leaving a turnSouthGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnEastRed() {
        Logger.writeMessage("Entering a turnEastRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("South is already red.");

        Logger.writeMessage("Leaving a turnEastRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnEastGreen() {
        Logger.writeMessage("Entering a turnEastGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("East is turned to green.");
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());

        Logger.writeMessage("Leaving a turnEastGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnWestRed() {
        Logger.writeMessage("Entering a turnWestRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("West is already red.");

        Logger.writeMessage("Leaving a turnWestRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnWestGreen() {
        Logger.writeMessage("Entering a turnWestGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("West is turned to green.");
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());

        Logger.writeMessage("Leaving a turnWestGreen() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }

    @Override
    public void turnAllRed() {
        Logger.writeMessage("Entering a turnAllRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);

        results.storeNewResult("All lights are already red.");

        Logger.writeMessage("Leaving a turnAllRed() method of StartStateImpl Class", Logger.DebugLevel.START_STATE_IMPL);
    }
    
     @Override
     public String toString() {
        return "Start State where all states are red";
    }
}
