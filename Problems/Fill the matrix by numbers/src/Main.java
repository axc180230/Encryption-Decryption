import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int currentStart = 0;
        int[][] matrix = new int[input][input];

        /*
        idea: fill out top row, followed by filling out left column
        than down one row (ignoring any previously filled out columns)
        and right over one column (ignoring any previously filled out
        rows). Repeat until finished (while limiting at input max length)
        */
        for (int row = 0; row < input; row++) {
            // filling out row
            for (int placeInRow = currentStart; placeInRow < input; placeInRow++) {
                matrix[row][placeInRow] = placeInRow - currentStart;
            }

            // filling out col
            for (int placeInCol = currentStart; placeInCol < input; placeInCol++) {
                matrix[placeInCol][row] = placeInCol - currentStart;
            }

            currentStart++;
        }

        for (int[] rows: matrix) {
            for (int value: rows) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}