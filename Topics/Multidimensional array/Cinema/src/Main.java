import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        //System.out.println(row);
        //System.out.println(col);

        CinemaRoom cinemaRoom = new CinemaRoom(row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cinemaRoom.setSeat(i, j, scanner.nextInt());
            }
        }

        int openSeatsNeeded = scanner.nextInt();
        System.out.println(
                cinemaRoom.findOpenSeatsInRow(openSeatsNeeded)
        );

    }
}

class CinemaRoom {

    final static int openSeatSymbol = 0;
    final static int takenSeatSymbol = 1;

    int rows;
    int columns;
    int[][] seats;

    public CinemaRoom(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = new int[rows][columns];
    }

    public void setSeat(int row, int column, int value) {
        seats[row][column] = value;
    }

    public int getSeatStatus(int row, int column) {
        return seats[row][column];
    }

    public int findOpenSeatsInRow (int seatsNeeded) {
        int suitableRow = 0;
        int openSeatsSoFar = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (getSeatStatus(row, col) == openSeatSymbol) {
                    openSeatsSoFar++;

                    if (openSeatsSoFar >= seatsNeeded) {
                        suitableRow = row + 1;
                        break;
                    }
                } else {
                    openSeatsSoFar = 0;
                }
            }

            openSeatsSoFar = 0;
        }

        return suitableRow;
    }
}
