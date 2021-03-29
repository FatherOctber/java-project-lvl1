package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private static final Scanner IN = new Scanner(System.in);

    protected void finalize() throws Throwable {
        super.finalize();
        IN.close();
    }

    public static String input(final String welcomeMsg) {
        System.out.print(welcomeMsg);
        return IN.nextLine();
    }
}
