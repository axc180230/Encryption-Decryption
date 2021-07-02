import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

        int maxLengthOfAsc = 1;
        int currentLength = 1;
        int previousValue = scanner.nextInt();

        while (scanner.hasNext()) {
            int currentValue = scanner.nextInt();

            if (currentValue > previousValue) {
                if (++currentLength > maxLengthOfAsc) {
                    maxLengthOfAsc = currentLength;
                }

                previousValue = currentValue;
            }
        }

        System.out.println(maxLengthOfAsc);
    }
}