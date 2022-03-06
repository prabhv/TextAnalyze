import java.io.FileWriter;
import java.io.IOException;

//class to handle writing the results to a text file Results.txt
public class WriteToFile {

    FileWriter writer;

    public WriteToFile(String[] result1, String[] result2, String filePath) throws IOException {
        writer = new FileWriter(filePath, true);
        append(result1);
        append(result2);
        writer.close();
    }

    private void append(String[] result) throws IOException {
        for(String str: result) {
            writer.write(str + System.lineSeparator());
        }
    }
}
