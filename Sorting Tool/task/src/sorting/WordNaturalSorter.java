package sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordNaturalSorter extends NaturalSorter {
    private String longestWord;
    private int longestWordCount;
    private double percentage;
    private static List<String> words;

    public WordNaturalSorter(String fileName) throws FileNotFoundException {
        super(fileName);
        longestWordCount = 0;
        longestWord = "";
        words = new ArrayList<>();
    }

    @Override
    public void read() {
        if (ArgsParser.inputFileName == null) {
            while (scanner.hasNext()) {
                count++;
                words.add(scanner.next());
            }
        }else {
            while (scannerFile.hasNext()) {
                count++;
                words.add(scannerFile.next());
            }
        }

    }

    @Override
    public void sort() {
        Collections.sort(words);
    }

    public static String arrayToString() {
        String s = words.stream()
                .collect(Collectors.joining(" "));

        return s;
    }



    @Override
    public String toString() {
        String returnString = "Total words: " + count + ".\n"
                + "Sorted data: " + arrayToString();


        if (ArgsParser.outputFileName == null) {
            return returnString;

        } else {

            try {
                FileUtils.writeToFile(returnString);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "";
    }
}