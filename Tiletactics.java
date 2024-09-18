
/**
 * TileTactics.java - A console-based 2048 game implementation in Java.
 * This class handles the game logic, user input, and board updates.
 * The objective is to combine tiles to create a tile with the value of 2048.
 * Author - Ritika Suman ; Date - 16th Sep 2024
 */

import java.util.Random;
import java.util.Scanner;

public final class Tiletactics {
    private int score = 0;
    public static final int SIZE = 4;
    private final int[][] board = new int[SIZE][SIZE];
    private final Random randomGenerator = new Random();
    private boolean gameWon = false;

    public static void main(String[] args) {
        Tiletactics game = new Tiletactics();
        game.playGame();
    }

    // Constructor - Initializes the game board with two random tiles
    public Tiletactics() {
        addRandomTile();
        addRandomTile();
    }

    // Display the game board in a formatted way
    public void displayBoard() {
        System.out.println("----------");
        System.out.println("|Score: " + score + "|");
        System.out.println("---------- ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("------");
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {

            System.out.print("|");
            for (int column = 0; column < SIZE; column++) {
                System.out.print("     |");
            }
            System.out.println();
            System.out.print("|");
            for (int column = 0; column < SIZE; column++) {
                System.out.printf(" %-4s|", board[row][column] == 0 ? "" : board[row][column]);
            }
            System.out.println();

            System.out.print("|");
            for (int column = 0; column < SIZE; column++) {
                System.out.print("     |");
            }
            System.out.println();

            for (int column = 0; column < SIZE; column++) {
                System.out.print("------");
            }
            System.out.println();
        }
    }

    // Add a random tile (either 2 or 4) to an empty spot on the board
    // output - Updates the board with a random tile
    public void addRandomTile() {
        int rowIndex, columnIndex;
        do {
            rowIndex = randomGenerator.nextInt(SIZE);
            columnIndex = randomGenerator.nextInt(SIZE);
        } while (board[rowIndex][columnIndex] != 0);
        board[rowIndex][columnIndex] = (randomGenerator.nextInt(10) < 9) ? 2 : 4;
    }

    // Shift tiles left and merge if possible
    // output - Moves and merges tiles to the left
    public void moveLeft() {
        for (int row = 0; row < SIZE; row++) {
            int[] compressedRow = new int[SIZE];
            int insertPosition = 0;

            for (int column = 0; column < SIZE; column++) {
                if (board[row][column] != 0) {
                    compressedRow[insertPosition++] = board[row][column];
                }
            }

            for (int i = 0; i < insertPosition - 1; i++) {
                if (compressedRow[i] == compressedRow[i + 1]) {
                    int mergedValue = compressedRow[i] * 2;
                    compressedRow[i] = mergedValue;
                    compressedRow[i + 1] = 0;
                    score += mergedValue;
                    if (mergedValue == 2048)
                        gameWon = true;
                    i++;
                }
            }

            int[] newRow = new int[SIZE];
            int newIndex = 0;
            for (int value : compressedRow) {
                if (value != 0) {
                    newRow[newIndex++] = value;
                }
            }
            board[row] = newRow;
        }
    }

    // Shift tiles right and merge if possible
    // output - Moves and merges tiles to the right
    public void moveRight() {
        for (int row = 0; row < SIZE; row++) {
            int[] compressedRow = new int[SIZE];
            int insertPosition = SIZE - 1;

            for (int columnumn = SIZE - 1; columnumn >= 0; columnumn--) {
                if (board[row][columnumn] != 0) {
                    compressedRow[insertPosition--] = board[row][columnumn];
                }
            }

            for (int i = SIZE - 1; i > insertPosition + 1; i--) {
                if (compressedRow[i] == compressedRow[i - 1]) {
                    compressedRow[i] *= 2;
                    compressedRow[i - 1] = 0;
                    if (compressedRow[i] == 2048)
                        gameWon = true;
                    i--;
                }
            }

            int[] newRow = new int[SIZE];
            int newIndex = SIZE - 1;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (compressedRow[i] != 0) {
                    newRow[newIndex--] = compressedRow[i];
                }
            }
            board[row] = newRow;
        }
    }

