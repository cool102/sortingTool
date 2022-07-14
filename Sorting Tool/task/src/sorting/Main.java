package sorting;


import java.io.FileNotFoundException;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        Sorter sorter = ArgsParser.parseArgs(args);
        sorter.read();
        sorter.sort();
        System.out.println(sorter);
    }
}