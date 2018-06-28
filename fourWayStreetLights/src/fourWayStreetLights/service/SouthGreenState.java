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
public class SouthGreenState implements StreetLightsStateI {

    private StreetLightsContext streetLightsContext;
    private Results results;

    public SouthGreenState(StreetLightsContext streetLightsContextParam, Results resultsParam) {
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
        return true;
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
        int numCars = streetLightsContext.getNumCarsSouth();
        if (numCars > 1) {
            numCars = numCars - 2;
            streetLightsContext.setNumCarsSouth(numCars);
            results.storeNewResult("2 cars passed from south.");
            streetLightsContext.SetState(streetLightsContext.getWestGreenState());
            results.storeNewResult("South is truned to red and West is turned to green.");
        } else if (numCars == 1) {
            numCars = numCars - 1;
            streetLightsContext.setNumCarsSouth(numCars);
            results.storeNewResult("1 car passed from south.");
        } else {
            results.storeNewResult("There is no car to be pass from south.");
        }
    }

    @Override
    public void turnNorthRed() {
        results.storeNewResult("North is already red.");

    }

    @Override
    public void turnNorthGreen() {
        streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
        results.storeNewResult("North is turned to green and South is turned to red.");

    }

    @Override
    public void turnSouthRed() {
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());
        results.storeNewResult("South is turned to red and West is turned to green.");
    }

    @Override
    public void turnSouthGreen() {
        results.storeNewResult("South is already green.");
    }

    @Override
    public void turnEastRed() {
        results.storeNewResult("East is already red.");
    }

    @Override
    public void turnEastGreen() {
        streetLightsContext.SetState(streetLightsContext.getEastGreenState());
        results.storeNewResult("East is turned to green and South is turned to red.");
    }

    @Override
    public void turnWestRed() {
        results.storeNewResult("West is already red.");
    }

    @Override
    public void turnWestGreen() {
        streetLightsContext.SetState(streetLightsContext.getWestGreenState());
        results.storeNewResult("West is turned to green and South is turned to red.");
    }

    @Override
    public void turnAllRed() {
        streetLightsContext.SetState(streetLightsContext.getStartStateImpl());
        results.storeNewResult("All lights turned red.");
    }
}
