import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsGenerator {

    public static void generateTextWithRandomNames() throws IOException {
        String pathOfFileRandomNames = "/home/dasha/IdeaProjects/task1/src/random_names.txt";
        File fileWithRandNames = new File(pathOfFileRandomNames);
        boolean resultOfCreating;
        try {
            resultOfCreating = fileWithRandNames.createNewFile();
            if(!resultOfCreating) {
                System.out.println("File already exist at location: " + fileWithRandNames.getCanonicalPath());
                //TODO: System.err.print, exit ?
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String inputStr = "/home/dasha/IdeaProjects/task1/src/names.txt";
        String [] namesListFromInput = WordsGenerator.convertInputNamesToListNames(inputStr);

        int index = new Random().nextInt(namesListFromInput.length);

        String randomName = namesListFromInput[index];

        try {
            FileWriter fileWriter = new FileWriter(fileWithRandNames);
            fileWriter.write(randomName);
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] convertInputNamesToListNames(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listOfNames = new ArrayList<String>();
        String currentLine = null;
        while ((currentLine = bufferedReader.readLine()) != null) {
            listOfNames.add(currentLine);
        }
        bufferedReader.close();
//        for (String listOfName : listOfNames) {
//            System.out.println(listOfName);
//        }
        return listOfNames.toArray(new String[0]);
    }
}
