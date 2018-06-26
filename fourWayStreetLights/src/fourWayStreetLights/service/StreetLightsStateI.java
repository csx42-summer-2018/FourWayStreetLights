/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.service;

/**
 *
 * @author amitk
 */
public interface StreetLightsStateI {
    void addCars(int numCars);
    void leaveCars(int numCars);
    void turnRed();
    void turnGreen();
}
