package sorting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordByCountSorter extends ByCountSorter {
    private static List<String> words;
    private static Map<String, Integer> wordsMap;
    private static Map<String, Integer> sortedWordsMap;
    DataType dataType;


    public WordByCountSorter(String fileName) throws FileNotFoundException {
        super(fileName);
        this.dataType = DataType.WORD;
        this.wordsMap = new TreeMap<>();
        this.words = new ArrayList<String>();
    }

    private static String printMap() {
        StringBuilder sb = new StringBuilder();


        for (Map.Entry<String, Integer> entry : sortedWordsMap.entrySet()
        ) {
            double persentage = entry.getValue() * 100 / (words.size() * 1.0);
            String line = String.format("%s: %d times(s), %.0f%%\n", entry.getKey(), +entry.getValue(), persentage);
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public void read() {
        if (ArgsParser.inputFileName == null) {
            while (scanner.hasNext()) {
                count++;
                words.add(scanner.next());
            }


            for (String key : words
            ) {
                int value = Collections.frequency(words, key);
                wordsMap.put(key, value);
            }
        }else {
            while (scannerFile.hasNext()) {
                count++;
                words.add(scannerFile.next());
            }


            for (String key: words
            ) {
                int value = Collections.frequency(words, key);
                wordsMap.put(key,value);
            }
        }


    }

    @Override
    public void sort() {

        sortedWordsMap = wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }


    @Override
    public String toString() {
        String returnString = "Total words: " + count + ".\n" +
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