    // Shift tiles up and merge if possible
    // output - Moves and merges tiles upwards
    public void moveUp() {
        for (int columnumn = 0; columnumn < SIZE; columnumn++) {
            int[] compressedcolumnumnumn = new int[SIZE];
            int insertPosition = 0;

            for (int row = 0; row < SIZE; row++) {
                if (board[row][columnumn] != 0) {
                    compressedcolumnumnumn[insertPosition++] = board[row][columnumn];
                }
            }

            for (int i = 0; i < insertPosition - 1; i++) {
                if (compressedcolumnumnumn[i] == compressedcolumnumnumn[i + 1]) {
                    compressedcolumnumnumn[i] *= 2;
                    compressedcolumnumnumn[i + 1] = 0;
                    if (compressedcolumnumnumn[i] == 2048)
                        gameWon = true;
                    i++;
                }
            }

            int[] newcolumnumnumn = new int[SIZE];
            int newIndex = 0;
            for (int value : compressedcolumnumnumn) {
                if (value != 0) {
                    newcolumnumnumn[newIndex++] = value;
                }
            }
            for (int row = 0; row < SIZE; row++) {
                board[row][columnumn] = newcolumnumnumn[row];
            }
        }
    }

    // Shift tiles down and merge if possible
    // output - Moves and merges tiles downwards
    public void moveDown() {
        for (int columnumn = 0; columnumn < SIZE; columnumn++) {
            int[] compressedcolumnumnumn = new int[SIZE];
            int insertPosition = SIZE - 1;

            for (int row = SIZE - 1; row >= 0; row--) {
                if (board[row][columnumn] != 0) {
                    compressedcolumnumnumn[insertPosition--] = board[row][columnumn];
                }
            }

            for (int i = SIZE - 1; i > insertPosition + 1; i--) {
                if (compressedcolumnumnumn[i] == compressedcolumnumnumn[i - 1]) {
                    compressedcolumnumnumn[i] *= 2;
                    compressedcolumnumnumn[i - 1] = 0;
                    if (compressedcolumnumnumn[i] == 2048)
                        gameWon = true;
                    i--;
                }
            }

            int[] newcolumnumnumn = new int[SIZE];
            int newIndex = SIZE - 1;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (compressedcolumnumnumn[i] != 0) {
                    newcolumnumnumn[newIndex--] = compressedcolumnumnumn[i];
                }
            }
            for (int row = 0; row < SIZE; row++) {
                board[row][columnumn] = newcolumnumnumn[row];
            }
        }
    }

    // Check if the game is over (no valid moves)
    // return - Boolean (true if no moves are left, false otherwise)
    public boolean isGameOver() {
        for (int row = 0; row < SIZE; row++) {
            for (int columnumn = 0; columnumn < SIZE; columnumn++) {
                if (board[row][columnumn] == 0)
                    return false;
                if (columnumn < SIZE - 1 && board[row][columnumn] == board[row][columnumn + 1])
                    return false;
                if (row < SIZE - 1 && board[row][columnumn] == board[row + 1][columnumn])
                    return false;
            }
        }
        return true;
    }

    // Main game loop, handles user input and moves
    // output - Plays the game until won or lost
    public void playGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (!gameWon && !isGameOver()) {
                clearConsole(); // Clear the screen
                displayBoard();
                System.out.println("Use W (up), A (left), S (down), D (right) to move:");
                char move = scanner.next().charAt(0);

                switch (move) {
                    case 'w', 'W' -> moveUp();
                    case 'a', 'A' -> moveLeft();
                    case 's', 'S' -> moveDown();
                    case 'd', 'D' -> moveRight();
                    default -> {
                        System.out.println("Invalid input! Use W, A, S, or D.");
                        continue;
                    }
                }
                addRandomTile(); 
            }
        }
        clearConsole(); 

        displayBoard();
        if (gameWon) {
            System.out.println("Congratulations! You reached 2048!");
        } else {
            System.out.println("Game Over");
        }
        System.out.println("Final Score: " + score); 
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
