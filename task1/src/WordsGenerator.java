import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsGenerator {
    private static final String INPUT_STR = "/home/dasha/IdeaProjects/task1/src/list_of_names.txt";
    private static final String PATH_OF_CREATING_NEW_FILE_RANDOM_NAMES =
            "/home/dasha/IdeaProjects/task1/src/random_names.txt";

    static final int AMOUNT_NAMES_IN_FILE = 1000;
    static final int WORDS_PER_LINE = 20;

    public static void generateTextWithRandomNames() throws IOException {

        File fileWithRandNames = new File(PATH_OF_CREATING_NEW_FILE_RANDOM_NAMES);

        if (!Files.exists(Paths.get(PATH_OF_CREATING_NEW_FILE_RANDOM_NAMES))) {
            fileWithRandNames.createNewFile();
        }

        String[] namesListFromInput = WordsGenerator.convertInputNamesToListNames(INPUT_STR);

        try (FileWriter fileWriter = new FileWriter(fileWithRandNames)) {
            for (int i = 0; i < AMOUNT_NAMES_IN_FILE; i++) {
                int index = new Random().nextInt(namesListFromInput.length);
                String randomName = namesListFromInput[index];
                fileWriter.write(randomName);
                fileWriter.write(" ");

                if (i != 0 && i % WORDS_PER_LINE == 0) {
                    fileWriter.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] convertInputNamesToListNames(String filename) throws IOException {
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            List<String> listOfNames = new ArrayList<>();
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                listOfNames.add(currentLine);
            }
            return listOfNames.toArray(new String[0]);
        }
    }
}
