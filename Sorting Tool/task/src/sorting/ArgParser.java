package sorting;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

class ArgsParser {
    static DataType dataType =DataType.LINE;
    static Sorter sorter;
    static String inputFileName;
    static String outputFileName;

    public static Sorter parseArgs(String[] args) throws FileNotFoundException {
        Set<String> allComandsAndArgs = new HashSet<>(Set.of("-dataType", "-sortingType",
                "long", "line", "word",
                "natural", "byCount",
                "-inputFile","input.txt",
                "-outputFile","output.txt"));

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-") & allComandsAndArgs.add(args[i])) {
                System.out.printf("%s is not a valid parameter. It will be skipped.\n", args[i]);
            }
        }


        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-inputFile")) {
               inputFileName = args[i + 1];
            }
        }


        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-outputFile")) {
                outputFileName = args[i + 1];
            }
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                try {
                    parseDataType(args[i + 1]);
                } catch (ArrayIndexOutOfBoundsException aiobe) {
                    System.out.println("No data type defined!");
                    System.exit(0);
                }

            }
        }


        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {

                try {
                    parseSortingType(args[i + 1]);
                } catch (ArrayIndexOutOfBoundsException aiobe) {
                    System.out.println("No sorting type defined!");
                    System.exit(0);
                }

            }
        }

        if (sorter == null) {
            sorter = new NaturalSorter(inputFileName);
        }


        if ((dataType == DataType.LONG & (sorter instanceof NaturalSorter))) {
            return new LongNaturalSorter(inputFileName);
        }
        if ((dataType == DataType.LINE & (sorter instanceof NaturalSorter))) {
            return new LineNaturalSorter(inputFileName);
        }
        if ((dataType == DataType.WORD & (sorter instanceof NaturalSorter))) {
            return new WordNaturalSorter(inputFileName);
        }
        if ((dataType == DataType.LONG & (sorter instanceof ByCountSorter))) {
            return new LongByCountSorter(inputFileName);
        }
        if ((dataType == DataType.WORD & (sorter instanceof ByCountSorter))) {
            return new WordByCountSorter(inputFileName);
        }
        if ((dataType == DataType.LINE & (sorter instanceof ByCountSorter))) {
            return new LineByCountSorter(inputFileName);
        }
        return null;
    }


    public static Sorter parseSortingType(String type) throws FileNotFoundException {
        switch (type) {
            case "natural":
                sorter = new NaturalSorter(inputFileName);
                break;
            case "byCount":
                sorter = new ByCountSorter(inputFileName);
                break;
        }
        return null;
    }

    public static void parseDataType(String arg) {
        switch (arg) {
            case "long":
                dataType = DataType.LONG;
                break;
            case "word":
                dataType = DataType.WORD;
                break;
            case "line":
                dataType = DataType.LINE;
                break;
            default:
                dataType = DataType.LINE;
        }
    }
}
