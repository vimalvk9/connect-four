import java.util.Scanner;

public class Game {

    private final Board board;
    private Boolean gameOver;
    private Integer turn;

    public Game() {
        board = new Board();
        gameOver = Boolean.FALSE;
        turn = 0;
    }

    public void startGame() {

        Scanner scanner = new Scanner(System.in);
        Integer selectedCol = null;

        while(isGameOver() == Boolean.FALSE) {

            if (turn == 0) {
                // player 1 turn
                System.out.println("Player 1 make your selection (0-6)");
                selectedCol = scanner.nextInt();
                processMove(selectedCol, 1);
                if (board.checkWinningMove(1)) {
                    System.out.println("Player 1 wins");
                    return;
                }
            }
            else {
                // player 2 turn
                System.out.println("Player 2 make your selection (0-6)");
                selectedCol = scanner.nextInt();
                processMove(selectedCol, 2);
                if (board.checkWinningMove(2)) {
                    System.out.println("Player 2 wins");
                    return;
                }
            }

            board.printBoard();
            updateTurn(turn);
        }

    }

    public void processMove(int selectedCol, int piece) {
        if (board.isValidLocation(selectedCol)) {
            int nextRow = board.getNextRow(selectedCol);
            if (nextRow != -1) {
                board.dropPiece(nextRow, selectedCol, piece);
            }
        }
        else {
            printInvalidMove();
        }
    }

    public void printInvalidMove() {
        System.out.println("Move is invalid");
    }

    public Board getBoard() {
        return board;
    }

    public Boolean isGameOver() {
        return gameOver == Boolean.TRUE || turn > 42;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Integer getTurn() {
        return turn;
    }

    private void updateTurn(Integer turn) {
        this.turn = 1 - turn;
    }
}
