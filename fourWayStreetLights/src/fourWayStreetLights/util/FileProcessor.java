/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author amitk
 */
public class FileProcessor {

    private File inputFile = null;
    private BufferedReader bfrRdr = null;

    public FileProcessor(String inputFileName) {
        inputFile = new File(inputFileName);
    }

    /**
     * open the input File
     *
     * @throws FileNotFoundException return void
     */
    public void openFile() throws FileNotFoundException {
        Logger.writeMessage("Opening a file in openFile method in FileProcessor", Logger.DebugLevel.FILE_PROCESSOR);
        bfrRdr = new BufferedReader(new FileReader(inputFile));
        Logger.writeMessage("file has been opened Successfully", Logger.DebugLevel.FILE_PROCESSOR);
    }

    /**
     * close the input File
     *
     * @throws IOException return void
     */
    public void closeFile() throws IOException {
        Logger.writeMessage("Clossing a file in closeFile method in FileProcessor", Logger.DebugLevel.FILE_PROCESSOR);
        if (bfrRdr != null) {
            bfrRdr.close();
            bfrRdr = null;
            Logger.writeMessage("File has been clossed successfully", Logger.DebugLevel.FILE_PROCESSOR);
        } else {
            Logger.writeMessage("There is no open file", Logger.DebugLevel.FILE_PROCESSOR);
        }
    }

    /**
     * read and return line from input file
     *
     * @throws FileNotFoundException return void
     */
    public String readLine() throws IOException {
        Logger.writeMessage("entering readLine method in FileProcessor", Logger.DebugLevel.FILE_PROCESSOR);
        String line = "";
        line = bfrRdr.readLine();
        Logger.writeMessage("returning read line from read line method in fileProcessor", Logger.DebugLevel.FILE_PROCESSOR);
        return line;
    }
}
