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

    boolean addvehiclesToNorth(int numvehicles);

    boolean addvehiclesToSouth(int numvehicles);

    boolean addvehiclesToEast(int numvehicles);

    boolean addvehiclesToWest(int numvehicles);

    void passvehicles();

    void turnNorthRed();

    void turnNorthGreen();

    void turnSouthRed();

    void turnSouthGreen();

    void turnEastRed();

    void turnEastGreen();

    void turnWestRed();

    void turnWestGreen();
    
    void turnAllRed();
}
