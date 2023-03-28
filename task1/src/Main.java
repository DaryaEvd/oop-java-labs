import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        WordsGenerator.generateTextWithRandomNames();

        int globalAmountOfNames = 0;

        CSVFile csvFile = new CSVFile();

        try {
            BufferedReader bufferedReader = new BufferedReader(csvFile.input);
            String currString;
            String[] arrayOfAllStrings;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayOfAllStrings = currString.split(" ");
                for (String currLine : arrayOfAllStrings) {
                    int countFreq = csvFile.storeNamesAndAmount.getOrDefault(currLine, 0);
                    csvFile.storeNamesAndAmount.put(currLine, countFreq + 1);
                    globalAmountOfNames++;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            System.err.println("Error " + e.getMessage());
        }

        CSVFile.sortFreq(csvFile);

        String pathOfResultFile = "/home/dasha/IdeaProjects/task1/src/result.csv";
        File resFile = new File(pathOfResultFile);

        try (FileWriter fileWriter = new FileWriter(resFile)) {
            fileWriter.write("Word, ");
            fileWriter.write("Frequency, ");
            fileWriter.write("ProcFrequency\n");

            for (String name: csvFile.sortNamesByFrequency.keySet()) {
                double proc = (double)csvFile.sortNamesByFrequency.get(name) / globalAmountOfNames;

                String value = csvFile.sortNamesByFrequency.get(name).toString();
                fileWriter.write(name + ", " + value + ", " + proc + "\n");
            }
        }


//            csvFile.output.write("Word, ");
//            csvFile.output.write("Frequency, ");
//            csvFile.output.write("ProcFrequency\n");
//
//            for (String name: csvFile.sortNamesByFrequency.keySet()) {
//                double proc = (double)csvFile.sortNamesByFrequency.get(name) / globalAmountOfNames;
//
//                String value = csvFile.sortNamesByFrequency.get(name).toString();
//                csvFile.output.write(name + ", " + value + ", " + proc + "\n");
//            }

    }
}