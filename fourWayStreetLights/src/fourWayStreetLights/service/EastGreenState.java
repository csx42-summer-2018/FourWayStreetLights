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
public class EastGreenState implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;

    public EastGreenState(StreetLightsContext streetLightsContextParam, Results resultsParam) {
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
        return true;
    }

    @Override
    public boolean addVehicalsToWest(int numVehicals) {
        results.storeNewResult(numVehicals + " vehical(s) added on west.");
        numVehicals += streetLightsContext.getNumVehicalsWest();
        streetLightsContext.setNumVehicalsWest(numVehicals);
        return false;
    }

    @Override
    public void passVehicals() {
        int numVehicals = streetLightsContext.getNumVehicalsEast();
        if (numVehicals > 1) {
            numVehicals = numVehicals - 2;
            streetLightsContext.setNumVehicalsEast(numVehicals);
            results.storeNewResult("2 vehicals passed from east.");
            streetLightsContext.SetState(streetLightsContext.getSouthGreenState());
            results.storeNewResult("East is truned to red and South is turned to green.");
        } else if (numVehicals == 1) {
            numVehicals = numVehicals - 1;
            streetLightsContext.setNumVehicalsEast(numVehicals);
            results.storeNewResult("1 vehical passed from east.");
        } else {
            results.storeNewResult("There is no vehical to be pass from east.");
        }
    }

    @Override
    public void turnNorthRed() {
        results.storeNewResult("North is already red.");
    }

    @Override
    public void turnNorthGreen() {
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
        results.storeNewResult("North is turned to green and East is turned to red.");
    }

    @Override
    public void turnSouthRed() {
        results.storeNewResult("South is already red.");
    }

    @Override
    public void turnSouthGreen() {
        streetLightsContext.SetState(streetLightsContext.getSouthGreenState());
        results.storeNewResult("South is turned to green and East is turned to red.");
    }

    @Override
    public void turnEastRed() {
        streetLightsContext.SetState(streetLightsContext.getSouthGreenState());
        results.storeNewResult("East is turned to red and South is turned to green.");
    }

    @Override
    public void turnEastGreen() {
        results.storeNewResult("East is already green.");
    }

    @Override
    public void turnWestRed() {
        results.storeNewResult("West is already red.");
    }

    @Override
    public void turnWestGreen() {
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());
        results.storeNewResult("West is turned to green and East is turned to red.");
    }

    @Override
    public void turnAllRed() {
        streetLightsContext.SetState(streetLightsContext.getStartStateImpl());
        results.storeNewResult("All lights turned red.");
    }
}
