package sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LongByCountSorter extends ByCountSorter {
    private static List<Long> numbers;
    private static Map<Long, Integer> longsMap;
    DataType dataType;


    public LongByCountSorter(String fileName) throws FileNotFoundException {
        super(fileName);
        this.dataType = DataType.LONG;
        this.longsMap = new TreeMap<>();
        this.numbers = new ArrayList<Long>();
    }

    private static String printMap() {
        StringBuilder sb = new StringBuilder();

        Map<Long, Integer> sortedMap = longsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<Long, Integer> entry : sortedMap.entrySet()
        ) {
            double persentage = entry.getValue() * 100 / (numbers.size() * 1.0);
            String line = String.format("%d: %d times(s), %.0f%%\n", entry.getKey(), +entry.getValue(), persentage);
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public void read() {
        if (ArgsParser.inputFileName == null) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                try {
                    long nextLong = Long.parseLong(next);
                    count++;
                    numbers.add(nextLong);
                } catch (NumberFormatException nfe) {
                    System.out.printf("%s is not a long. It will be skipped.\n", next);
                }

            }

            for (Long key : numbers
            ) {
                int value = Collections.frequency(numbers, key);
                longsMap.put(key, value);
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
            for (Long key : numbers
            ) {
                int value = Collections.frequency(numbers, key);
                longsMap.put(key, value);
            }
        }


    }

    @Override
    public void sort() {
        super.sort();
    }

    @Override
    public String toString() {
        String returnString = "Total numbers: " + count + ".\n" +
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
