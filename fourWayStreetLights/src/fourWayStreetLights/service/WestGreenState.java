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
public class WestGreenState implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;
    private int vehicalsPassed  = 0;

    public WestGreenState(StreetLightsContext streetLightsContextParam, Results resultsParam) {
        this.streetLightsContext = streetLightsContextParam;
        this.results = resultsParam;
    }

    @Override
    public boolean addVehicalsToNorth(int numVehicals) {
        results.storeNewResult(numVehicals + " vehical(s) added on north.");
        numVehicals += streetLightsContext.getNumVehicalsNorth();
        streetLightsContext.setNumVehicalsNorth(numVehicals);
        return false;
    }

    @Override
    public boolean addVehicalsToSouth(int numVehicals) {
        results.storeNewResult(numVehicals + " vehical(s) added on south.");
        numVehicals += streetLightsContext.getNumVehicalsSouth();
        streetLightsContext.setNumVehicalsSouth(numVehicals);
        return false;
    }

    @Override
    public boolean addVehicalsToEast(int numVehicals) {
        results.storeNewResult(numVehicals + " vehical(s) added on east.");
        numVehicals += streetLightsContext.getNumVehicalsEast();
        streetLightsContext.setNumVehicalsEast(numVehicals);
        return false;
    }

    @Override
    public boolean addVehicalsToWest(int numVehicals) {
        results.storeNewResult(numVehicals + " vehical(s) added on west.");
        numVehicals += streetLightsContext.getNumVehicalsWest();
        streetLightsContext.setNumVehicalsWest(numVehicals);
        return true;
    }

    @Override
    public void passVehicals() {
        int numVehicals = streetLightsContext.getNumVehicalsWest();
        if (numVehicals > 1) {
            
            numVehicals = numVehicals - 2;
            streetLightsContext.setNumVehicalsWest(numVehicals);
            results.storeNewResult("2 vehicals passed from west.");
            streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
            results.storeNewResult("West is truned to red and North is turned to green.");
        } else if (numVehicals == 1) {
            numVehicals = numVehicals - 1;
            streetLightsContext.setNumVehicalsWest(numVehicals);
            results.storeNewResult("1 vehical passed from west.");
        } else {
            results.storeNewResult("There is no vehical to be pass from west.");
        }
    }

    @Override
    public void turnNorthRed() {
        results.storeNewResult("North is already red.");

    }

    @Override
    public void turnNorthGreen() {
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
        results.storeNewResult("North is turned to green and West is turned to red.");

    }

    @Override
    public void turnSouthRed() {
        results.storeNewResult("South is already red.");
    }

    @Override
    public void turnSouthGreen() {
        streetLightsContext.SetState(streetLightsContext.getSouthGreenState());
        results.storeNewResult("South is turned to green and West is turned to red.");
    }

    @Override
    public void turnEastRed() {
        results.storeNewResult("East is already red.");
    }

    @Override
    public void turnEastGreen() {
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());
        results.storeNewResult("East is turned to green and West is turned to red.");
    }

    @Override
    public void turnWestRed() {
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
        results.storeNewResult("West is turned to red and North is turned to green.");
    }

    @Override
    public void turnWestGreen() {
        results.storeNewResult("West is already green.");
    }

    @Override
    public void turnAllRed() {
        streetLightsContext.SetState(streetLightsContext.getStartStateImpl());
        results.storeNewResult("All lights turned red.");
    }
}
