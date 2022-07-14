package sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LineNaturalSorter extends NaturalSorter {
    private static List<String> lines;
    private String longestLine;
    private int longestLineCount;
    private double percentage;

    public LineNaturalSorter(String fileName) throws FileNotFoundException {
        super(fileName);
        longestLineCount = 0;
        longestLine = "";
        lines = new ArrayList<>();
    }

    public static String arrayToString() {
        String s = lines.stream()
                .collect(Collectors.joining("\n"));

        return s;
    }

    @Override
    public void read() {
        if (ArgsParser.inputFileName == null) {
            while (scanner.hasNextLine()) {
                count++;
                lines.add(scanner.nextLine());
            }
        }else  {
            while (scannerFile.hasNextLine()) {
                count++;
                lines.add(scannerFile.nextLine());
            }
        }

    }

    @Override
    public void sort() {
        Collections.sort(lines);
    }


    @Override
    public String toString() {
        String returnString = "Total lines: " + count + "\n" +
                "Sorted data:\n" + arrayToString();


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