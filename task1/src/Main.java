import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter inputNames =  WordsGenerator.generateTextWithRandomNames();
        assert inputNames != null;
        inputNames.close();

        String inputFileName = WordsGenerator.nameInput;

    }
}
