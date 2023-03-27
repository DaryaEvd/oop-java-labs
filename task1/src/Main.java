import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
//        String inputStr = "/home/dasha/IdeaProjects/task1/src/names.txt";
//        String[] getNames = WordsGenerator.convertInputNamesToListNames(inputStr);
//        System.out.println(Arrays.toString(getNames));

//        String words = "Hi:Bye:Hello:Cheese:Puppies";
//        String[] wordsAsArray = words.split(":");
//        System.out.println(Arrays.toString(wordsAsArray));
//
//        int index = new Random().nextInt(wordsAsArray.length);
//
//        String randomWord = wordsAsArray[index];
//        System.out.println("Random word: '" + randomWord + "'. It is of length: " + randomWord.length());

        WordsGenerator.generateTextWithRandomNames();
    }
}