public class CinemasRoom {

    final static int openSeatSymbol = 0;
    final static int takenSeatSymbol = 1;

    int rows;
    int columns;
    int[][] seats;

    public CinemasRoom(int rows, int columns) {
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
