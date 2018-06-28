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
public class StartStateImpl implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;

    public StartStateImpl(StreetLightsContext streetLightsContextParam, Results resultsParam) {
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
        return false;
    }

    @Override
    public void passVehicals() {
        results.storeNewResult("No vehical pass as all lights are red");
    }

    @Override
    public void turnNorthRed() {
        results.storeNewResult("North is already red.");
    }

    @Override
    public void turnNorthGreen() {
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
        results.storeNewResult("North is turned to green.");
    }

    @Override
    public void turnSouthRed() {
        results.storeNewResult("South is already red.");
    }

    @Override
    public void turnSouthGreen() {
        streetLightsContext.SetState(streetLightsContext.getSouthGreenState());
        results.storeNewResult("South is turned to green.");
    }

    @Override
    public void turnEastRed() {
        results.storeNewResult("South is already red.");
    }

    @Override
    public void turnEastGreen() {
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());
        results.storeNewResult("East is turned to green.");
    }

    @Override
    public void turnWestRed() {
        results.storeNewResult("West is already red.");
    }

    @Override
    public void turnWestGreen() {
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());
        results.storeNewResult("West is turned to green.");
    }

    @Override
    public void turnAllRed() {
        results.storeNewResult("All lights are already red.");
    }
}
