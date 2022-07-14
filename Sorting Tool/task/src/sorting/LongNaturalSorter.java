package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongNaturalSorter extends NaturalSorter {
    private static List<Long> numbers;
    DataType dataType;

    public LongNaturalSorter(String fileName) throws FileNotFoundException {
        super(fileName);
        dataType = DataType.LONG;
        numbers = new ArrayList<>();

    }

    public static String arrayToString() {
        String s = numbers.stream()
                .map(String::valueOf).collect(Collectors.joining(" "));

        return s;
    }

    @Override
    public void read() {
        if (ArgsParser.inputFileName == null) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                try {
                    long nextLong = Long.parseLong(next);
                    numbers.add(nextLong);
                    count++;
                } catch (NumberFormatException nfe) {
                    System.out.printf("%s is not a long. It will be skipped.\n", next);
                }

            }
        } else {
            while (scannerFile.hasNext()) {
                String next = scannerFile.next();
                try {
                    long nextLong = Long.parseLong(next);
                    numbers.add(nextLong);
                    count++;
                } catch (NumberFormatException nfe) {
                    System.out.printf("%s is not a long. It will be skipped.\n", next);
                }

            }
        }

    }

    @Override
    public void sort() {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        String returnString = "Total numbers: " + count + ".\n" +

                "Sorted data: " + arrayToString();


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

