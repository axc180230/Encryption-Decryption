package encryptdecrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyReader {
    private final String fileName;


    public MyReader(String fileName) {
        this.fileName = fileName;
    }

    public String read() {
        int current;
        StringBuilder buffer = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            current = reader.read();

            while (current != -1) {
                buffer.append( (char) current);

                current = reader.read();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Reader issue: " + e.getMessage());
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
