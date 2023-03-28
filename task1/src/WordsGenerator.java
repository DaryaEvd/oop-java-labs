import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsGenerator {

    static String nameInput;

    public static FileWriter generateTextWithRandomNames() throws IOException {
        String pathOfCreatingNewFileRandomNames = "/home/dasha/IdeaProjects/task1/src/random_names.txt";
        File fileWithRandNames = new File(pathOfCreatingNewFileRandomNames);
        boolean resultOfCreating;
        try {
            resultOfCreating = fileWithRandNames.createNewFile();
            if(!resultOfCreating) {
//                System.out.println("File already exists at location: " + fileWithRandNames.getCanonicalPath());
                //TODO: System.err.print, exit ?
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String inputStr = "/home/dasha/IdeaProjects/task1/src/input_list_names.txt";
        Path inputPath = Paths.get(inputStr);
        Path nameFile = inputPath.getFileName();
        nameInput = nameFile.toString();

        String [] namesListFromInput = WordsGenerator.convertInputNamesToListNames(inputStr);

        int amountNamesInFile = 20;

        try (FileWriter fileWriter = new FileWriter(fileWithRandNames)) {
            for (int i = 0; i < amountNamesInFile; i++) {
                int index = new Random().nextInt(namesListFromInput.length);
                String randomName = namesListFromInput[index];
                fileWriter.write(randomName);
                fileWriter.write(" ");

                if(i != 0 && i % 20 == 0) {
                    fileWriter.write("\n");
                }
            }
            return fileWriter;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] convertInputNamesToListNames(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listOfNames = new ArrayList<>();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            listOfNames.add(currentLine);
        }
        bufferedReader.close();
        return listOfNames.toArray(new String[0]);
    }
}
