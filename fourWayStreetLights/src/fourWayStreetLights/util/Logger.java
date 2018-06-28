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

    /**
     * enums for debug level
     *
     */
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

     /**
     * set the debug level to appropriate debug level enum
     *
     * return void
     * 
     * @param levelIn (int)
     */
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

     /**
     * set debug level
     *
     * @param  levelIn (DebugLevel)
     * return void
     */
    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

     /**
     * write a debug message on std out if same debug level is passed as it set earlier.
     *
     * @param  (message, levelin)
     * return void
     */
    public static void writeMessage(String message,
            DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.println(message);
        }
    }

    
     /**
     * overrides toStrig() method to return current debug level set.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }
}
