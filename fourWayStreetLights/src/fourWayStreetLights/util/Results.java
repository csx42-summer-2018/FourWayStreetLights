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
        sb.append(newResult).append("\n");
    }

    /**
     * calls the function to print result from container to file and output
     * display
     *
     * return void
     */
    public void printResult() {
        writeToFile(sb.toString());
        writeToStdout(sb.toString());
    }

    /**
     * write the content stored in Result to output file
     *
     * return void
     * @param s
     */
    @Override
    public void writeToFile(String s) {
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
    }

    /**
     * display the content stored in Result on output screen
     *
     * return void
     * @param s
     */
    @Override
    public void writeToStdout(String s) {
        System.out.println(sb.toString());
    }
}
