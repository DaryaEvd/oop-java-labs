package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyWriter {
    private static final Logger logger = Logger.getLogger(MyWriter.class.getName());

    private final String fileName;

    public MyWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(String text) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            writer.write(text);
            logger.log(Level.INFO, "Text wrote");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Can't open file");
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
