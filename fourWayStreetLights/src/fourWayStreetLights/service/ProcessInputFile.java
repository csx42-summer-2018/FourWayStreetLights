/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.service;

import fourWayStreetLights.service.StreetLightsContext.Directions;
import fourWayStreetLights.service.StreetLightsContext.TrafficLightColors;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Logger;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author amitk
 */
public class ProcessInputFile {

    private FileProcessor fp;
    private StreetLightsContext streetLightsContext;

    public ProcessInputFile(FileProcessor fpParam, StreetLightsContext streetLightsContextParam) {
        this.fp = fpParam;
        this.streetLightsContext = streetLightsContextParam;
    }

    public void processInput() throws IOException {
        Logger.writeMessage("Entering a processInput() method of ProcessInputFile Class", Logger.DebugLevel.PROCESS_INPUT_FILE);

        fp.openFile();
        String line = "";
        while ((line = fp.readLine()) != null) {
            line = line.toUpperCase();
            Directions direction = null;
            // check for direction
            if (line.contains("NORTH")) {
                direction = Directions.NORTH;
            } else if (line.contains("SOUTH")) {
                direction = Directions.SOUTH;
            } else if (line.contains("EAST")) {
                direction = Directions.EAST;
            } else if (line.contains("WEST")) {
                direction = Directions.WEST;
            } else if (line.contains("ALL")) {
                direction = Directions.ALL;
            }
            if (line.contains("TURN")) {
                TrafficLightColors tfColor = null;
                // check for Color
                if (line.contains("GREEN")) {
                    tfColor = TrafficLightColors.GREEN;
                } else if (line.contains("RED")) {
                    tfColor = TrafficLightColors.RED;
                }
                if (direction != null && tfColor != null) {
                    streetLightsContext.turnLight(direction, tfColor);
                } else {
                    System.err.println("Input format is not correct");
                    System.exit(0);
                }
            } else if (line.contains("ADD")) {
                int numvehicles = 0;
                try {
                    numvehicles = Integer.parseInt(line.split(" ")[1]);
                } catch (NumberFormatException ex) {
                    System.err.println("Input format is not correct: " + ex.toString() + Arrays.toString(ex.getStackTrace()));
                    System.exit(0);
                }
                if (direction != null) {
                    streetLightsContext.addvehicles(direction, numvehicles);
                } else {
                    System.err.println("Input format is not correct");
                    System.exit(0);
                }
            }
        }
        Logger.writeMessage("Leaving a processInput() method of ProcessInputFile Class", Logger.DebugLevel.PROCESS_INPUT_FILE);
    }

    @Override
    public String toString() {
        return "Name of the file to process is " + fp.toString();
    }
}
