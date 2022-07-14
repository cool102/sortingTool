package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    static void writeToFile(String returnString) throws IOException {
        File file = new File("D:\\devel\\Sorting Tool\\Sorting Tool\\task\\src\\sorting\\out.txt");// + ArgsParser.outputFileName
        FileWriter writer = new FileWriter(file); // overwrites the file
        writer.write(returnString);

    }
}
