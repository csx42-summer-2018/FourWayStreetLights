/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.util;

/**
 *
 * @author amitk
 */
public class Logger {

    // FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel {
        NONE,
        FILE_PROCESSOR,
        PROCESS_INPUT_FILE,
        STREET_LIGHTS_CONTEXT,
        START_STATE_IMPL,
        NORTH_GREEN_STATE,
        SOUTH_GREEN_STATE,
        EAST_GREEN_STATE,
        WEST_GREEN_STATE,
        RESULTS
    };

    private static DebugLevel debugLevel;

    // FIXME: Add switch cases for all the levels
    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 10:
                debugLevel = DebugLevel.RESULTS;
                break;
            case 9:
                debugLevel = DebugLevel.WEST_GREEN_STATE;
                break;
            case 8:
                debugLevel = DebugLevel.EAST_GREEN_STATE;
                break;
            case 7:
                debugLevel = DebugLevel.SOUTH_GREEN_STATE;
                break;
            case 6:
                debugLevel = DebugLevel.NORTH_GREEN_STATE;
                break;
            case 5:
                debugLevel = DebugLevel.START_STATE_IMPL;
                break;
            case 4:
                debugLevel = DebugLevel.STREET_LIGHTS_CONTEXT;
                break;
            case 3:
                debugLevel = DebugLevel.STREET_LIGHTS_CONTEXT;
                break;
            case 2:
                debugLevel = DebugLevel.PROCESS_INPUT_FILE;
                break;
            case 1:
                debugLevel = DebugLevel.FILE_PROCESSOR;
                break;
            default:
                debugLevel = DebugLevel.NONE;
                break;
        }
    }

    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage(String message,
            DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.println(message);
        }
    }

    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }
}
