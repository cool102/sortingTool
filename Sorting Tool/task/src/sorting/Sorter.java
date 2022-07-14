package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Sorter {
    int count;
    Scanner scanner ;
    Scanner scannerFile ;

    public Sorter(String inputFileName) throws FileNotFoundException {
        File file = new File("D:\\devel\\Sorting Tool\\Sorting Tool\\task\\src\\sorting\\"+inputFileName);
        this.count=0;
        scanner = new Scanner(System.in);
        if (Objects.nonNull(inputFileName)) {
            scannerFile = new Scanner(file);
        }

    }

    public abstract void read();
    public abstract void sort();
   // public abstract void print();


}
