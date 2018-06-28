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

    public WestGreenState(StreetLightsContext streetLightsContextParam, Results resultsParam) {
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
        return true;
    }

    @Override
    public void passCars() {
        int numCars = streetLightsContext.getNumCarsWest();
        if (numCars > 1) {
            numCars = numCars - 2;
            streetLightsContext.setNumCarsWest(numCars);
            results.storeNewResult("2 cars passed from west.");
            streetLightsContext.SetState(streetLightsContext.getNorthGreenState());
            results.storeNewResult("West is truned to red and North is turned to green.");
        } else if (numCars == 1) {
            numCars = numCars - 1;
            streetLightsContext.setNumCarsWest(numCars);
            results.storeNewResult("1 car passed from west.");
        } else {
            results.storeNewResult("There is no car to be pass from west.");
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
