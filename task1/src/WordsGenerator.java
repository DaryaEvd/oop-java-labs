import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsGenerator {
    static final int amountNamesInFile = 100;
    static final int wordsPerLine = 20;

    // TODO: загкадка дыры: если объявить inputStr как final static, то все пойдет нафиг... (в вычисления)
//    final static String inputStr = "/home/dasha/IdeaProjects/task1/src/random_names.txt";
    public static void generateTextWithRandomNames() throws IOException {

        /* //TODO: ask how to create file in curr dir (idk why "user.dir" doesn't work correctly
             // and check whether file  exists

        String currDir = System.getProperty("user.dir");
        System.out.println(currDir);
        String nameOfFileRandNames = currDir + "/randomizer_names.txt";
        System.out.println(nameOfFileRandNames);
        File fileRandom = new File(nameOfFileRandNames);
        if(fileRandom.exists()) {
            System.out.println("file exists");
        }
        */

        final String pathOfCreatingNewFileRandomNames = "/home/dasha/IdeaProjects/task1/src/random_names.txt";
        File fileWithRandNames =  new File(pathOfCreatingNewFileRandomNames);
        if(!Files.exists(Paths.get(pathOfCreatingNewFileRandomNames))) {
            boolean isCreated = fileWithRandNames.createNewFile(); //TODO: ask how to create without boolean
//            System.out.println("i create a file");
        }

        String inputStr = "/home/dasha/IdeaProjects/task1/src/list_of_names.txt";

        String [] namesListFromInput = WordsGenerator.convertInputNamesToListNames(inputStr);

        try (FileWriter fileWriter = new FileWriter(fileWithRandNames)) {
            for (int i = 0; i < amountNamesInFile; i++) {
                int index = new Random().nextInt(namesListFromInput.length);
                String randomName = namesListFromInput[index];
                fileWriter.write(randomName);
                fileWriter.write(" ");

                if(i != 0 && i % wordsPerLine == 0) {
                    fileWriter.write("\n");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
