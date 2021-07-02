package encryptdecrypt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyWriter {
    private final String filePath;

    public MyWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write (String data) {
        try {
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(filePath));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Writer issue: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
