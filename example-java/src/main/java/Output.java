import java.util.Arrays;

public class Output {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String INVALID_INPUT = "Invalid input";

    public static boolean LoggingEnabled = false;

    public static void log(String message) {
        if (LoggingEnabled)
            print(message, "", ANSI_YELLOW, false);
    }

    public static void message(String message) {
        print(message, "", ANSI_BLUE, false);
    }

    public static void success(String message) {
        print(message, "", ANSI_GREEN, false);
    }

    public static void error(String message) {
        print(message, "", ANSI_RED, true);
    }

    private static void print(String message, String bgColor, String textColor, boolean forceExit) {
        System.out.println(bgColor + textColor + message + ANSI_RESET);
        if (forceExit)
            System.exit(0);
    }
}
