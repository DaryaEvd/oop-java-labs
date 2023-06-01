package Utils;

import java.io.FileWriter;
import java.io.IOException;

public class MyWriter {

    private final String fileName;

    public MyWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(String text) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
