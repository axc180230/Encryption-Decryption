class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        // write your code here
        StringBuilder stringBuilder = new StringBuilder("A");

        for (int i = 1; i < 26; i++) {
            stringBuilder.append(" ");
            stringBuilder.append((char) (65 + i));
        }

        return stringBuilder;
    }

    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}