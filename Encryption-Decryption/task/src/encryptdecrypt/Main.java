package encryptdecrypt;

public class Main {
    private static String data;
    private static MyParser parser;

    public static void main(String[] args) {
        parser = new MyParser(args);

        if (parser.getMode().equalsIgnoreCase("enc") &&
                parser.getAlgorithm().equalsIgnoreCase("unicode")) {
            outputMessage(unicodeEncryptDataFromSource());

        } else if (parser.getMode().equalsIgnoreCase("enc")) {
            outputMessage(shiftEncryptDataFromSource());

        } else if (parser.getMode().equalsIgnoreCase("dec") &&
                parser.getAlgorithm().equalsIgnoreCase("unicode")) {
            outputMessage(unicodeDecryptDataFromSource());

        } else if (parser.getMode().equalsIgnoreCase("dec")) {
            outputMessage(shiftDecryptDataFromSource());
        } else {
            System.out.println("Not a valid choice (enc, dec).");
        }
    }

    static void outputMessage(String inMessage) {
        if (outFileName.length() > 0) {
            // write encrypted message to file
            MyWriter writer = new MyWriter("./" + outFileName);
            writer.write(inMessage);
        } else {
            System.out.println(inMessage);
        }
    }

    static String unicodeEncryptDataFromSource() {
        String result;

        if (data.length() > 0) {
            // get data from command line argument
            result = encryptAllWithShifting(data, key);
        } else if (inFileName.length() > 0) {
            // get data from file
            MyReader reader = new MyReader("./" + inFileName);
            data = reader.read();
            result = encryptAllWithShifting(data, key);
        } else {
            result = "";
        }

        return result;
    }

    static String shiftEncryptDataFromSource() {
        String result;

        if (data.length() > 0) {
            // get data from command line argument
            result = encryptLettersWithShifting(data, key);
        } else if (inFileName.length() > 0) {
            // get data from file
            MyReader reader = new MyReader("./" + inFileName);
            data = reader.read();
            result = encryptLettersWithShifting(data, key);
        } else {
            result = "";
        }

        return result;
    }

    static String unicodeDecryptDataFromSource() {
        String result;

        if (data.length() > 0) {
            // get data from command line argument
            result = encryptAllWithShifting(data, -key);
        } else if (inFileName.length() > 0) {
            // get data from file
            MyReader reader = new MyReader("./" + inFileName);
            data = reader.read();
            result = encryptAllWithShifting(data, -key);
        } else {
            result = "";
        }

        return result;
    }

    static String shiftDecryptDataFromSource() {
        String result;

        if (data.length() > 0) {
            // get data from command line argument
            result = encryptLettersWithShifting(data, -key);
        } else if (inFileName.length() > 0) {
            // get data from file
            MyReader reader = new MyReader("./" + inFileName);
            data = reader.read();
            result = encryptLettersWithShifting(data, -key);
        } else {
            result = "";
        }

        return result;
    }

    static String encryptLettersWithShifting(String message, int key) {
        StringBuilder str = new StringBuilder();

        if (Math.abs(key) > 26) {
            key = key % 26;
        }

        if (key >= 0){
            for (int i = 0; i < message.length(); i++) {
                char currentLetter = message.charAt(i);
                str.append(shiftLettersWithPositiveKey(currentLetter, key));
            }
        } else { // Key is negative
            for (int i = 0; i < message.length(); i++) {
                char currentLetter = message.charAt(i);
                str.append(shiftLettersWithNegativeKey(currentLetter, key));
            }
        }

        return str.toString();
    }

    static char shiftLettersWithPositiveKey(char currentLetter, int key) {
        char newLetter;

        if (currentLetter >= 97 && currentLetter <= 122){
            if (key + currentLetter > 122) {
                newLetter = (char) (currentLetter - 26 + key);
            } else {
                newLetter = (char) (key + currentLetter);
            }

        } else if (currentLetter >= 65 && currentLetter <= 90) {
            if (key + currentLetter > 90) {
                newLetter = (char) (currentLetter - 26 + key);
            } else {
                newLetter = (char) (key + currentLetter);
            }

        } else {
            newLetter = currentLetter;
        }

        return newLetter;
    }

    static char shiftLettersWithNegativeKey(char currentLetter, int key) {
        char newLetter;

        if (currentLetter >= 97 && currentLetter <= 122){
            if ( currentLetter + key < 97) {
                newLetter = (char) (currentLetter + 26 + key);
            } else {
                newLetter = (char) (key + currentLetter);
            }

        } else if (currentLetter >= 65 && currentLetter <= 90) {
            if (currentLetter + key < 65) {
                newLetter = (char) (currentLetter + 26 + key);
            } else {
                newLetter = (char) (key + currentLetter);
            }

        } else {
            newLetter = currentLetter;
        }

        return newLetter;
    }

    static String encryptAllWithShifting(String message, int key) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentLetter = message.charAt(i);
            str.append((char) (key + currentLetter));
        }

        return str.toString();
    }

}