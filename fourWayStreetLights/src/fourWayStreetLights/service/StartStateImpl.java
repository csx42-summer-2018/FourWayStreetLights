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
    public boolean addCarsToNorth(int numCars) {
        numCars += streetLightsContext.getNumCarsNorth();
        streetLightsContext.setNumCarsNorth(numCars);
        results.storeNewResult(numCars + " car(s) added on north.");
        return false;
    }

    @Override
    public boolean addCarsToSouth(int numCars) {
        numCars += streetLightsContext.getNumCarsSouth();
        streetLightsContext.setNumCarsSouth(numCars);
        results.storeNewResult(numCars + " car(s) added on south.");
        return false;
    }

    @Override
    public boolean addCarsToEast(int numCars) {
        numCars += streetLightsContext.getNumCarsEast();
        streetLightsContext.setNumCarsEast(numCars);
        results.storeNewResult(numCars + " car(s) added on east.");
        return false;
    }

    @Override
    public boolean addCarsToWest(int numCars) {
        numCars += streetLightsContext.getNumCarsWest();
        streetLightsContext.setNumCarsWest(numCars);
        results.storeNewResult(numCars + " car(s) added on west.");
        return false;
    }

    @Override
    public void passCars() {
        results.storeNewResult("No car pass as all lights are red");
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
