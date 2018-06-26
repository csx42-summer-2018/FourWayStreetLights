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
       NONE, CONSTRUCTOR, FILE_PROCESSOR, CONTEXT , RESULTS
    };

    private static DebugLevel debugLevel;

    // FIXME: Add switch cases for all the levels
    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 4:
                debugLevel = DebugLevel.RESULTS;
                break;
            case 3:
                debugLevel = DebugLevel.CONTEXT;
                break;
            case 2:
                debugLevel = DebugLevel.CONSTRUCTOR;
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
