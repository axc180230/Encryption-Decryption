import java.nio.charset.StandardCharsets;
import java.util.*;
//import java.lang.CharSequence;

class AsciiCharSequence implements CharSequence {

    byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) (bytes[index] & 0xFF);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] temp = new byte[end - start];

        if (end - start >= 0) {
            System.arraycopy(bytes, start, temp,
                    0, end - start);
        }

        return new AsciiCharSequence(temp);
    }

    @Override
    public String toString() {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
