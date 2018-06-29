/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourWayStreetLights.driver;

import fourWayStreetLights.service.ProcessInputFile;
import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author amitk
 */
public class Driver {

    public static void main(String[] args) {
       
        String inputFileName = "";
        String outFileName = "";
        int debugLevelIn = 0;
        
        FileProcessor fp = null;

        try {
            if (args == null || args.length != 3 || args[0] == null ||args[1] == null || args[2] == null || args[0].equals("${arg0}") ||args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
                System.err.println("Please provide three args for input.txt, output.txt file and debugging level respectively");
                System.exit(0);
            }

            inputFileName = args[0];
            outFileName = args[1];
           
            File inputfile = new File(inputFileName);
            if (!inputfile.isFile()) {
                System.err.println("Input file doesnot exit in specified path");
                System.exit(0);
            }
            if (!inputfile.getName().endsWith(".txt")) {
                System.err.println("(.txt) formats are only supported for input file");
                System.exit(0);
            }
            File outputfile = new File(outFileName);

            if (!outputfile.getName().endsWith(".txt")) {
                System.err.println("(.txt) formats are only supported for output file");
                System.exit(0);
            }
 	    debugLevelIn = Integer.parseInt(args[2]);
            Logger.setDebugValue(debugLevelIn);
            fp = new FileProcessor(inputFileName);

            Results results = new Results(outFileName);
            StreetLightsContext streetLightsContext = new StreetLightsContext(results);
            ProcessInputFile processInputFile = new ProcessInputFile(fp, streetLightsContext);
            processInputFile.processInput();
            results.printResult();
        } catch (Exception ex) {
            System.err.println(ex.toString() + Arrays.toString(ex.getStackTrace()));
            System.exit(0);
        } finally {
            if (fp != null) {
                try {
                    fp.closeFile();
                } catch (IOException ex) {
                    System.err.println(ex.toString() + Arrays.toString(ex.getStackTrace()));
                    System.exit(0);
                } finally {
                }
            }
        }
    }
}
