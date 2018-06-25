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
public class FileProcessor {
    private File inputFile = null;
    private BufferedReader bfrRdr = null;

    public FileProcessor(String inputFileName) {
        inputFile = new File(inputFileName);
    }

    /**
     * open the input File
     *
     * @throws FileNotFoundException
     * return void
     */
    public void openFile() throws FileNotFoundException {
        bfrRdr = new BufferedReader(new FileReader(inputFile));
    }

    /**
     * close the input File
     *
     * @throws IOException
     * return void
     */
    public void closeFile() throws IOException {

        if (bfrRdr != null) {
            bfrRdr.close();
        }

    }

    /**
     * read and return line from input file
     *
     * @throws FileNotFoundException
     * return void
     */
    public String readLine() throws IOException {
        String line = "";
        line = bfrRdr.readLine();
        return line;
    }
}
