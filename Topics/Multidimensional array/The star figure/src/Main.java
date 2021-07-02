import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] matrix = new char[n][n];
        char backgroundChar = '.';
        char starChar = '*';

        // populating with initial value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = backgroundChar;
            }
        }

        // fill star pattern
        for (int i = 0; i < n; i++) {
            matrix[i][n / 2] = starChar;
            matrix[n / 2][i] = starChar;
            matrix[i][i] = starChar;
            matrix[i][Math.abs(n - i - 1)] = starChar;
        }

        for (char[] chars : matrix) {
            for (char symbol : chars) {
                System.out.print(symbol + " ");
            }

            System.out.println();
        }
    }
}