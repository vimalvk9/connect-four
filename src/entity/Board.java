public class Board {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final int MATCH_COUNT = 4;

    private int matrix[][];

    Board() {
        matrix = new int[ROWS][COLUMNS];
    }


    public void dropPiece(int row, int col, int piece) {
        matrix[row][col] = piece;
    }

    public boolean isValidLocation(int col) {
        return matrix[ROWS-1][col] == 0;
    }

    public Integer getNextRow(int col) {
        for(int i=0; i<ROWS; i++) {
            if (matrix[i][col] == 0) {
                return i;
            }
        }

        return -1;
    }
