package encryptdecrypt;

public class MyParser {
    private String[] arguments;
    private int key;
    private String data;
    private String inFileName;
    private String outFileName;
    private String algorithm;
    private String mode;

    public MyParser(String[] arguments) {
        mode = getValueFromKey(arguments, "-mode", "enc");
        key = Integer.parseInt(
                getValueFromKey(arguments, "-key", "0"));
        data = getValueFromKey(arguments, "-data");
        inFileName = getValueFromKey(arguments, "-in");
        outFileName = getValueFromKey(arguments, "-out");
        algorithm = getValueFromKey(arguments, "-alg");
    }

    static String getValueFromKey(String[] args, String key) {
        String value = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(key)) {
                value = args[i + 1];
                break;
            }
        }

        return value;
    }

    static String getValueFromKey(String[] args, String key, String defaultValue) {
        String value = defaultValue;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(key)) {
                value = args[i + 1];
                break;
            }
        }

        return value;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getInFileName() {
        return inFileName;
    }

    public String getOutFileName() {
        return outFileName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getMode() {
        return mode;
    }
}
