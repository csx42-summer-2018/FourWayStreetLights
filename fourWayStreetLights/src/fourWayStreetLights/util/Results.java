/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author amitk
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String outFileNamePrivate;
    private StringBuilder sb;

    public Results(String outFileName) {
        outFileNamePrivate = outFileName;
        sb = new StringBuilder();
    }

    /**
     * append new Result in string container
     *
     * return void
     */
    public void storeNewResult(String newResult) {
        Logger.writeMessage("Entering a storeNewResult() method of Results Class", Logger.DebugLevel.RESULTS);

        sb.append(newResult).append("\n");

        Logger.writeMessage("Leaving a storeNewResult() method of Results Class", Logger.DebugLevel.RESULTS);
    }

    /**
     * calls the function to print result from container to file and output
     * display
     *
     * return void
     */
    public void printResult() {
        Logger.writeMessage("Entering a printResult() method of Results Class", Logger.DebugLevel.RESULTS);

        writeToFile(sb.toString());
        writeToStdout(sb.toString());

        Logger.writeMessage("Leaving a printResult() method of Results Class", Logger.DebugLevel.RESULTS);
    }

    /**
     * write the content stored in Result to output file
     *
     * return void
     *
     * @param s
     */
    @Override
    public void writeToFile(String s) {
        Logger.writeMessage("Entering a writeToFile() method of Results Class", Logger.DebugLevel.RESULTS);

        PrintWriter pW = null;
        try {
            pW = new PrintWriter(outFileNamePrivate);
            pW.write(sb.toString());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString() + Arrays.toString(ex.getStackTrace()));
        } finally {
            if (pW != null) {
                pW.close();
            }
        }

        Logger.writeMessage("Leaving a writeToFile() method of Results Class", Logger.DebugLevel.RESULTS);
    }

    /**
     * display the content stored in Result on output screen
     *
     * return void
     *
     * @param s
     */
    @Override
    public void writeToStdout(String s) {
        Logger.writeMessage("Entering a writeToStdout() method of Results Class", Logger.DebugLevel.RESULTS);
        System.out.println(sb.toString());

        Logger.writeMessage("Leaving a writeToStdout() method of Results Class", Logger.DebugLevel.RESULTS);
    }

    @Override
    public String toString() {

        return "Length of string saved in result file is " + sb.length();
    }
}
