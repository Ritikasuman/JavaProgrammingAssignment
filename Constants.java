/**
 * Constants.java - A class that holds constant values for the 2048 game implementation.
 * Author: Ritika Suman
 * This class includes game configuration, sound file paths, color codes, and messages for user interactions.
 */

public final class Constants {
    public static final int MIN_SIZE = 4;
    public static final int MAX_SIZE = 10;
    public static final int INITIAL_TILES = 2;
    public static final int TARGET_TILE = 2048;
    public static final String MOVE_SOUND = "move.wav";
    public static final String WIN_SOUND = "win.wav";
    public static final String GAME_OVER_SOUND = "gameover.wav";
    public static final String SOUND_FILE_PATH = "D:\\Coding\\CodeUp Stuff\\week3Assignment\\";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_LIGHT_YELLOW = "\u001B[93m";
    public static final String COLOR_LIGHT_PURPLE = "\u001B[95m";
    public static final String COLOR_LIGHT_CYAN = "\u001B[96m";
    public static final String COLOR_LIGHT_RED = "\u001B[91m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String GRID_INPUT = "Enter an Integer Size of Game (4-10):";
    public static final String INVALID_SIZE = "Invalid size! Please enter a size between 4 and 10.";
    public static final String INVALID_INPUT = "Invalid input! Please enter a valid integer.";
     public static final String RULES = "Use W (up), A (left), S (down), D (right) to move:";
     public static final String OVER_RULED = "Invalid input! Use W, A, S, or D.";
     public static final String WIN = "Congratulations! You reached 2048!";

    private Constants() {}

}
