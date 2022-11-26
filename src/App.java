import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;

public class App {

    private static int numberOfLines;
    public static void main(String[] args) throws Exception {
        File f = new File("words.txt");
        try {
            FileReader fr = new FileReader(f);
            try (LineNumberReader lnr = new LineNumberReader(fr)) {
                lnr.skip(Long.MAX_VALUE);
                numberOfLines = (lnr.getLineNumber() + 1);
            }
            System.out.println("Outputted number of lines to output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File("src/output.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Number of lines: " + numberOfLines);
        fileWriter.close();
    }
}