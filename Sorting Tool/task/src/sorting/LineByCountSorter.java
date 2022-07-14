package sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LineByCountSorter extends ByCountSorter {
    private static List<String> lines;
    private static Map<String, Integer> linesMap;
    private static Map<String, Integer> sortedLinesMap;
    DataType dataType;


    public LineByCountSorter(String fileName) throws FileNotFoundException {
        super(fileName);
        this.dataType = DataType.LINE;
        this.linesMap = new TreeMap<String, Integer>();
        this.lines = new ArrayList<String>();
    }

    private static String printMap() {
        StringBuilder sb = new StringBuilder();


        for (Map.Entry<String, Integer> entry : sortedLinesMap.entrySet()
        ) {
            double persentage = entry.getValue() * 100 / (lines.size() * 1.0);
            String line = String.format("%s: %d times(s), %.0f%%\n", entry.getKey(), +entry.getValue(), persentage);
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public void read() {
        if (ArgsParser.inputFileName == null) {
            while (scanner.hasNextLine()) {
                count++;
                lines.add(scanner.nextLine());
            }


            for (String key : lines
            ) {
                int value = Collections.frequency(lines, key);
                linesMap.put(key, value);
            }
        } else {
            while (scannerFile.hasNextLine()) {
                count++;
                lines.add(scannerFile.nextLine());
            }


            for (String key : lines
            ) {
                int value = Collections.frequency(lines, key);
                linesMap.put(key, value);
            }
        }


    }

    @Override
    public void sort() {

        sortedLinesMap = linesMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }


    @Override
    public String toString() {
        String returnString = "Total lines: " + count + ".\n" +
                printMap();


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
