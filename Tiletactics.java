/**
 * TileTactics.java - A console-based 2048 game implementation in Java.
 * This class handles the game logic, user input, and board updates.
 * The objective is to combine tiles to create a tile with the value of 2048.
 * Author - Ritika Suman ; Date - 16th Sep 2024
 */
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.*;

public final class Tiletactics {
    private int score = 0;
    public static int SIZE;
    private final int[][] board = new int[SIZE][SIZE];
    private final Random randomGenerator = new Random();
    private boolean gameWon = false;

    public static void main(String[] args) {
      while(true){
        try (Scanner scanner = new Scanner(System.in)) {
            int size = 0;
            while (true) {
                System.out.println(Constants.GRID_INPUT);
                if (scanner.hasNextInt()) {
                    size = scanner.nextInt();
                    if (size > 3 && size <= 10) {
                        SIZE = size;
                        Tiletactics game = new Tiletactics();
                        game.playGame();
                        break;
                    } else {
                        System.out.println(Constants.INVALID_SIZE);
                    }
                } else {
                    System.out.println(Constants.INVALID_INPUT);
                    scanner.next();
                 }
              }
            }
        }
    }

    // Main game loop, handles user input and moves
    // output - Plays the game until won or lost
    public void playGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (!gameWon && !isGameOver()) {
                clearConsole();
                System.out.println("╔════════════════════════════════════╗");
                System.out.println("║             LET'S GO!              ║");
                System.out.println("╠════════════════════════════════════╣");
                System.out.println("║   Ready to conquer TileTactics?    ║");
                System.out.println("║        Let's make some moves!      ║");
                System.out.println("╚════════════════════════════════════╝");
                displayBoard();
                System.out.println(Constants.RULES);
                char move = scanner.next().charAt(0);
                switch (move) {
                    case 'w', 'W' -> moveUp();
                    case 'a', 'A' -> moveLeft();
                    case 's', 'S' -> moveDown();
                    case 'd', 'D' -> moveRight();
                    default -> {
                        System.out.println(Constants.OVER_RULED);
                        continue;
                    }
                }
                addRandomTile();
                playSound(Constants.MOVE_SOUND);
            }
        }
        clearConsole();
        displayBoard();
        if (gameWon) {
            System.out.println(Constants.WIN);
            playSound(Constants.WIN_SOUND);
        } else {
            System.out.println("╔═════════════╗");
            System.out.println("║  GAME OVER  ║");
            System.out.println("╚═════════════╝");
            playSound(Constants.GAME_OVER_SOUND);
        }
        System.out.println("Final Score: " + score);
    }

    // Constructor - Initializes the game board with two random tiles
    public Tiletactics() {
        addRandomTile();
        addRandomTile();
    }

    // clear the console when called
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Display the game board in a formatted way
    public void displayBoard() {
        System.out.println("----------");
        System.out.println("|Score: " + score + "|");
        System.out.println("----------");

        for (int row = 0; row < SIZE; row++) {
            System.out.print("┌");
            for (int column = 0; column < SIZE; column++) {
                System.out.print("──────┬");
            }
            System.out.println();

            System.out.print("|");
            for (int column = 0; column < SIZE; column++) {
                String tileDisplay = board[row][column] == 0 ? " " : getColoredTile(board[row][column]);
                System.out.printf("  %s   |", tileDisplay);
            }
            System.out.println();

            System.out.print("|");
            for (int column = 0; column < SIZE; column++) {
                System.out.print("      |");
            }
            System.out.println();

            if (row < SIZE - 1) {
                System.out.print("├");
                for (int column = 0; column < SIZE; column++) {
                    System.out.print("──────┼");
                }
                System.out.println();
            }
        }

        System.out.print("└");
        for (int column = 0; column < SIZE; column++) {
            System.out.print("──────┴");
        }
        System.out.println();
    }

    // for giving colour to the values
    // Input: the tile value to be colored
    public String getColoredTile(int value) {
        return switch (value) {
            case 2 -> Constants.COLOR_BLUE + value + Constants.COLOR_RESET;
            case 4 -> Constants.COLOR_GREEN + value + Constants.COLOR_RESET;
            case 8 -> Constants.COLOR_YELLOW + value + Constants.COLOR_RESET;
            case 16 -> Constants.COLOR_RED + value + Constants.COLOR_RESET;
            case 32 -> Constants.COLOR_PURPLE + value + Constants.COLOR_RESET;
            case 64 -> Constants.COLOR_CYAN + value + Constants.COLOR_RESET;
            case 128 -> Constants.COLOR_LIGHT_YELLOW + value + Constants.COLOR_RESET;
            case 256 -> Constants.COLOR_LIGHT_PURPLE + value + Constants.COLOR_RESET;
            case 512 -> Constants.COLOR_LIGHT_CYAN + value + Constants.COLOR_RESET;
            case 1024 -> Constants.COLOR_LIGHT_RED+ value + Constants.COLOR_RESET;
            case 2048 -> Constants.COLOR_LIGHT_GREEN + value + Constants.COLOR_RESET;
            default -> value == 0 ? "" : Integer.toString(value);
        };
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

            for (int column = SIZE - 1; column >= 0; column--) {
                if (board[row][column] != 0) {
                    compressedRow[insertPosition--] = board[row][column];
                }
            }

            for (int i = SIZE - 1; i > insertPosition + 1; i--) {
                if (compressedRow[i] == compressedRow[i - 1]) {
                    compressedRow[i] *= 2;
                    compressedRow[i - 1] = 0;
                    score += compressedRow[i];
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
        for (int column = 0; column < SIZE; column++) {
            int[] compressedColumn = new int[SIZE];
            int insertPosition = 0;

            for (int row = 0; row < SIZE; row++) {
                if (board[row][column] != 0) {
                    compressedColumn[insertPosition++] = board[row][column];
                }
            }

            for (int i = 0; i < insertPosition - 1; i++) {
                if (compressedColumn[i] == compressedColumn[i + 1]) {
                    compressedColumn[i] *= 2;
                    compressedColumn[i + 1] = 0;
                    score += compressedColumn[i];
                    if (compressedColumn[i] == 2048)
                        gameWon = true;
                    i++;
                }
            }

            int[] newColumn = new int[SIZE];
            int newIndex = 0;
            for (int value : compressedColumn) {
                if (value != 0) {
                    newColumn[newIndex++] = value;
                }
            }
            for (int row = 0; row < SIZE; row++) {
                board[row][column] = newColumn[row];
            }
        }
    }

    // Shift tiles down and merge if possible
    // output - Moves and merges tiles downwards
    public void moveDown() {
        for (int column = 0; column < SIZE; column++) {
            int[] compressedColumn = new int[SIZE];
            int insertPosition = SIZE - 1;

            for (int row = SIZE - 1; row >= 0; row--) {
                if (board[row][column] != 0) {
                    compressedColumn[insertPosition--] = board[row][column];
                }
            }

            for (int i = SIZE - 1; i > insertPosition + 1; i--) {
                if (compressedColumn[i] == compressedColumn[i - 1]) {
                    compressedColumn[i] *= 2;
                    compressedColumn[i - 1] = 0;
                    score += compressedColumn[i];
                    if (compressedColumn[i] == 2048)
                        gameWon = true;
                    i--;
                }
            }

            int[] newColumn = new int[SIZE];
            int newIndex = SIZE - 1;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (compressedColumn[i] != 0) {
                    newColumn[newIndex--] = compressedColumn[i];
                }
            }
            for (int row = 0; row < SIZE; row++) {
                board[row][column] = newColumn[row];
            }
        }
    }

    // Check if the game is over (no valid moves)
    // return - Boolean (true if no moves are left, false otherwise)
    public boolean isGameOver() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (board[row][column] == 0)
                    return false;
                if (column < SIZE - 1 && board[row][column] == board[row][column + 1])
                    return false;
                if (row < SIZE - 1 && board[row][column] == board[row + 1][column])
                    return false;
            }
        }
        return true;
    }

    // To play sound based on the file path provided
    public void playSound(String soundFileName) {
        try {
            String soundFilePath = Constants.SOUND_FILE_PATH + soundFileName;
            File soundFile = new File(soundFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

