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
public class SouthGreenState implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;
    private int vehiclesPassed = 0;

    public SouthGreenState(StreetLightsContext streetLightsContextParam, Results resultsParam) {
        this.streetLightsContext = streetLightsContextParam;
        this.results = resultsParam;
    }

    /**
     * add new vehicle(s) on north side
     *
     * @return boolean to let know if vehicle should be passed.
     *
     * @param numvehicles
     */
    @Override
    public boolean addvehiclesToNorth(int numvehicles) {
        Logger.writeMessage("Entering a addvehiclesToNorth() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult(numvehicles + " vehicle(s) added on north.");
        numvehicles += streetLightsContext.getNumvehiclesNorth();
        streetLightsContext.setNumvehiclesNorth(numvehicles);
        Logger.writeMessage("Leaving a addvehiclesToNorth() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        return false;
    }

    /**
     * add new vehicle(s) on south side
     *
     * @return boolean to let know if vehicle should be passed.
     *
     * @param numvehicles
     */
    @Override
    public boolean addvehiclesToSouth(int numvehicles) {
        Logger.writeMessage("Entering a addvehiclesToSouth() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult(numvehicles + " vehicle(s) added on south.");
        numvehicles += streetLightsContext.getNumvehiclesSouth();
        streetLightsContext.setNumvehiclesSouth(numvehicles);
        Logger.writeMessage("Leaving a addvehiclesToSouth() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        return true;
    }

    /**
     * add new vehicle(s) on east side
     *
     * @return boolean to let know if vehicle should be passed.
     *
     * @param numvehicles
     */
    @Override
    public boolean addvehiclesToEast(int numvehicles) {
        Logger.writeMessage("Entering a addvehiclesToEast() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult(numvehicles + " vehicle(s) added on east.");
        numvehicles += streetLightsContext.getNumvehiclesEast();
        streetLightsContext.setNumvehiclesEast(numvehicles);
        Logger.writeMessage("Leaving a addvehiclesToEast() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        return false;
    }

    /**
     * add new vehicle(s) on west side
     *
     * @return boolean to let know if vehicle should be passed.
     *
     * @param numvehicles
     */
    @Override
    public boolean addvehiclesToWest(int numvehicles) {
        Logger.writeMessage("Entering a addvehiclesToWest() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult(numvehicles + " vehicle(s) added on west.");
        numvehicles += streetLightsContext.getNumvehiclesWest();
        streetLightsContext.setNumvehiclesWest(numvehicles);
        Logger.writeMessage("Leaving a addvehiclesToWest() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        return false;
    }

    /**
     * pass vehicle(s) upto max range on east side and change state after max
     * range
     *
     * @return void
     *
     */
    @Override
    public void passvehicles() {
        Logger.writeMessage("Entering a passvehicles() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        int numvehicles = streetLightsContext.getNumvehiclesSouth();
        if (numvehicles > 0) {
            int vehiclePassedThisCall = 0;
            for (int i = 1; i <= numvehicles; i++) {
                vehiclePassedThisCall += 1;
                vehiclesPassed += 1;
                if (vehiclesPassed == streetLightsContext.getMaxvehiclePass()) {
                    break;
                }
            }
            numvehicles = numvehicles - vehiclePassedThisCall;
            streetLightsContext.setNumvehiclesSouth(numvehicles);
            results.storeNewResult(vehiclePassedThisCall + " vehicle(s) passed from south.");

        } else {
            results.storeNewResult("There is no vehicle to be pass from south.");
        }

        if (vehiclesPassed == streetLightsContext.getMaxvehiclePass()) {
            vehiclesPassed = 0;
            results.storeNewResult("South is truned to red and West is turned to green.");
            streetLightsContext.SetState(streetLightsContext.getWestGreenState());
        }
        Logger.writeMessage("Leaving a passvehicles() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

    }

    /**
     * turn north to red
     *
     * @return void
     *
     */
    @Override
    public void turnNorthRed() {
        Logger.writeMessage("Entering a turnNorthRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("North is already red.");

        Logger.writeMessage("Leaving a turnNorthRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn north to green
     *
     * @return void
     *
     */
    @Override
    public void turnNorthGreen() {
        Logger.writeMessage("Entering a turnNorthGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("North is turned to green and South is turned to red.");
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());

        Logger.writeMessage("Leaving a turnNorthGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn south to red
     *
     * @return void
     *
     */
    @Override
    public void turnSouthRed() {
        Logger.writeMessage("Entering a turnSouthRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("South is turned to red and West is turned to green.");
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());

        Logger.writeMessage("Leaving a turnSouthRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn south to green
     *
     * @return void
     *
     */
    @Override
    public void turnSouthGreen() {
        Logger.writeMessage("Entering a turnSouthGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("South is already green.");

        Logger.writeMessage("Leaving a turnSouthGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn east to red
     *
     * return void
     *
     */
    @Override
    public void turnEastRed() {
        Logger.writeMessage("Entering a turnEastRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("East is already red.");

        Logger.writeMessage("Leaving a turnEastRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn east to green
     *
     * return void
     *
     */
    @Override
    public void turnEastGreen() {
        Logger.writeMessage("Entering a turnEastGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("East is turned to green and South is turned to red.");
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());

        Logger.writeMessage("Leaving a turnEastGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn west to red
     *
     * return void
     *
     */
    @Override
    public void turnWestRed() {
        Logger.writeMessage("Entering a turnWestRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("West is already red.");

        Logger.writeMessage("Leaving a turnWestRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn west to green
     *
     * return void
     *
     */
    @Override
    public void turnWestGreen() {
        Logger.writeMessage("Entering a turnWestGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("West is turned to green and South is turned to red.");
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());

        Logger.writeMessage("Leaving a turnWestGreen() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * turn all signals to red
     *
     * return void
     *
     */
    @Override
    public void turnAllRed() {
        Logger.writeMessage("Entering a turnAllRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);

        results.storeNewResult("All lights turned red.");
        streetLightsContext.SetState(streetLightsContext.getStartStateImpl());

        Logger.writeMessage("Leaving a turnAllRed() method of SouthGreenState Class", Logger.DebugLevel.SOUTH_GREEN_STATE);
    }

    /**
     * overrides the default string for this class
     *
     * return String
     *
     */
    @Override
    public String toString() {
        return "South Green State";
    }
}
