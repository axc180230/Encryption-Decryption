import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                arr[row][col] = scanner.nextInt();
            }
        }

        int[][] newArr = new int[m][n];
        int newCol = 0;
        int newRow = n - 1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                newArr[row][col] = arr[newRow--][newCol];
            }
            newRow = n - 1;
            newCol++;
        }

        for (int[] row: newArr) {
            for (int value: row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}